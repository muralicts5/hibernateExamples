package com.examples.hibernateexamples.lifeCycle;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeDep {

	public static void main(String[] args) {
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx1=session.beginTransaction();
		
		Employee suresh=new Employee("suresh kumar",2,"java");
		Department javaDepartment=new Department(1001,"chennai","java");
					
		
		//Set <Employee>employeeSet=new HashSet<Employee>();
		//employeeSet.add(suresh);
		//javaDepartment.setEmployees(employeeSet);
					
					suresh.setDepartment(javaDepartment);
					//dhinesh.setDepartment(javaDepartment);
					session.save(suresh);	
					session.save(javaDepartment);
				
					tx1.commit();
					session.close();

					Session session2=HibernateUtil.getSessionFactory().openSession();
					Transaction tx2=session2.beginTransaction();			
					
					//onetoone //eager
					// onetomany // lazy
					// manytomany // lazy
					//many to one	// eager
					//one to many	// lazy
					//employee-->departmetn
					
					//Employee e=(Employee)session2.get(Employee.class, 2);
					//System.out.println(e.getStaffName());
					//System.out.println(e.getDepartment().getName());
					
						
					//Department dept=(Department)session2.get(Department.class, 1001);
					//System.out.println(dept.getLocation());
					//System.out.println("**********");
					//System.out.println(dept.getEmployees().size());
					
					//employee id ----> Deparment object
					
					tx2.commit();
					session2.close();

					Session session3=HibernateUtil.getSessionFactory().openSession();
					Transaction tx3=session3.beginTransaction();
					Employee e=(Employee)session3.load(Employee.class, 2);
					System.out.println("******");
					System.out.println(e.getDepartment());
					
					//session3.update(dept);
				
					tx3.commit();
					session3.close();
	}

}
