class Main
{
    public static void main (String args[])
    {
        int star = BIO.getInt();
        
        for (int i=1; i<=star; i++)
        {
            for (int j=1; j<=star; j++)
            {
                if(i==1 || i==star || j==1 || j==star)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}