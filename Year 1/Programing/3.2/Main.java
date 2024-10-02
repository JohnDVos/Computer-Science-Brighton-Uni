import java.util.ArrayList;
class Main 
{
    public static void main (String args[])
    {
        ArrayList <Character> vowels = new ArrayList<Character>();
            vowels.add('a');
            vowels.add('e');
            vowels.add('i');
            vowels.add('o');
            vowels.add('u');
            vowels.add('A');
            vowels.add('E');
            vowels.add('I');
            vowels.add('O');
            vowels.add('U');
        
        System.out.println("#Input");
        String sn = BIO.getString();
        
        int spaceCount = 0;
        
        while (!sn.equals("END"))
        {
        for (char i : sn.toCharArray())
        {
            if (vowels.contains(i))
            {
                spaceCount ++;
            }
        }
        char ch= '"';
        System.out.println("[ " + spaceCount + "] " + "vowels in " + ch + sn + ch);
        spaceCount = 0;
        sn = BIO.getString();
    }
}
}