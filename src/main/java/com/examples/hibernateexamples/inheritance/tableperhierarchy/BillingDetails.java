package com.examples.hibernateexamples.inheritance.tableperhierarchy;


import javax.persistence.*;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="BILLING_DETAILS_TYPE",
discriminatorType=DiscriminatorType.STRING)

@Table(name="bill")
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
