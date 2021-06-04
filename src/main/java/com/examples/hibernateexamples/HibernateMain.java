	package com.examples.hibernateexamples;
	
	import java.util.Date;
	
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
	import org.hibernate.cfg.Configuration;
	
	public class HibernateMain {
	
		public static void main(String[] args) {
			
			//SessionFactory sessions=new Configuration().configure().buildSessionFactory();
	
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
					.configure().build();
			
			SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			
			Session session=factory.openSession();
			Transaction tx=session.beginTransaction();
			
			User user=new User();
			user.setUserId(1001);
			user.setUserName("ramesh");
			user.setDescription("hello ramesh");
			user.setPhoneNo(343434);
			user.setDob(new Date());
		
			

			Employee ramesh=new Employee();
			//ramesh.setId(1008);
			ramesh.setFirstName("rakesh");
			ramesh.setLastName("kumar");
			ramesh.setSalary(15000);
			
			EmployeeSSN employeePrimary=new EmployeeSSN();
			employeePrimary.setEmployeeId(1003);
			employeePrimary.setSsn(343532);
			
			
			
			Employee suresh=new Employee();
			//ramesh.setId(1008);
			suresh.setFirstName("suresh");
			suresh.setLastName("kumar");
			suresh.setSalary(25000);
			
			Address address=new Address();
			address.setCity("coimbatore");
			address.setCountry("india");
			address.setPinCode(641004);
			address.setState("Tamil Nadu");
			address.setStreet("kalluri");
		
			ramesh.setAddress(address);
			suresh.setAddress(address);
			
			
			EmployeeSSN employeePrimary1=new EmployeeSSN();
			employeePrimary1.setEmployeeId(1003);
			employeePrimary1.setSsn(1453412);
			
			ramesh.setEmployeeSSN(employeePrimary);
			suresh.setEmployeeSSN(employeePrimary1);
		
			session.save(user);
			session.save(ramesh);
			session.save(suresh);
			
			tx.commit();
			session.close();
			
		/*	
			
			
			Employee ramesh=new Employee();
			//ramesh.setId(1008);
			EmployeeSSN employeePrimary=new EmployeeSSN();
			employeePrimary.setEmployeeId(1003);
			employeePrimary.setSsn(343532);
			ramesh.setEmployeeSSN(employeePrimary);
			
			
			ramesh.setFirstName("rakesh");
			ramesh.setLastName("kumar");
			ramesh.setSalary(15000);
			
			Address address=new Address();
			address.setCity("coimbatore");
			address.setCountry("india");
			address.setPinCode(641004);
			address.setState("Tamil Nadu");
			address.setStreet("kalluri");
			ramesh.setAddress(address);
			session.save(ramesh);
		*/	
			
		}
	
	}
