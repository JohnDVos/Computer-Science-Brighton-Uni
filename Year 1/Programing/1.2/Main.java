class Main
{
    public static void main (String args[])
    {
        int cw = BIO.getInt();                
        int ex = BIO.getInt();                
        double mark = ((double)ex+(double)cw)/2;
        
        System.out.println ("ex = " + ex + " cw = " + cw + " mark = " + mark); 
    }
}
