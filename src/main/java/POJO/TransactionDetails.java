package POJO;

public class TransactionDetails {

	int transactionId;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public int getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionMonth() {
		return transactionMonth;
	}
	public void setTransactionMonth(String transactionMonth) {
		this.transactionMonth = transactionMonth;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	String transactionType;
	int transactionAmount; 
	String transactionMonth; 
	int branchId;
	
}
