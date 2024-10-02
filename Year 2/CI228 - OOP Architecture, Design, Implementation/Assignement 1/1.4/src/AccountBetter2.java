public class AccountBetter2 extends AccountBetter1 implements Interest{
	
	public boolean inCredit() {
		if (this.getBalance() >= 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void creditCharge() {
		double interest = 0.0;
		if (this.inCredit() == false) {
			interest = -(this.getBalance() * 0.00026116);
		}
		if (this.getOverdraftLimit() >= (this.getBalance() - interest)) {
			this.setOverdraftLimit(this.getBalance() - interest);
		}
		this.withdraw(interest);
	}
}
