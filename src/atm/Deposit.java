package atm;

import java.util.Scanner;

public class Deposit extends WelcomeInterface{
	
	private static int amount;
	
	public static void deposit(User existingUser) {
		
		Logic.welcomeTo("Deposit", existingUser);
		
		System.out.println("\n Enter amount you want to deposit :");
		Scanner sc = new Scanner(System.in);
		try {
			amount = sc.nextInt();
			
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("Invalid input. Please restart application.");
			System.exit(0);
		}
		
		Logic.pinRetries(existingUser, amount, "Deposit");
		
		sc.close();
		
	}
}
