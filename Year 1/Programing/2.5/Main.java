public class Main
{
    private static int twoPounds = 200;
    private static int onePound = 100;
    private static int fiftyPence = 50;
    private static int twentyPence = 20;
    private static int tenPence = 10;
    private static int fivePence = 5;
    private static int twoPence = 2;
    private static int onePence = 1;
 
    public static void main(String args[])
    {
        System.out.println("#Amount");
        int amount = BIO.getInt();
        System.out.println("Amount Coins");
 
        while(getValidInput(amount))
        {
            if(amount <= 500 && amount > 0)
            {
                int coins = 0;
                int newAmount = amount;
                String result = "";
                while(newAmount > 0)
                {
                    if(newAmount >= twoPounds*2)
                    {
                        newAmount = newAmount - twoPounds*2;
                        result = "2*" + twoPounds +"p ";
                        coins = coins + 2;
                    }
                    else if (newAmount >= twoPounds)
                    {
                        newAmount = newAmount - twoPounds;
                        result = twoPounds + "p ";
                        coins++;
                    }
                    else if (newAmount >= onePound)
                    {
                        newAmount = newAmount - onePound;
                        result = result + onePound + "p ";
                        coins++;
                    }
                    else if (newAmount >= fiftyPence)
                    {
                        newAmount = newAmount - fiftyPence;
                        result = result + fiftyPence + "p ";
                        coins++;
                    }
                    else if(newAmount >= twentyPence*2)
                    {
                        newAmount = newAmount - twentyPence*2;
                        result = result + "2*" + twentyPence +"p ";
                        coins = coins + 2;
                    }
                    else if (newAmount >= twentyPence)
                    {
                        newAmount = newAmount - twentyPence;
                        result = result + twentyPence + "p ";
                        coins++;
                    }
                    else if (newAmount >= tenPence)
                    {
                        newAmount = newAmount - tenPence;
                        result = result + tenPence + "p ";
                        coins++;
                    }
                    else if (newAmount >= fivePence)
                    {
                        newAmount = newAmount - fivePence;
                        result = result + fivePence + "p ";
                        coins++;
                    }
                    else if (newAmount >= twoPence*2)
                    {
                        newAmount = newAmount - twoPence*2;
                        result =  result + "2*" + twoPence +"p ";
                        coins = coins + 2;
                    }
                    else if (newAmount >= twoPence)
                    {
                        newAmount = newAmount - twoPence;
                        result = result + twoPence + "p ";
                        coins++;
                    }
                    else if (newAmount >= onePence)
                    {
                        newAmount = newAmount - onePence;
                        result = result + onePence + "p ";
                        coins++;
                    }
                }
                showResult(amount, coins, result);
                amount = BIO.getInt();
            }            
            else
            {
                System.out.println("Invalid amount " + amount + "p");
                amount = BIO.getInt();
            }
        }    
    }
 
    public static void showResult(int amount, int coins, String result)
    {
        if(coins > 1)
        {
            System.out.printf("%3dp   %d coins %s\n", amount, coins, result);
        }
        else
        {
            System.out.printf("%3dp   %d coin  %s \n", amount, coins, result);
        }  
    }
 
    public static boolean getValidInput(int input)
    {
        if(input == 0)
        {
            return false;  
        }   
        else
        {  
            return true;
        }
    }
}