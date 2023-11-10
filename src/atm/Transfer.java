package atm;

import java.util.Scanner;

public class Transfer extends WelcomeInterface{
	
	private static User newUser;
	private static int amount;
	
	public static void transfer(User existingUser){
		Logic.welcomeTo("Transfer", existingUser);
		System.out.println("\n Enter the transfer details :"
				+ "\n   Receiver Account Number :");
		
		//New user to whom transfer will be made
		Scanner sc = new Scanner(System.in);
		try{
			newUser = new User();
			newUser.setUserAccNumber(sc.next());
			System.out.println("   Amount to be transfered :");
			amount = sc.nextInt();
			if(existingUser.getUserAccBalance() < amount) {
				System.out.println("-------------------------------------------------------------------------------\n   "
						+"                       Insufficient balance."
						+"\n-------------------------------------------------------------------------------\n   ");
				transfer(existingUser);
			}
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("Invalid input. Please restart application.");
			System.exit(0);
		}
		
		Logic.pinRetries(existingUser, amount, "Transfer");
				
		sc.close();
		
	}
	
	public static String transferedTo() {
		return newUser.getUserAccNumber();
	}

}
