package com.examples.hibernateexamples.inheritance.tableperhierarchy;

import javax.persistence.*;

@Entity
@DiscriminatorValue("BA")
public class BankAccount extends BillingDetails{

	public BankAccount() {
	}
	private String account;
	private String bankName;

	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}

}