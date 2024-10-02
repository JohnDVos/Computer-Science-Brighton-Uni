class Main extends BIO
{
    public static void main (String args[])
    {
        System.out.println("#Input");
        String sn = BIO.getString();

        int spaceCount = 0;

        while (!sn.equals("END"))
        {
        for (char i : sn.toCharArray())
        {
            if (i == ' ')
            {
                spaceCount ++;
            }
        }
        char ch= '"';
        System.out.println("[ " + spaceCount + "] " + "spaces in " + ch + sn + ch);
        spaceCount = 0;
        sn = BIO.getString();
    }
}
}