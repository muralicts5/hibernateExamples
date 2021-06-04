package com.examples.hibernateexamples;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class EmployeeSSN implements Serializable{

	private int employeeId;
	private int ssn;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	
}
