package util;

import java.util.UUID;

public class Account {

	private final String accountId = UUID.randomUUID().toString();
	private double balance;
	private final Customer customer;

	public Account(double balance, Customer customer) {
		super();
		this.balance = balance;
		this.customer = customer;
	}

	public String getId() {
		return this.accountId;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return this.customer;
	}


	public void credit(double amount) {
		
		this.balance += amount;
	}

	public void debit(double amount) {
		
		this.balance -= amount;

	}

	@Override
	public String toString() {
		return "Account [accountId=" + this.accountId + ", balance=" + this.balance + ", customer=" + this.customer.getName()
				+ "]";
	}
	
	

}
