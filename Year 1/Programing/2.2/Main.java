class Main  
{
    public static void main (String args[])
    {
        String StudentName = BIO.getString();

        while (!StudentName.equals("END"))
        {
            int Mark = BIO.getInt();
            if (Mark >=70)
            {
                System.out.print(StudentName);
                System.out.print(" [" +Mark+ "] ");
                System.out.println(" gains a 1st");
            }
            else
            {
                if (Mark >=60)
                {
                    System.out.print(StudentName);
                    System.out.print(" [" +Mark+ "] ");
                    System.out.println(" gains a 2.1");
                }
                else
                {
                    if (Mark >=50)
                    {
                        System.out.print(StudentName);
                        System.out.print(" [" +Mark+ "] ");
                        System.out.println(" gains a 2.2");
                    }
                    else
                    {
                        if (Mark >=40)
                        {
                            System.out.print(StudentName); 
                            System.out.print(" [" +Mark+ "] ");
                            System.out.println(" gains a 3rd");
                        }
                        else

                        if (Mark <=39)
                        {
                            System.out.print(StudentName);
                            System.out.print(" [" +Mark+ "] ");
                            System.out.println(" fails");
                        }
                    }
                }
            }
            StudentName = BIO.getString();
        }
    }
}
