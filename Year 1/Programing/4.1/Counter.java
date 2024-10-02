class Counter
{
    //Declaration of a long instance variable to hold
    // the value of the counter

    private int counter = 0;

    /**
     * Return the current value of the counter
     * @return The value of the counter
     */
    public long getValue()
    {
        //Fill in code for the method
        return counter;
    }

    /**
     * Reset the counter to zero
     */
    public void reset()
    {
        //Fill in code for the method
        counter = 0;                   
    }
        
    /**
     * Add 1 to the counter
     */
    public void inc()
    {
        //Fill in code for the method
        counter = counter + 1;
    }

    /**
     * Subtract 1 from the counter
     */
    public void dec()
    {
        //Fill in code for the method
        counter = counter -1; 
    }
    

    /**
     * Add 5 to the counter
     */
    public void add5()
    {
        //Fill in code for the method
        counter = counter + 5; 
    }

    /**
     * Add 10 to the counter
     */
    public void add10()
    {
        //Fill in code for the method
        counter = counter + 10; 
    }
}