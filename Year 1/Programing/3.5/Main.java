public class Main extends BIO 
{   
    public static void main(String[] args)
    {
        System.out.println("#Enter Width: ");
        int width = BIO.getInt();
        System.out.println("#Enter line of text: ");
        String line = BIO.getString();

        while(!line.equals("END")){
            line = reformat(line, width);
            if(line.length()>0)
            {
                System.out.println(line.replace(" ", "."));
            }
            System.out.println("#Enter line of text: ");
            line = BIO.getString();
        }
    }
    
    public static int countSpaces(String line){
        return line.length() - line.replaceAll(" ", "").length();
    }

    public static String stringOfSpaces(String line, int num){
        while(num > 0){
            line = addExtraSpaces(line, num);
            num--;
        }
        return line;
    }
    
    public static String stringOfSpacesMoreThanWidth(String line, int width)
    {
        String formatedString = "";
        int lastIndexOfSpace = line.lastIndexOf(" ");
        int currentIndex = 0;
        do{
            String lineOfCurrentWidth = "";
            if(line.length() <= width){
                lineOfCurrentWidth = line;
                currentIndex = lastIndexOfSpace + 1;
            }
            else
                lineOfCurrentWidth = line.substring(0, (width));

            String stringToAddSpace = "";
            if(line.length() <= width){
                stringToAddSpace = lineOfCurrentWidth;
            }
            else{
                stringToAddSpace = lineOfCurrentWidth.substring(0, lineOfCurrentWidth.lastIndexOf(" ") + 1);
                currentIndex = currentIndex + lineOfCurrentWidth.lastIndexOf(" ") + 1;
                line = line.substring(lineOfCurrentWidth.lastIndexOf(" ") + 1);  
            }

            String forArray = "";
            forArray = stringOfSpaces(stringToAddSpace.trim(), width-stringToAddSpace.trim().length());
            formatedString = formatedString + forArray + System.getProperty("line.separator"); 
            if(!line.contains(" ")){
                line = " " + line;
                forArray = stringOfSpaces(line, width-line.length());
                formatedString = formatedString + forArray + System.getProperty("line.separator"); 
            }
        }while(currentIndex <= lastIndexOfSpace);
        
        return formatedString;
    }

    public static String addExtraSpaces(String line, int extra){
        if(extra > 0)
            return line.replaceFirst(" ", "  ");
        else
            return "";
    }

    public static String reformat(String line, int width)
    {
        String formatedString = null;
        if(countSpaces(line) <= 0){
            System.out.println("Input line does not contain spaces!");
            formatedString = "";
        }

        if(line.length() <= width ) {
            formatedString = stringOfSpaces(line, width-line.length());
        }
        else {
            formatedString = stringOfSpacesMoreThanWidth(line, width);
        }
        return formatedString;
    }
}