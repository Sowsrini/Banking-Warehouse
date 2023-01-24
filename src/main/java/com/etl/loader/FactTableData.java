package com.etl.loader;

public class FactTableData {

	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getTransactionId() {
		return transactionId;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getCustomerId()+" "+this.getAccountNumber()+" "+this.getMonth()+" "+this.transactionId+" "+this.getAmount();
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	String customerId;
	int accountNumber;
	int transactionId; 
	int amount;
	String month;
	int branchId;
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
}
