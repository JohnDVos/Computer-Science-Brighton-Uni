public class Calculator
{
    private long theResult = 0;           // Declaration of a long variable to hold the stored result

    //    Evaluate an arithmetic operation on the stored result 
    //    E.g evaluate( '+', 9) would add 9 to the stored result 
    //    evaluate( '/', 3) would divide the stored result by 3 
    //    actions are '+'. '-', '*', '/' 
    //    Note: if the operation is 
    //    evaluate( '/', 0 ) the theResult returned must b 0 
    //    (Not mathematically correct) 
    //    You will need to do a special check to ensure this 
    /**
     * perform the operation 
     *  theResult = theResult 'action' number
     * @param action An arithmetic operation + - * /
     * @param number A whole number
     */
    public void evaluate( char action, long number )
    {
        if (number == 0 && action == '/')
        {
            theResult = 0;                  //resets the calculator to 0, for if theResult is divided by 0 (not mathematically correct).
        }
        else
        {
            switch (action)
            {
                case '+':                                //"is for a string 'is for a char.
                theResult = theResult + number;         //if action is + then theResult + number
                break;
                case '-':                                   
                theResult = theResult - number;         //if action is - then theResult - number
                break;
                case '/':
                theResult = theResult / number;         //if action is / then theResult / number
                break;
                case '*':
                theResult = theResult * number;         //if action is * then theResult * number
                break;
            }
        }
    }
    
    /**
     * Return the long calculated value
     * @return The calculated value
     */
    public long getValue()
    {
        return theResult;           //returns what theResult is.
    }

    /**
     * Set the stored result to be number
     * @param number to set result to.
     */
    public void setValue( long number )
    {
        theResult = number;         //makes the stored results equal to the number.
    }

    /**
     * Set the stored result to be 0
     */
    public void reset()
    {
        theResult = 0;                  //resets the calculator to 0.
    }

}