package atm;

import java.util.Scanner;

public class Logic extends WelcomeInterface{
	
	private static int pin;
	private static int userChoice;

	//to display welcome board
	public static void welcomeTo(String str, User existingUser) {
		System.out.println("---------------------  Welcome to "+str+" Page  ---------------------------");
		userDetails(existingUser);
		
	}
	
	//to display continue or exit 
	public static void continueOrExit(User existingUser) {
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("\n Would you like to continue operations or exit?"
				+ "\n   1. Continue"
				+ "\n   2. Exit"
				+ "\n\n-------------------------------------------------------------------------------");
	}
	
	//to display user details
	public static void userDetails(User existingUser) {
		System.out.println("\n User Details"
				+ "\n   User Name            : "+existingUser.getUserName()
				+ "\n   User Account Number  : "+existingUser.getUserAccNumber()
				+ "\n   User Account Balance : "+existingUser.getUserAccBalance());
	}
	
	//pin retries and withdraw, deposit, transfer logic. 
	public static void pinRetries(User existingUser, int amount, String type) {
		Scanner sc = new Scanner(System.in);
		int maxAttemptsForPin = 3;
		while(maxAttemptsForPin > 0) {
			System.out.println(" Enter Account Pin :");
			try {
				pin = sc.nextInt();
				
			}catch(Exception e) {
				System.out.println(e);
				System.out.println("Invalid input. Please restart application.");
				System.exit(0);
			}
			
			if(pin == existingUser.getUserAtmPin()) {
				
				TransactionDetails transaction = new TransactionDetails();
				
				if(type.equals("Withdraw")) {
					existingUser.setUserAccBalance((existingUser.getUserAccBalance() - amount));
					transaction.setTransactionType("Debit");
				} else if(type.equals("Deposit")) {
					existingUser.setUserAccBalance((existingUser.getUserAccBalance() + amount));
					transaction.setTransactionType("Credit");
				} else if(type.equals("Transfer")) {
					existingUser.setUserAccBalance((existingUser.getUserAccBalance() - amount));
					transaction.setTransactionType("Debit - Transfered");
					transaction.setTransferedTo(Transfer.transferedTo());
					
				}
				
				System.out.println("-------------------------------------------------------------------------------\n   "
						+ "                       "+type+" Successful");
				
				transaction.setTransactionAmount(amount);
				transaction.setAccBalanceAfterTransaction(existingUser.getUserAccBalance());
				list.add(transaction);
				mapOfTransactionDetails.put(existingUser.getUserAccNumber(), list);

				Logic.continueOrExit(existingUser);
				
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
					if(type.equals("Withdraw")) {
						Withdraw.withdraw(existingUser);
					} else if(type.equals("Deposit")) {
						Deposit.deposit(existingUser);
					} else if(type.equals("Transfer")) {
						Transfer.transfer(existingUser);
					}
					break;
				}
				maxAttemptsForPin = 0;
				
			}else if(maxAttemptsForPin == 1){
				System.out.println("-------------------------------------------------------------------------------\n"
						+ "Three Invalid ATM pin attempts. You are being sent back to Login Page\n"
						+ "-------------------------------------------------------------------------------");
				maxAttemptsForPin--;
				userLogin();
			}else {
				System.out.println("-------------------------------------------------------------------------------\n"
						+ "Entered ATM pin is invalid. Please try again.\n"
						+ "-------------------------------------------------------------------------------");
				maxAttemptsForPin--;
			}
			
		}
		sc.close();

	}
}
