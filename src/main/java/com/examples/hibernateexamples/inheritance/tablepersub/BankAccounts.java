package com.examples.hibernateexamples.inheritance.tablepersub;

import javax.persistence.*;

@Entity
@Table(name="bank_detailss")
public class BankAccounts extends BillingDetailss{

	public BankAccounts() {
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

