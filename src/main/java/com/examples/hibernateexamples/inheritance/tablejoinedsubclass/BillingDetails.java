package com.examples.hibernateexamples.inheritance.tablejoinedsubclass;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


// hql
// criteria and caching
// spring boot
// spring testing and angular
// maven


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class BillingDetails {

	public BillingDetails() {
	}
	protected String owner;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BILLING_DETAILS_ID")
	protected long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOwner(){
		return owner;
	}
	public void setOwner(String owner){
		this.owner=owner;
	}
}

