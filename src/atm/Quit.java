package atm;

import java.util.Scanner;

public class Quit extends LoginAndOperations{

	public static void quit(User existingUser){
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		System.out.println("----------------------  Welcome to Quit Page  ---------------------------\n"
				+ "\n User name : " +existingUser.getUserName()
				+ "\n\n Do you want to exit?" 
				+ "\n   1. Yes. Exit."
				+ "\n   2. No. Continue."
				+ "\n\n-------------------------------------------------------------------------------");
		try {
			choice = sc.nextInt();
		}catch (Exception e) {
			System.out.println(e);
			System.out.println("Invalid input. Please restart application.");
			System.exit(0);
		}
		
		switch(choice) {
		case 1:
			System.out.println("-------------------------------------------------------------------------------\n   "
					+ "                       Exit Successful.\n"
					+ "                            Thank You !!"
					+ "\n-------------------------------------------------------------------------------");
			System.exit(0);
			break;
		case 2:
			LoginAndOperations.operations(existingUser.getUserAtmNumber(), mapOfTransactionDetails);
			break;
		default:
			System.out.println("-------------------------------------------------------------------------------\n"
					+ "You have entered an Invalid choice. Please make a valid choice. Try again.\n"
					+ "-------------------------------------------------------------------------------");
			//Add code to clear console as it will remove the previous results from console before calling the below method.
			quit(existingUser);
			break;
		}
		sc.close();
	}
}
