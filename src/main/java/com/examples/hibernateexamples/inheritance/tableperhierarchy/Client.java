package com.examples.hibernateexamples.inheritance.tableperhierarchy;

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
		//try{
			sf=HibernateUtil.getSessionFactory();
			session=sf.openSession();
			tr=session.beginTransaction();
			BankAccount ba=new BankAccount();
			ba.setOwner("Simson");
			ba.setAccount("A10001");
			ba.setBankName("HDFC");
			
			
			CreditCard cd=new CreditCard();
			cd.setOwner("dhinesh");
			cd.setExpMonth("May");
			cd.setExpYear("2056");
			cd.setNumber("4545553535345");
			
			session.save(ba);
			session.save(cd);
			
			
			tr.commit();
			
			
			
			
			
			
		}  
}