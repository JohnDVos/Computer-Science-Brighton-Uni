import java.io.*;
public class Main 
{
    public static boolean isPalindrome(char[] chars){
        int i1 = 0;
        int i2 = chars.length - 1;

        while (i2 > i1) 
        {
            if (chars[i1] != chars[i2]) 
            {
                return false;
            }
            ++i1;
            --i2;
        }
        return true;
    }

    public static void main (String args [])
    {
        System.out.print("#Enter phrase");
        String word = BIO.getString();

        while (! word.equals("END"))
        {
            String lowerCase = word.toLowerCase();
            char [] chars = lowerCase.toCharArray();

            Boolean palindrome = isPalindrome(chars);

            if (palindrome == true)
            {
                System.out.println(word + " is a palindrome");
            }
            else
            {
                System.out.println(word + " is not a palindrome");
            }
            System.out.print("#Enter phrase");
            word = BIO.getString();
        }
    }
}

