package com.examples.hibernateexamples.hql;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class UserDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		System.out.println(sessionFactory);
		// singleton
		//Configuration SessionFactory session-->database operation
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
	   Employee ramesh=new Employee("ramesh kumar",1,"java");
		Department javaDepartment=new Department(1001,"chennai","java");
		Department netDepartment=new Department(1002,"bangalore","dotnet");
		ramesh.setDepartment(javaDepartment);
		Integer employeetId12=(Integer)session.save(ramesh);
		System.out.println(employeetId12);
		session.save(netDepartment);
		
		User user=new User();
		user.setUserName("suresh");
		user.setDescription("hello23");
		user.setDob(new Date());
		
		Address address=new Address();
		address.setCity("coimbatore");
		address.setPinCode(641012);
		address.setState("Tamil Nadu");
		address.setStreet("kalluri");
		user.setAddress(address);
		user.setUserId(9);
	
		session.save(user);
			tx.commit();
		session.close();
		
		
		// session
		// query
		// typed
		//from
		/*
		String hql="SELECT u.address.city,count(*)  FROM User u group by u.address.city having count(u.address.city)>0";
		
		
		TypedQuery<Object[]> query=session2.createQuery(hql);
			List<Object[]> users=query.getResultList();
			users.stream().forEach((object)->{
			System.out.println(object[0]+":"+object[1]);
			});

		
		*/
		
		
		
		
		
		
	//	Query<User> query=session2.createQuery("from User u where city in ('chennai','mysore')");
		//Query query=session2.createQuery("from User u where dob between '2016-01-01' and '2017-01-01'");
		//Query query=session2.createQuery("from User u where street is not null");
		//
		
	     
	     		String city="chennai";
	     		
	     	
	     		
		// aggreagate function
		// count, sum, avg 
		
		
	// from Employee where userNamel
		
		
		
		
	// implicit join
		
		// one toone
		// many to one
		
		// hql="select d, e from Department d left join d.employees e";
	     		Session session2=HibernateUtil.getSessionFactory().openSession();
	    		Transaction tx2=session2.beginTransaction();
	     		String hql="from Employee e where e.departmentId.name='java'";	// implicit join
		TypedQuery query1=session2.createQuery(hql,Employee.class);
		List<Employee> employees=query1.getResultList();
		employees.stream().forEach((employee)->{
			System.out.println(employee.getEmployeeId());
			System.out.println(employee.getDepartment().getName());
		});
		
		
		tx2.commit();
		session2.close();
		
		
		
		
		
		
		
		/*	List<Object[]> list=query1.list();
		list.stream().forEach((objects)->{
			Department department=(Department)objects[0];
			if(objects[1]!=null){
				Employee employee=(Employee)objects[1];
				System.out.println(employee.getStaffName()+", "+department.getLocation()+", "+department.getName());
				
			}else{
				System.out.println(department.getLocation()+", "+department.getName());
					
			}
			});*/
		
		
		/*	
		// explicit join
		
		// one toone
		// many to one'
		
	// join
		
		
			
		
		// From clause
		

		// conditions
	/*	
		Query query = session2.getNamedQuery("User.byCity");
		query.setString("city", "banglore");
		List<User> users=query.list();
		users.stream().forEach((user)->{
				System.out.println(user.getUserId()+":"+user.getUserName());
			});
	
		
		

		String hql="SELECT u.address.city,count(*) FROM User u group by u.address.city having count(u.address.city)>1";
		Query query=session2.createQuery(hql);
		List<Object> list=query.list();
		
		Iterator iterator=list.iterator();
		System.out.println("Employee City---Count");
		while(iterator.hasNext()){
			Object []obj = (Object[])iterator.next();
			System.out.print(obj[0]);
			System.out.print("\t\t"+obj[1]);
			System.out.println();
		}
		
		*/	
		//	avg, sum, total, count
		
		
		
		
		
		// Hibernate and JPA support two types of parameter binding:
		//	Named parameter binding
		//	Positional parameter binding
		Query query=session2.createQuery("from User u where city=?");
		 query.setString(0, "banglore");
		//Query query1=session2.createQuery("from User u where city=:city");
		// query1.setString("city", "banglore");
		
		
		// named query
		Query query2 = session2.getNamedQuery("User.byCity");
		query.setString("city", "banglore");
		//users.stream().forEach(
		//(user1)->	{
		//	System.out.println(user1.getUserName());
		//});

		TypedQuery <User>query6 = session2.createNativeQuery("select * from User",User.class);
		List<User> users=query6.getResultList();
		
		//using select clause
		//Query query = session2.createQuery("select avg(user.phoneNo) from User user");
		//Query query = session2.createQuery("select user.userId, user.userName from User user");
	
		String hql1="SELECT u.gender ,count(*) FROM User u GROUP BY u.gender having count(*) >2 ";
		Query query7=session2.createQuery(hql1);
		List<Object> list=query.list();
		
		Iterator iterator=list.iterator();
		System.out.println("Employee Type ---Count");
		while(iterator.hasNext()){
			Object []obj = (Object[])iterator.next();
			System.out.print(obj[0]);
			System.out.print("\t\t"+obj[1]);
			System.out.println();
		}
		
		
		
		/*
		// joins
		 * 
		 * 
		 * 
		 */
		
		
		
		// implicit join
		
		//Department
			
		
		//Query query = session2.createQuery("from Department d  join Employee e  where d.employees.name='ramesh');
		// List<Department>
		
		
		//
		//Query query = session2.createQuery("from Employee e where e.departmentId.name='java'");
		/*
		Query query = session2.createQuery("select d.name,e.staffName from Department d join Employee e");
		List<Object> users=query.list();
		users.stream().forEach(
				(obj)->	{
					System.out.println(obj[0]+","+obj[1]);
					Department dept=(Department)obj[0];
					System.out.println(dept.getName());
					
					if(obj[1]!=null){
					Employee employee=(Employee)obj[1];
					System.out.println(employee.getEmployeeId());
					}
				});
		
		// Explicit Joins
		
		Query query = session2.createQuery("select d, e from Department d left join d.employees e");
		*/	
		
		
		
		
	
	
		
		
		
		
		
		
		
		// criteria
		
		
		
		
		
		
		
		
	
	
	}

}
