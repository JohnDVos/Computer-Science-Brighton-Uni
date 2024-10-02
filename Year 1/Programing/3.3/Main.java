import java.util.Arrays;
import java.io.*;
public class Main
{   
    public static void main (String args[])
    { 
        System.out.print("#Enter phrase");
        String original = BIO.getString();

        while (! original.equals("END"))
        {
            String lowerCase = original.toLowerCase();
            char [] chars = lowerCase.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
         
            if (lowerCase.equals(sorted))
            {
                System.out.println(original + " letters in ascending order");
            }
            else if (lowerCase != (sorted))
            {
               System.out.println(original + " letters not in ascending order"); 
            }
            System.out.print("#Enter phrase");
            original = BIO.getString();
        }
    }
}