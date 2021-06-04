package com.examples.hibernateexamples.inheritance.tableperhierarchy;

import javax.persistence.*;

@Entity
@DiscriminatorValue("CC")
public class CreditCard extends BillingDetails{

	public CreditCard() {
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