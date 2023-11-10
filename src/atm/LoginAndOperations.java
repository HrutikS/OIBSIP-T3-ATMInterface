package atm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LoginAndOperations {
	
	private static Scanner sc = new Scanner(System.in);
	public static Map<BigInteger, Integer> mapOfAtmNumberAndPin = new HashMap<BigInteger, Integer>();
	public static Map<BigInteger, User> mapOfUserDetails = new HashMap<BigInteger, User>();
	public static Map<String, List<TransactionDetails>> mapOfTransactionDetails = new HashMap<String, List<TransactionDetails>>();
	public static List<TransactionDetails> list = new ArrayList<TransactionDetails>();
	private static User dummyUser1;
	private static BigInteger userAtmNumber;
	private static int userAtmPin;
	
	public static void userLogin() {
		
		mapOfAtmNumberAndPin.put(BigInteger.valueOf(12345),123);
				
		System.out.println("-------------------------  Welcome to Login Page  -----------------------------\n");
		int maxAttemptsForAtmNumber = 3;
		int maxAttemptsForAtmPin = 3;
		while(maxAttemptsForAtmNumber > 0) {
			System.out.println(" Please login to use the ATM facilities.\n"
						+ "   Enter your ATM card number :");
			try {
				userAtmNumber = sc.nextBigInteger();
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("Invalid Input. Please restart application.");
				System.exit(0);
			}
			if(mapOfAtmNumberAndPin.containsKey(userAtmNumber)) {
				int toCheck = mapOfAtmNumberAndPin.get(userAtmNumber);
				while(maxAttemptsForAtmPin > 0) {
					System.out.println("   Enter your ATM card pin :");
					try {
						userAtmPin = sc.nextInt();
					} catch (Exception e) {
						System.out.println(e);
						System.out.println("Invalid Input. Please restart application.");
						System.exit(0);
					}
					
					if(toCheck == userAtmPin) {
						System.out.println("-------------------------------------------------------------------------------\n   "
									+ "                          Login Successful\n"
									+ "-------------------------------------------------------------------------------");
						dummyUser1 = new User();
						dummyUser1.setUserName("Dummy1");
						dummyUser1.setUserAccNumber("1122334455");
						dummyUser1.setUserAccBalance(20000f);
						dummyUser1.setUserAtmNumber(BigInteger.valueOf(12345));
						dummyUser1.setUserAtmPin(123);
						mapOfUserDetails.put(BigInteger.valueOf(12345), dummyUser1);
									
						TransactionDetails transaction1 = new TransactionDetails();
						transaction1.setTransactionAmount(500);
						transaction1.setTransactionType("Debit");
						dummyUser1.setUserAccBalance((dummyUser1.getUserAccBalance() - transaction1.getTransactionAmount()));
						transaction1.setAccBalanceAfterTransaction(dummyUser1.getUserAccBalance());
										
						TransactionDetails transaction2 = new TransactionDetails();
						transaction2.setTransactionAmount(1000);
						transaction2.setTransactionType("Credit");
						dummyUser1.setUserAccBalance((dummyUser1.getUserAccBalance() + transaction2.getTransactionAmount()));
						transaction2.setAccBalanceAfterTransaction(dummyUser1.getUserAccBalance());
										
						list.add(transaction1);
						list.add(transaction2);
										
						mapOfTransactionDetails.put(dummyUser1.getUserAccNumber(), list);
						
						operations(userAtmNumber, mapOfTransactionDetails);
						maxAttemptsForAtmPin = 0;
					}else if(maxAttemptsForAtmPin == 1){
						System.out.println("-------------------------------------------------------------------------------\n"
									+ "Three Invalid ATM pin attempts. You are being sent back to Welcome Page\n"
									+ "-------------------------------------------------------------------------------");
						maxAttemptsForAtmPin--;
						WelcomeInterface.welcomeInterface();
					}else {
						System.out.println("-------------------------------------------------------------------------------\n"
									+ "Entered ATM pin is invalid. Please try again.\n"
									+ "-------------------------------------------------------------------------------");
						maxAttemptsForAtmPin--;
					}
				}
				maxAttemptsForAtmNumber = 0;
			}else if(maxAttemptsForAtmNumber == 1){
				System.out.println("-------------------------------------------------------------------------------\n"
							+ "Three Invalid ATM number attempts. You are being sent back to Welcome Page\n"
							+ "-------------------------------------------------------------------------------");
				maxAttemptsForAtmNumber--;
				WelcomeInterface.welcomeInterface();
			}else {
				System.out.println("-------------------------------------------------------------------------------\n"
							+ "Entered ATM number is invalid. Please try again.\n"
							+ "-------------------------------------------------------------------------------");
				maxAttemptsForAtmNumber--;
			}
		}
	}
	
	public static void operations(BigInteger userAtmNumber, Map<String, List<TransactionDetails>> mapOfTransactionDetails) {
		
		User existingUser = mapOfUserDetails.get(userAtmNumber);
		Logic.welcomeTo("Operations", existingUser);
		
		System.out.println("\n Choose functionality you want to access :"+
				"\n   1. Transaction History"+
				"\n   2. Withdraw"+
				"\n   3. Deposit"+
				"\n   4. Transfer"+
				"\n   5. Quit"+
				"\n\n-------------------------------------------------------------------------------");
		int userChoice = 0;
		try {
			userChoice = sc.nextInt();
		} catch(Exception e) {
			System.out.println(e);
			System.out.println("Invalid input. Please restart application.");
			System.exit(0);
		}
		
		switch(userChoice) {
		case 1: 
			TransactionHistory.transactionHistory(existingUser, mapOfTransactionDetails);
			break;
		case 2:
			Withdraw.withdraw(existingUser);
			break;
		case 3:
			Deposit.deposit(existingUser);
			break;
		case 4:
			Transfer.transfer(existingUser);
			break;
		case 5:
			Quit.quit(existingUser);
			break;
		default:
			System.out.println("-------------------------------------------------------------------------------\n"
					+ "You have entered an Invalid choice. Please make a valid choice. Try again.\n"
					+ "-------------------------------------------------------------------------------");
			//Add code to clear console as it will remove the previous results from console before calling the below method.
			operations(userAtmNumber, mapOfTransactionDetails);
			break;
		}
		sc.close();
	}


}
