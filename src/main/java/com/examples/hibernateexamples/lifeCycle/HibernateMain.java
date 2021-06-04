package com.examples.hibernateexamples.lifeCycle;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateMain {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession(); // create new session
		Transaction tx = session.beginTransaction();

		// transient state
		// life cycle of entity

		/*
		 * 1) transient state User user=new User(); 2) persistent state
		 * session.save(user);
		 * 
		 * 
		 * 3) detach 4) attach 5 removed
		 */

		Address address = new Address();
		address.setCity("coimbatore");
		address.setPinCode(641012);
		address.setState("Tamil Nadu");
		address.setStreet("kalluri");

		// user
		User user = new User();
		user.setUserName("rakesh");
		user.setDescription("hello23");
		user.setGender(Gender.female);
		user.setDob(new Date());
		user.setAddress(address);
		
		
		
		User user1 = new User();
		user1.setUserName("suresh");
		user1.setDescription("hello23");
		user1.setGender(Gender.female);
		user1.setDob(new Date());
		user1.setAddress(address);
		
		
		session.save(user);
		session.save(user1);

		
		// persistent state
		// user.setUserName("dhinesh");
		tx.commit();
		session.evict(user);
		session.close();	 // 
		
		user.setUserName("dhinesh");
		// detach state
		
		
		 Session session1=HibernateUtil.getSessionFactory().openSession();
		 Transaction tx1=session1.beginTransaction(); 
		 
		 
		 User user3=(User)session1.get(User.class, 4);	// complete
		 System.out.println("after get");
		System.out.println(user3);

		User user2=(User)session1.load(User.class, 4);	// proxy id(1)
		System.out.println("after load");
		System.out.println(user2.getUserName());		// complete
		 
		 
		 
		 // session1.remove(user);
		 tx1.commit();
		 session1.close();
		
		
		

		// detach state
		// user.setUserName("dhinesh");
		/*
		 * Session session1=HibernateUtil.getSessionFactory().openSession();
		 * Transaction tx1=session1.beginTransaction(); session1.update(user);
		 * tx1.commit();
		 * 
		 * 
		 * 
		 * 
		 * Session session1=HibernateUtil.getSessionFactory().openSession();
		 * Transaction tx1=session1.beginTransaction(); User
		 * user1=(User)session1.get(User.class, 2);
		 * System.out.println(user1.getAddress().getCity());
		 * System.out.println(user.getDob()); tx1.commit(); session.close();
		 * 
		 * // //session.saveOrUpdate(user); //session.delete(user);
		 * //System.out.println(user.getUserId()); //session.close();
		 * //session.evict(user); session.clear(); user.setUserName("rajesh");
		 * 
		 * 
		 * 
		 * Session session1=HibernateUtil.getSessionFactory().openSession();
		 * System.out.println(session1); Transaction
		 * tx1=session1.beginTransaction();
		 */

		// attach
		// session1.update(user);
		// User user1=(User)session1.get(User.class, 1001);
		// System.out.println(user1.getUserName());

		// User user2=(User)session1.load(User.class, 1001);
		// System.out.println(user2.getDescription());

		/*
		 * // ownership Employee suresh=new Employee("suresh kumar",2,"java");
		 * Department javaDepartment=new Department(1001,"chennai","java");
		 * 
		 * 
		 * //Set <Employee>employeeSet=new HashSet<Employee>();
		 * //employeeSet.add(suresh);
		 * //javaDepartment.setEmployees(employeeSet);
		 * 
		 * 
		 * suresh.setDepartment(javaDepartment);
		 * //dhinesh.setDepartment(javaDepartment); session1.save(suresh);
		 * session1.save(javaDepartment);
		 * 
		 * tx1.commit(); session1.close();
		 * 
		 * 
		 * 
		 * /*
		 * 
		 * 
		 * 
		 * // lazily loaded fetxh Session
		 * session2=HibernateUtil.getSessionFactory().openSession(); Transaction
		 * tx2=session2.beginTransaction();
		 * 
		 * //Employee emp=(Employee)session2.get(Employee.class,2); Department
		 * dept=(Department)session2.load(Department.class, 1001);
		 * 
		 * System.out.println(dept.getName()); //System.out.println("***");
		 * 
		 * // part of hibernate
		 * 
		 * //System.out.println(emp.getDepartment());
		 * //System.out.println(dept.getEmployees());
		 * 
		 * 
		 * // User user1=(User)session.get(User.class, 1001); // User
		 * user2=(User)session.load(User.class, 1001);
		 * 
		 * 
		 * tx2.commit(); session2.close();
		 * 
		 * 
		 * // detach state
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * //System.out.println(dept.getEmployees());
		 * 
		 * /*
		 * 
		 * // cascaded Session
		 * session3=HibernateUtil.getSessionFactory().openSession(); Transaction
		 * tx3=session3.beginTransaction();
		 * 
		 * //session3.update(dept);
		 * 
		 * Department
		 * department=(Department)session3.load(Department.class,dept.
		 * getDepartmentId()); System.out.println(department.getEmployees());
		 * 
		 * 
		 * tx3.commit(); session3.close();
		 * 
		 */
		 
		 
		 

	}

}
