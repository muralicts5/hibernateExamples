package com.examples.hibernateexamples.association.onetoone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserClient {

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

			Users user=new Users();
			user.setName("suresh");
			user.setType("premium");
			user.setUserId(1);

		
			Address address=new Address();
			address.setAddressId(3);
			address.setCity("la");
			address.setCountry("USA");
			address.setStreet("kalluri");

			user.setAddress(address);
			address.setUser(user);

			session.save(address);
			tr.commit();


		}catch(Exception e){
			System.out.println(e +"  Error with Centre insert block");
			tr.rollback();
			session.close();
		}

	}

}