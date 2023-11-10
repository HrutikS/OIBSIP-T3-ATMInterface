package atm;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TransactionHistory{
	
	private static int userChoice;
	
	public static void transactionHistory(User existingUser, Map<String, List<TransactionDetails>> mapOfTransactionDetails) {
		
		Logic.welcomeTo("Transaction History", existingUser);
		
		System.out.println("\n\n Transaction History"); 
		List<TransactionDetails> list = mapOfTransactionDetails.get(existingUser.getUserAccNumber());
		for(int i=0; i<list.size();i++) {
			System.out.print("   Transaction type          : "+list.get(i).getTransactionType());
			if((list.get(i).getTransferedTo()) != null) {
				System.out.print("\n   Transfered to             : "+list.get(i).getTransferedTo());
			}
			System.out.println("\n   Transaction amount        : "+list.get(i).getTransactionAmount()
						+ "\n   Balance after transaction : "+list.get(i).getAccBalanceAfterTransaction() +"\n");
			
		}
		Logic.continueOrExit(existingUser);
		
		Scanner sc = new Scanner(System.in);
		try {
			userChoice = sc.nextInt();
		}catch (Exception e) {
			System.out.println(e);
			System.out.println("Invalid input. Please restart application.");
			System.exit(0);
		}
		switch(userChoice) {
		case 1:
			WelcomeInterface.operations(existingUser.getUserAtmNumber(), mapOfTransactionDetails);
			break;
		case 2:
			Quit.quit(existingUser);
			break;
		default:
			System.out.println("-------------------------------------------------------------------------------\n"
					+ "You have entered an Invalid choice. Please make a valid choice. Try again.\n"
					+ "-------------------------------------------------------------------------------");
			//Add code to clear console as it will remove the previous results from console before calling the below method.
			transactionHistory(existingUser, mapOfTransactionDetails);
			break;
		}
		sc.close();
		
	}

}
