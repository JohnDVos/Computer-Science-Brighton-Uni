public class AccountBetter1 extends Account implements Transfer {
    
	public boolean transferFrom (Account from, double amount){
        if (from.getBalance () >= amount) {
            from.withdraw(amount);
            this.deposit(amount);
            return true;
        }
        else {
                return false;
        }
    }
    
    public boolean transferTo (Account to, double amount){
        if (to.getBalance() >= amount){
            to.deposit(amount);
            this.withdraw(amount);
            return true;
        }
        else {
            return false;
        }
    }
}
