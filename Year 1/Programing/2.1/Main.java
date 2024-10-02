class Main extends BIO 
{
    public static void main (String args[])
    {
        String StudentName = BIO.getString();

        while (!StudentName.equals("END"))
        {
            int ModuleMark = BIO.getInt();
            if (ModuleMark <40)
            {
                System.out.printf("%s" , StudentName);
                System.out.print("Fail ");
            }
            else
            {
                System.out.printf("%s" , StudentName);
                System.out.print("Pass ");
            }
            StudentName = BIO.getString();
        }
    }   
}