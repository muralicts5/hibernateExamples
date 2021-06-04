package com.examples.hibernateexamples.association.manytomany;


import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;




public class SchoolClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session=null;
		Transaction tr=null;

		try{
			SessionFactory sf=HibernateUtil.getSessionFactory();
			session=sf.openSession();
			tr=session.beginTransaction();

			Course course=new Course();
			course.setCourseName("java");
			course.setCouseCode(1);
			course.setSubject("computer");

			Student dhinesh=new Student();  
			dhinesh.setStudentId(1001);
			dhinesh.setStudentName("dhinesh");
			
			Student ramesh=new Student();  
			ramesh.setStudentId(1002);
			ramesh.setStudentName("reamesh");
			
			Set <Student> students=new HashSet<Student>();
			students.add(dhinesh);
			students.add(ramesh);
			course.setStudents(students);

			session.save(course);
			
			tr.commit();
		}catch(Exception e){
			System.out.println(e +"  Error with Centre insert block");
			tr.rollback();
			session.close();
		}

	}

}