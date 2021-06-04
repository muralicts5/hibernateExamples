package com.examples.hibernateexamples;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="emp_demo")
public class Employee {
	  
	  
	   
	   @Column(name="first_name", unique=true, nullable=false, length=20 )
	   private String firstName; 
	   
	   @Transient
	   private String lastName;   
	   
	   private int salary;  
	   

	   
	 @EmbeddedId 
	private EmployeeSSN employeeSSN;
	  
	   
	     @Embedded
	  private Address address;
	   
	   public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}


	public EmployeeSSN getEmployeeSSN() {
		return employeeSSN;
	}
	public void setEmployeeSSN(EmployeeSSN employeeSSN) {
		this.employeeSSN = employeeSSN;
	}
	
	public Employee() {}
	   public Employee(String fname, String lname, int salary) {
	      this.firstName = fname;
	      this.lastName = lname;
	      this.salary = salary;
	   }
	   
	/*	public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}*/
	  
	   public String getFirstName() {
	      return firstName;
	   }
	   public void setFirstName( String first_name ) {
	      this.firstName = first_name;
	   }
	   public String getLastName() {
	      return lastName;
	   }
	   public void setLastName( String last_name ) {
	      this.lastName = last_name;
	   }
	   public int getSalary() {
	      return salary;
	   }
	   public void setSalary( int salary ) {
	      this.salary = salary;
	   }
	}