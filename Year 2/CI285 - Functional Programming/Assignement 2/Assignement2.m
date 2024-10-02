%clears the console, workspace, variables and turns off any warnings that
%interupt the code.
clc; 
clear;
close all;
warning('off','all')
 
%load images and builds the file spec
buildingDir = fullfile(toolboxdir('vision'), 'visiondata', 'building'); 
buildingScene = imageDatastore('.\images');
montage(buildingScene)                                                      %displays the images that will be stitched together.

%reads in the first image from the image set.
I = readimage(buildingScene, 1);

%initialises the features for I(1).
grayImage = rgb2gray(I);
points = detectSURFFeatures(grayImage, 'MetricThreshold', 500);
[features1, points1] = extractFeatures(grayImage, points);

%initialises all the transforms to the identity matrix.
numImages = numel(buildingScene.Files);
tforms(numImages) = affine2d();

%initialize variable to hold image sizes.
imageSize = zeros(numImages,2);
 
overlap = 1;  
 
while numel(overlap) < numImages * 4.5                         
    for n = 1 : numImages
        
        %converts the image to gray scale.
        I = readimage(buildingScene, n);
        grayImage = rgb2gray(I);
        
        %saves the img size.
        imageSize(n, :) = size(grayImage);
        
        %detects & extracts the SURF points / features for I(n).
        points = detectSURFFeatures(grayImage, 'MetricThreshold', 500);
        [features, points] = extractFeatures(grayImage, points);
 
        %finds the corresponding features between I(n) and I(n-1).
        indexPairs = matchFeatures(features, features1, 'Unique', true);
        matchedPoints = points(indexPairs(:,1), :);
        matchedPointsPrev = points1(indexPairs(:,2), :);
 
         if matchedPoints.Count > 11
            %estimates the transformation between I(n) and I(n-1).
            overlap = [overlap n];
            tforms(n) = estimateGeometricTransform(matchedPoints, ...
            matchedPointsPrev, 'affine', 'Confidence', ...
            99.9, 'MaxNumTrials', 2000);
         end      
    end
 
        percentageCompleted = (numel(overlap) / (numImages * 4.5)) *100;
        
        if numel(overlap) < numImages * 4.5
           disp(percentageCompleted + "% completed");
        end
        
        if numel(overlap) >= numImages * 4.5                              
            disp('Final touchings being made');
        end
    
    %all tforms are currently relative to first image.
    %computes the output limits for each transformation.
    for i = 1:numel(tforms)          
        [xlim(i, :), ylim(i, :)] = outputLimits(tforms(i), ... 
        [1 imageSize(i, 2)], [1 imageSize(i, 1)]);
    end
 
    %computers the avg X limits for each transform and find the image that
    %is the center piece. only X limits are used as the img is horizontal.
    avgXLim = mean(xlim, 2);
    [~, idx] = sort(avgXLim);
    centerImg = floor((numel(tforms) + 1) / 2);
    centerImageIdx = idx(centerImg);
    
    %applies center image's inverse transformation to all others.
    Tinv = invert(tforms(centerImageIdx));
    for i = 1 : numel(tforms)
        tforms(i).T = tforms(i).T * Tinv.T;
    end

    %this function creates an initial, empty panorama for the images to be
    %mapped in.
    for i = 1:numel(tforms)
        [xlim(i, :), ylim(i, :)] = outputLimits(tforms(i), ... 
        [1 imageSize(i, 2)], [1 imageSize(i, 1)]);
    end

    %finds the minimum and maximum output limits of the x & y co-ordinates.
    maxImageSize = max(imageSize);
    xMin = min([1; xlim(:)]);
    xMax = max([maxImageSize(2); xlim(:)]);
    yMin = min([1; ylim(:)]);
    yMax = max([maxImageSize(1); ylim(:)]);

    %this is the width and height of the panoram.
    width  = round(xMax - xMin);
    height = round(yMax - yMin);

    %initialises the above mentioned empty panoram.
    panorama = zeros([height width 3], 'like', I);

    %using "imwarp" to map images into the panorama and then uses
    %"vision.AlphaBlender" to overlay the images together.
    blender = vision.AlphaBlender('Operation', 'Binary mask', ...
        'MaskSource', 'Input port');

    %a 2D spatial reference is created for reference of objects which defines
    %the size of the panorama.
    xLimits = [xMin xMax];                                          
    yLimits = [yMin yMax];
    panoramaView = imref2d([height width], xLimits, yLimits);

    %creates the panorama.
    for i = overlap
        I = readimage(buildingScene, i);
        %transforms I into the panorama.
        warpedImage = imwarp(I, tforms(i), 'OutputView', panoramaView);
        %creates a binary mask.
        mask = imwarp(true(size(I,1),size(I,2)), tforms(i), ...
            'OutputView', panoramaView);
        %overlays the wrapedImage onto the panoram.
        panorama = step(blender, panorama, warpedImage, mask);
        imshow(panorama)
    end

    grayImage = rgb2gray(panorama);
    points = detectSURFFeatures(grayImage, 'MetricThreshold', 500);
    [features1, points1] = extractFeatures(grayImage, points); 

end