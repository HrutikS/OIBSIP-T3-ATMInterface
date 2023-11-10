package atm;

import java.math.BigInteger;

public class User {
	
	private BigInteger userAtmNumber;
	private int userAtmPin;
	private String userName;
	private String userAccNumber;
	private float userAccBalance;
	
	
	public BigInteger getUserAtmNumber() {
		return userAtmNumber;
	}
	public void setUserAtmNumber(BigInteger userAtmNumber) {
		this.userAtmNumber = userAtmNumber;
	}
	
	public int getUserAtmPin() {
		return userAtmPin;
	}
	public void setUserAtmPin(int userAtmPin) {
		this.userAtmPin = userAtmPin;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserAccNumber() {
		return userAccNumber;
	}
	public void setUserAccNumber(String userAccNumber) {
		this.userAccNumber = userAccNumber;
	}
	
	public float getUserAccBalance() {
		return userAccBalance;
	}
	public void setUserAccBalance(float userAccBalance) {
		this.userAccBalance = userAccBalance;
	}

}
