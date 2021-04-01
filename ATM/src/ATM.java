import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		
		Account[] IDs = new Account[10];
		initialArr(IDs);
		
		
		
		
		do {
			System.out.println("Enter an id: ");
			int id = input.nextInt();
			
			if(isValid(IDs, id)) {
				int choice;
				do {
					choice = displayMainMenu(input);
				if (isTransaction(choice)) {
					executeTransaction(choice, IDs, id, input);
				}
				} while(choice != 4);
			}
		} while(true);
		
		
		
	}
	public static void initialArr(Account[] a) {
		int initialBalance = 100;
		for(int i = 0; i < a.length; i++) {
			a[i] = new Account(i, initialBalance);
		}
	}
	public static boolean isValid(Account[] a, int id) {
		for(int i = 0; i < a.length; i++) {
			if(id == a[i].getID()) {
				return true;
			}
		}
		return false;
	}
	public static int displayMainMenu(Scanner input) {
		System.out.print(
			"\nMain menu\n1: check balance\n2: withdraw" +
			"\n3: deposit\n4: exit\nEnter a choice: ");
		return input.nextInt();
	}
	public static boolean isTransaction(int choice) {
		return choice > 0 && choice < 4;
	}
	public static void executeTransaction(
			int c, Account[] a, int id, Scanner input) {
			switch (c) {
			case 1: // Viewing the current balance
				  System.out.println("The balance is " + a[id].checkBalance());
				  break;
			case 2: // Withdraw money
				  System.out.print("Enter an amount to withdraw: "); 
				  a[id].withdraw(input.nextDouble());
				  break;
			case 3: // Deposit money
				  System.out.print("Enter an amount to deposit: "); 
				  a[id].deposit(input.nextDouble());
			}
		}
}
