class Main extends BIO
{
    public static void main (String args[])
    {
        int sn = BIO.getInt();
        while (sn > 0)
        {
            if (sn == 0)
            break;

            int cw = BIO.getInt();
            int ex = BIO.getInt();  
            double mark = ((double)cw+(double)ex)/2;

            System.out.printf("sn = %d ex = %d cw = %d mark = %2.1f", sn, ex, cw, mark);
            
            sn = BIO.getInt();
            
           
        }
    }
}
