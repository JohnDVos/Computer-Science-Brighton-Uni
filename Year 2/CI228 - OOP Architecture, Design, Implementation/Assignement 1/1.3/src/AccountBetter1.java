public class AccountBetter1 extends Account implements Transfer {
    public boolean transferFrom (Account from, double amount){
        if (from.getBalance () >= amount && amount > 0) {
            from.withdraw(amount);
            this.deposit(amount);
            return true;
        }
        else {
                return false;
        }
    }
    
    public boolean transferTo (Account to, double amount){
        if (this.getBalance() >= amount && amount > 0){
        	this.withdraw(amount);
        	to.deposit(amount);
            return true;
        }
        else {
            return false;
        }
    }
}
