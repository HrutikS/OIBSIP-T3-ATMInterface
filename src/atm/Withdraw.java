package atm;

import java.util.Scanner;

public class Withdraw extends WelcomeInterface{
	
	private static int amount;
	
	public static void withdraw(User existingUser){
		
		Logic.welcomeTo("Withdraw", existingUser);
		
		System.out.println("\n Enter amount you want to withdraw :");
		Scanner sc = new Scanner(System.in);
		try{
			amount = sc.nextInt();
			if(existingUser.getUserAccBalance() < amount) {
				System.out.println("-------------------------------------------------------------------------------\n   "
						+"                       Insufficient balance."
						+"\n-------------------------------------------------------------------------------\n   ");
				withdraw(existingUser);
			}
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("Invalid input. Please restart application.");
			System.exit(0);
		}
		
		Logic.pinRetries(existingUser, amount, "Withdraw");

		sc.close();
		
	}

}
