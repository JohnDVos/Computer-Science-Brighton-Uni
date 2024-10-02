class JavaLine
{
    private String java    = ""; // Java code on line 
    private String comment = ""; // The single line comment 
    private int    lenJava = 0;  // The line length of just the java code

    private int codeBlockStart = 0;
    private int codeBlockEnd = 0;

    /**
     * Constructor
     * @param line of a java program
     */
    public JavaLine( String line )
    {
        // Split line into the Java code part 'variable java' and the // comment 
        // into 'variable comment'. 
        // Trailing spaces are removed from the variable 'java' 
        // Record the length of the java code part of the line 
        //   into the variable 'lenJava' 

        // For example the line:     String s = "// comment";  // Initialise s 
        // column position char: 123456789012345678901234567890123456789012345 

        // would set the instance variables to be: 
        //  java    ->      String s = "// comment"; 
        //  column:     1234567890123456789012345678 position of chars 
        //  comment ->  // Initialise s 
        //  lenJava ->  28 

        int firstQuote = line.indexOf("\"");                    //\ is an escape character.
        int secondQuote = line.indexOf("\"", firstQuote +1);    //starts looking for " after first ".
        int indexOfComment = 0;

        if (firstQuote == -1 || secondQuote == -1)
        {
            indexOfComment = line.indexOf("//");
        }
        else
        {
            indexOfComment = line.indexOf( "//", secondQuote +1);       //first what you are looking for, second where you are starting.
        }

        if (indexOfComment == -1)                               //if the code doesn't have it will have an index of minus, so if =-1 it makes its placing in the index equal to 0.
        {
            java = line.substring(0);
        }
        else
        {
            comment = line.substring(indexOfComment);           //makes comment equal to where a "//" is in the code in the index calling on the indexOfComment to determine its position.
            java = line.substring(0, indexOfComment);           //tells java where to start and end the index.
        }
        java.trim();                                            //removes extra spaces at the end of the string java.
        lenJava = java.length();                                //makes lenJava = to how many characters java has.
        
        codeBlockStart = line.indexOf("{");
        codeBlockEnd = line.indexOf("}");       
    }

    /**
     * Return the length of the Java part of the stored line.<PRE>
     * JavaLine j = new JavaLine("int a; // Declaration"); 
     * int jp = j.getJavaLineLength();
     * Would set jp the be 6</PRE>
     * @return The length of the Java code in the line
     */
    public int getJavaLineLength()
    {
        return lenJava;                                     //returns lenJava.
    }

    /**
     * Return as an 'indented' line with the // comment 
     * starting at column pos<PRE>
     * JavaLine j = new JavaLine("int a; // Declaration"); 
     * String res = j.returnLineWithCommentAt(10);
     * Would set res to be the following string:
     * int a;   // Declaration</PRE> 
     * @param pos Start // comment at pos 
     * @return A new version of the line with any // comment 
     * starting at column pos.
     */
    public String returnLineWithCommentAt(int pos, int codeBlockCount)
    {
        String indented = "";
        String codeIndent = "";
        
        for (int i = 0; i < codeBlockCount; i++)
        {
            codeIndent = codeIndent + "  ";                     //indents by 2 spaces extra.
        }
        
        indented = codeIndent + java + spaces(pos - lenJava - (codeBlockCount*2)) + comment;      //makes indented into a string which equals "java + the correct amount of spaces to indent + the comment.
        //pos - lenJava = the amount of spaces which is calculated by taking pos and minusing the lenJava
    
        return indented;                                        //returns indented
    }

    /**
     * Return a string of 'number' spaces.
     * @param number of spaces required
     * @return A string of 'number' spaces
     */
    public static String spaces( int number )
    {
        String str = "";

        for (int i = 0; i < number; i++)                    //as long as i is smaller than number it will keep adding a space at the end of the string.
        {
            str = str + " ";
        }

        return str;
    }
    
    public Boolean codeBlockStart()
    {
        Boolean codeBlock = false;
        
        if (codeBlockStart != -1)       //if not equal to minus 1 commentBlock becomes true.             
        {
            codeBlock = true;
        }
        return codeBlock;
    }
    
    public Boolean codeBlockEnd()
    {
        Boolean codeBlock = false;
        
        if (codeBlockEnd != -1)       //if not equal to minus 1 commentBlock becomes true.             
        {
            codeBlock = true;
        }
        return codeBlock;
    }
}