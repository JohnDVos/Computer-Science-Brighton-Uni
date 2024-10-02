%declares variables for each image.
penguin = imread('Penguins.jpg');
img1 = imread('img1.jpg');
img2 = imread('img2.jpg');

%resizes img2 to the same size as img1.
jResize = imresize(img2, [768, 1024]);

%extract the individual red, green & blue colour channels;
redChannel = jResize(:, :, 1);
greenChannel = jResize(:, :, 2);
blueChannel = jResize(:, :, 3);

%function to denoise resized img2.
denoisedRedChannel = wiener2(redChannel,[9 9]);
denoisedGreenChannel = wiener2(greenChannel,[9 9]);
denoisedBlueChannel = wiener2(blueChannel,[9 9]);

%recombine seperate colour channels into an RGB image.
jResize = cat(3, denoisedRedChannel, denoisedGreenChannel, denoisedBlueChannel);

%a nested for loop to find the white space in the img1.
for i = 1:size(img1, 1)
    for j = 1:size(img1, 2)
        %an if loop to run throught the rgb scale.
        if img1(i, j) > 253
            img1(i, j, 1) = jResize(i, j, 1);
            img1(i, j, 2) = jResize(i, j, 2);
            img1(i, j, 3) = jResize(i, j, 3);
        end
    end
end

%calculates the similarity.
sum1 = abs(img1-penguin);
%calculation to find out percentage of difference (at =4.7491).
percentageDifference = sum(sum1(:))/2359296;
%2359296 derived from 768x1024x3
finalsum = sum(sum1(:)) / 2359296;

