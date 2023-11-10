package atm;

import java.util.Scanner;

public class WelcomeInterface {
	
	
	
	public static void welcomeInterface() {
		
		System.out.println("-------------------------------------------------------------------------------\n\n"
				+ " Following are the dummy user details for testing the ATM application.\n\n"
				+ "  Login Details : \n"
				+ "   UserId/ATM Number - 12345\n"
				+ "   Password/ATM Pin  - 123\n\n"
				+ "  User Details : \n"
				+ "   User Name            - Dummy\n"
				+ "   User Account Number  - 1122334455\n"
				+ "   User Account Balance - 20500\n"
				+ "   User Transactions    - Two existing transactions\n\n"
				+ "-------------------------------------------------------------------------------");
		
		
		System.out.println("----------------------------  Welcome to ATM   --------------------------------\n\n"
					+ " Choose amongst the following.\n"
					+ "   1. Login using ATM Card number.\n"

					+ "-------------------------------------------------------------------------------");
		int userChoice = 0;
		Scanner sc = new Scanner(System.in);
		try {
			userChoice = sc.nextInt();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Invalid Input. Please restart application.");
			System.exit(0);
		}
		switch(userChoice) {
		case 1: 
			LoginAndOperations.userLogin();
			break;
		default: 
			System.out.println("-------------------------------------------------------------------------------\n"
						+ "You have entered an Invalid choice. Please make a valid choice. Try again.\n"
						+ "-------------------------------------------------------------------------------");
			//Add code to clear console as it will remove the previous results from console before calling the below method.
			welcomeInterface();
			break;
		}
		sc.close();
		
	}
	
	
}
