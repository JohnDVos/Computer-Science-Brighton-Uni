import java.util.HashMap;
public class ProcessMoney
{
    // Instance variables to hold the state of 
    //   the ticket machine 
    private int theTicketPrice = 0;                           // Ticket price 
    private int theCredit = 0;                                // Money from customer 
    private int theMoneyInTheMachine = 0;                     // All the money

    HashMap<Integer, Integer> map = new HashMap<>();

    // You need other instance variables to hold 
    //   the number of coins of each denomination 
    // Remember there is a global list of coins in the machine 
    //  (50x200p 47x100p, 67*50p ... ) 
    // and a 'temporary' list of coins entered to buy the  
    // current ticket 
    //  (1x200p 2x50p [if the ticket was for 300p]) 
    //  When a ticket is bought the 'temporary' list  
    //  is added to the global list 
    // If the ticket is not bought the coins are returned  
    //  and hence not added to the global list 
    // A better way is to use a map<Integer,Integer> 

    /**
     * Set the price for the current ticket
     * @param amount Cost of ticket in pence 
     */
    public void setTicketPrice( int amount )
    {
        theTicketPrice = amount;                            //gets the price of the ticket,.
    }

    /**
     * Return the price in pence of the current ticket
     * @return  Cost of ticket in pence
     */
    public int getTicketPrice()
    { 
        return theTicketPrice;                                // returns the costOfTicket.
    }

    /**
     * Add a coin with value 'coin' in pence 
     *  to the ticket machine to 'partial' pay for the ticket.
     * @param coin The coin to add to the ticket machine
     */
    public void add( int coin )
    {
        theCredit = theCredit + coin;                       //adds whatever coin was inserted to the credit.

        if (map.containsKey (coin))
        {
            int temp = map.get(coin);
            map.put(coin, temp += 1);
        }
        else
        {
            map.put(coin, 1);   
        }
    } 

    /**
     * Return true if sufficent money has been entered to buy
     * the ticket else return false
     * @return true if sufficient money else false
     */
    public boolean enough()
    {
        if (theCredit >= theTicketPrice)
        {
            return true;                                //if theTicketPrice is equal to 0, i.e. enough money has been entered then return true.
        }
        else
        {
            return false;                               //if theTicketPrice is not equal to 0, i.e. not enough has been entered then return false.
        }
    }

    /**
     * Return the value in pence paid so far into the machine
     *  for a ticket
     * @return  In pence the amount paid so far
     */
    public int getPaidSoFar()
    {
        return theCredit;                               //returns the credit, i.e. how much money has been inserted so far.
    }

    /**
     * Cancel the purchase of the ticket.
     * 'Coins' are returned to the customer.
     * The amount credited so far is set to zero.
     */
    public void cancel()
    {
        theCredit = 0;                                  //resets the credit in the machine to 0.

        for (int i = 0; i < map.size(); i++)
        {
            map.put(i, 0);   
        }
    }

    /**
     * The ticket has been bought, and money
     * entered by the user is added to the total
     * money in the machine
     */
    public void bought()
    {
        theMoneyInTheMachine = theCredit + theMoneyInTheMachine; 
        theCredit = 0;
    }
    
    /**
     * Deliver in pence the total amount of money in the machine
     *  that has been used to purchase tickets.
     * @return The total money in the machine in pence.
     */
    public int moneyInMachine()
    {
        return theMoneyInTheMachine;                    //returns how much many has been put into the machine.
    }

    /**
     * Deliver how many 'coins' are in the machine.
     * Thus if there were 63 10p coins
     *  getNumCoins( 10 ) would return 63.
     * @param  coin The coin selected
     * @return Total number of 'coin'p coins in the machine.
     */
    public int getNumCoins( int coin )
    {
        if (map.get(coin) == null)
        {
            return 0;   
        }

        return map.get(coin);
    }
}