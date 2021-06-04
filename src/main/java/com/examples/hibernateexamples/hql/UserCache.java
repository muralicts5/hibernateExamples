package com.examples.hibernateexamples.hql;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;




public class UserCache {

	public static void main(String[] args) throws InterruptedException {
		
		
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		    entityManager.getTransaction().begin();

		    User user=new User();
			user.setUserName("suresh");
			user.setDescription("hello23");
			//user.setGender(Gender.female);
			user.setDob(new Date());
			
			Address address=new Address();
			address.setCity("coimbatore");
			address.setPinCode(641012);
			address.setState("Tamil Nadu");
			address.setStreet("kalluri");
			user.setAddress(address);
			//user.setUserId(9);
		
		    //get
		    User user1=(User)entityManager.find(User.class, new Integer(2));
			System.out.println(user1);
			
			//save
			entityManager.persist(user);
			System.out.println(user.getUserId());
			
			//update
			user.setUserName("rohit");
			entityManager.merge(user);
			
			//delete
			entityManager.remove(user);
			
		
			 Query query1 = entityManager.
				      createQuery("Select UPPER(e.ename) from Employee e");
				      List<String> list = query1.getResultList();

				      for(String e:list) {
				         System.out.println("Employee NAME :"+e);
				      }
				      
				      //Aggregate function
				      query1 = entityManager.createQuery("Select MAX(e.salary) from Employee e");
				      Double result = (Double) query1.getSingleResult();
				      System.out.println("Max Employee Salary :" + result);
			
	
						// query
						TypedQuery<User> query=entityManager.createQuery("from User", User.class);
					
						List<User> users=query.getResultList();
						users.stream().forEach((user3)->{
							System.out.println(user3.getUserName());
						});	
						/**/		
			
		    entityManager.getTransaction().commit();
		    entityManager.close();
		    JPAUtil.shutdown();
		    /*
		// first level cache
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		
		// session ---> first level cache
		// These entity objects are maintained inside the session
		// 
		User user=(User)session.get(User.class, new Integer(2));
		System.out.println(user);
		//System.out.println(user.getUserName());
		
	
		tx.commit();
		session.close();
		
	
		
		 Session session4=HibernateUtil.getSessionFactory().openSession();
			Transaction tx4=session4.beginTransaction();
			user.setUserName("rohit");
			session4.update(user);
			tx4.commit();
		session4.close();

		//for(int i=0;i<5;i++)
		//{
			 Session session3=HibernateUtil.getSessionFactory().openSession();
				Transaction tx3=session3.beginTransaction();
			User user1=(User)session3.get(User.class, new Integer(2));
			System.out.println(user1);
			System.out.println(user1.getUserName());	
			//Thread.sleep(2000);
			//tx3.commit();
			//session3.close();
		//}
		*/
		
	}
}


