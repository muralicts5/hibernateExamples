package com.examples.hibernateexamples.inheritance.tablepersub;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.examples.hibernateexamples.HibernateUtil;


public class Client {

	public static void main(String[] args) {

		SessionFactory sf=null;
		Session session=null;
		Transaction tr=null;

		try{
			sf=HibernateUtil.getSessionFactory();
			session=sf.openSession();
			tr=session.beginTransaction();
			BillingDetailss ba=new BankAccounts();
			ba.setOwner("dhinesh");
			BankAccounts ba1=(BankAccounts)ba;
			ba1.setAccount("B1001");
			ba1.setBankName("ICICC");
			session.save(ba);
			tr.commit();

			tr=session.beginTransaction();
			BillingDetailss ca=new CreditCards();
			ca.setOwner("rakesh");
			CreditCards cc1=(CreditCards)ca;
			cc1.setExpMonth("March");
			cc1.setExpYear("2009");
			cc1.setNumber("S2001");
			//session.save(ca);
			tr.commit();
			

			List<BillingDetailss> l1= session.createQuery("from BillingDetailss").list();
			for( int i=0;i<l1.size();i++)
			{
				BillingDetailss o=(BillingDetailss)l1.get(i);
				System.out.println("Bank Details:  "+o.getId());
				if(o instanceof BankAccounts){
					BankAccounts bank=(BankAccounts)o;
					System.out.print(bank.getAccount()+"  "+bank.getBankName());
					System.out.println();
				}
				else
				{
					CreditCards cc=(CreditCards)o;
					System.out.print(cc.getExpMonth()+"  "+cc.getExpYear()+ "    "+cc.getNumber());
					System.out.println();
				}
			}
		}
		
		
		catch(Exception e){
			System.out.println(e);
			
			session.close();
		}

	}  
}