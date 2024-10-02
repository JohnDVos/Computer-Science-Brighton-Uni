class Main extends BIO
{
    public static void main (String args[])
    {
        System.out.print("#Name of student ");
        String sn = BIO.getString();
        while (!sn.equals("END"))
        {
            System.out.print("#Input Coursework Mark ");
            int cw = BIO.getInt();
            System.out.print("#Input Exam Mark ");
            int ex = BIO.getInt();
            double mark = ((double)cw+(double)ex)/2;
            if (mark >=40 && cw>=30 && ex>=30)
            {
                System.out.printf("%s [%d, %d] %2.1f", sn, cw, ex, mark);
                System.out.println(" Pass");
            }
            else if (mark >=40 && cw<=30 && ex>=30)
            {
                System.out.printf("%s [%d, %d] %2.1f", sn, cw, ex, mark);
                System.out.println(" Fail [Threshold]");
            }
	 else
	 if (mark >=40 && cw>=30 && ex<=30)
            {
                System.out.printf("%s [%d, %d] %2.1f", sn, cw, ex, mark);
                System.out.println(" Fail [Threshold]");
            }
            else
            {
                System.out.printf("%s [%d, %d] %2.1f", sn, cw, ex, mark);
                System.out.println(" Fail");
            }
            System.out.print("#Name of student ");
            sn = BIO.getString();
        }
}
}
