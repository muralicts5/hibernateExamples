package com.examples.hibernateexamples.lifeCycle;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserDemo {

	public static void main(String[] args) {

		
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		System.out.println(sessionFactory);
		// singleton
		//Configuration SessionFactory session-->database operation
	
	
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		
		// Transient
		User user=new User();
		user.setUserName("suresh");
		user.setDescription("hello23");
		user.setGender(Gender.female);
		user.setDob(new Date());
		
		Address address=new Address();
		address.setCity("coimbatore");
		address.setPinCode(641012);
		address.setState("Tamil Nadu");
		address.setStreet("kalluri");
		user.setAddress(address);
		user.setUserId(9);
	
		session.save(user);
		// Persistent state
		user.setUserName("rakesh");
	
		
		tx.commit();
		session.close();
		user.setUserName("mahesh");
	
		// detached state
		
		
		Session session2=HibernateUtil.getSessionFactory().openSession();
		Transaction tx2=session2.beginTransaction();
		
		User user1=(User)session2.get(User.class, 6);
		System.out.println("after loading"+user.getDescription());
		//System.out.println(user1.getUserName());
		
		tx2.commit();
		session2.close();
		
	}

}
