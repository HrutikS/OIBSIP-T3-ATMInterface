package atm;

public class TransactionDetails {
	
	private int transactionAmount;
	private String transactionType;
	private float accBalanceAfterTransaction;
	private String transferedTo;
	

	public int getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	public float getAccBalanceAfterTransaction() {
		return accBalanceAfterTransaction;
	}

	public void setAccBalanceAfterTransaction(float accBalanceAfterTransaction) {
		this.accBalanceAfterTransaction = accBalanceAfterTransaction;
	}
	
	public String getTransferedTo() {
		return transferedTo;
	}

	public void setTransferedTo(String transferedTo) {
		this.transferedTo = transferedTo;
	}

}
