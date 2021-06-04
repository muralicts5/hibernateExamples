package com.examples.hibernateexamples.inheritance.tablejoinedsubclass;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Client {

	public static void main(String[] args) {
		SessionFactory sf=null;
		Session session=null;
		Transaction tr=null;

		try{
			sf=HibernateUtil.getSessionFactory();
			session=sf.openSession();
			tr=session.beginTransaction();
			BillingDetails ba=new BankAccount();
			
			ba.setOwner("Simson");
			BankAccount ba1=(BankAccount)ba;
			ba1.setAccount("A10001");
			ba1.setBankName("HDFC");
			session.save(ba);
			tr.commit();

			tr=session.beginTransaction();
			BillingDetails ca=new CreditCard();
			ca.setOwner("Henry");
			CreditCard cc1=(CreditCard)ca;
			cc1.setExpMonth("March");  
			cc1.setExpYear("2009");
			cc1.setNumber("S2001"); 
			session.save(ca);
			tr.commit();

			List l1= session.createQuery("from BillingDetails").list();
			for( int i=0;i<l1.size();i++)
			{
				BillingDetails o=(BillingDetails)l1.get(i);
				System.out.println("Bank Details:  "+o.getId());
				if(o instanceof BankAccount){
					BankAccount bank=(BankAccount)o;
					System.out.print(bank.getAccount()+"  "+bank.getBankName());
					System.out.println();
				}
				else
				{
					CreditCard cc=(CreditCard)o;
					System.out.print(cc.getExpMonth()+"  "+cc.getExpYear()+ "    "+cc.getNumber());
					System.out.println();
				}
			}
		}
		catch(Exception e){
			System.out.println("Error with insert block");
			tr.rollback();
			session.close();
		}
	}  
}