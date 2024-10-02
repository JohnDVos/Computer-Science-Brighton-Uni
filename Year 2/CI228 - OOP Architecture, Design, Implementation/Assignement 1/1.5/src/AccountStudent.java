public class AccountStudent extends AccountBetter2 {
	
	private int day = 0;
	
	public boolean inCredit() {
		if (this.getBalance() >= 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void creditCharge() {
		if (day >= 1) {
			double interest = 0.0;
			if (this.inCredit() == false && this.getBalance() < -5000) {
				interest = -(this.getBalance() * 0.00026116);
			}
			if (this.getOverdraftLimit() >= (this.getBalance() - interest)) {
				this.setOverdraftLimit(this.getBalance() - interest);
			}
			this.withdraw(interest);
		} 
		day++;
	}

}
