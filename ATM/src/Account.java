
public class Account {
	private int ID;
	private double balance;
	
	public Account(int ID, int balance) {
		this.ID = ID;
		this.balance = balance;
	}
	public double checkBalance() {
		return balance;
	}
	public void withdraw(double withdraw) {
		balance = balance - withdraw;
	}
	public void deposit(double deposit) {
		balance = balance + deposit;
	}
	public int getID() {
		return ID;
	}
}
