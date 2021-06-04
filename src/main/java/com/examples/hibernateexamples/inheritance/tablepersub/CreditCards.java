package com.examples.hibernateexamples.inheritance.tablepersub;

import javax.persistence.*;

@Entity
@Table(name="credit_cardss")
public class CreditCards extends BillingDetailss{

	public CreditCards() {
	}
	private String number;
	private String expMonth;
	private String expYear;

	public String getExpMonth() {
		return expMonth;
	}
	public void setExpMonth(String expMonth) {
		this.expMonth = expMonth;
	}
	public String getExpYear() {
		return expYear;
	}
	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
}