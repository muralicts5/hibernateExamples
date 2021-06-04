	package com.examples.hibernateexamples.hql;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

public class UserCriteraia {

	public static void main(String[] args) {
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		Session session1=sessionFactory.openSession();
		///*	
		Transaction tx1=session1.beginTransaction();
	    
		Employee ramesh=new Employee("ramesh kumar",1,"java");
	    Employee suresh=new Employee("suresh",2,"java");
	    Employee dhinesh=new Employee("dhinesh",3,"not alloted");
	    
	    Department javaDepartment=new Department(1001,"chennai","java");
		Department netDepartment=new Department(1002,"bangalore","dotnet");
		
		session1.save(javaDepartment);
		session1.save(netDepartment);
		
		ramesh.setDepartment(javaDepartment);
		suresh.setDepartment(javaDepartment);
		
		Integer employeetId12=(Integer)session1.save(ramesh);
		Integer employeetId13=(Integer)session1.save(suresh);
		Integer employeetId14=(Integer)session1.save(dhinesh);
		
		System.out.println(employeetId12);
		System.out.println(employeetId13);
	
		
		tx1.commit();
		session1.close();
		// */
		/*
		// from USer
		Criteria userCriteria=session.createCriteria(User.class);
		List<User> users=userCriteria.list();
		
		// from User
		users.stream().forEach((user)->{
			System.out.println(user.getUserId());
			System.out.println(user.getUserName());
		});
		
				*/
		
	
		// condition where like
		// Restrictions
		
		/*	
		Criteria userCriteria=session.createCriteria(User.class);
		
		Criterion nameLikeCriterion=Restrictions.like("userName", "%esh");	// instance variable and value
		Criterion streetCriterion=Restrictions.isNotNull("address.street");
		userCriteria.add(nameLikeCriterion);
		userCriteria.add(streetCriterion);
		List<User> users=userCriteria.list();
		
		// from User
		users.stream().forEach((user)->{
			System.out.println(user.getUserId()+" + "+user.getUserName());
		});
		 */		
		
		

		/*
		gt (greater than)
		lt (less than)
		ge (greater than or equal to)
		idEq (ID is equal to)
		ilike (a case-insensitive like, similar to the PostgreSQL ilike operator)
		is Null
		isNotNull
		isEmpty
		isNotEmpty
		between	in (applies an “in” constraint to the named property)
		le (less than or equal to)
		*/
		/*	
		
		Criteria criteria = session.createCriteria(User.class)
		        .add(Restrictions.or(
		        		Restrictions.like("userName", "%mesh"),
						Restrictions.isNotNull("address.street")
				                )
		        		)
		        .add(Restrictions.between("address.pinCode", new Integer(3000), new Integer(4000)));
		
		List <User>users = criteria.list();
				users.stream().forEach((user)->{
					System.out.println(user.getUserId()+" + "+user.getUserName());
				});
		
		 */	
		// orderby
		// Order
		/*
		Criteria criteria = session.createCriteria(User.class)
		        .add(Restrictions.or(
		        		Restrictions.like("userName", "%mesh"),
						Restrictions.isNotNull("address.street")
				                )
		        		).add(Restrictions.between("address.pinCode", new Integer(3000), new Integer(4000)))
					.addOrder( Order.asc("userName") )
					.addOrder( Order.desc("address.pinCode") )
					.setMaxResults(2);
		List <User>users = criteria.list();
				users.stream().forEach((user)->{
					System.out.println(user.getUserId()+" + "+user.getUserName());
				});
		
		*/	
		
		//select max(*) from Employee where username = and date between order by date
		
		// aggregate function and groupby 
		// Projections
				
	/*
	 	List <Integer>results = session.createCriteria(User.class)
			    .setProjection( Projections.max("address.pinCode") )
			    .add(Restrictions.like("userName", "%esh"))
			    .list();
			    		System.out.println(results);
	*/
	
			    		
			    		
				
				
	/*	
		List <Object[]>results = session.createCriteria(User.class)
			    .setProjection( Projections.projectionList()
			        .add( Projections.rowCount() )
			        .add( Projections.avg("address.pinCode") )
			        .add( Projections.max("userId") )
			    )
			    .list();
		
		
		results.stream().forEach((obj)->{
				System.out.println(obj[0]+", "+obj[1]+", "+obj[2]);
		});
		*/
		
		
		// select count(*), state from emp group by state
		
		
		// select  state from emp group by state;
		
/*
		List <Object[]>results = session.createCriteria(User.class)
			    .setProjection( Projections.projectionList()
			    		.add( Projections.rowCount() )
			    		.add( Projections.groupProperty("address.state"))
			    )
			    .list();
		
		
		results.stream().forEach((obj)->{
				System.out.println(obj[0]+" "+obj[1]);
		});
		*/
	
		
		
		// User	--> select * from User
		//criterion	--> Restrictions --> Restrictions.lt
		// addORder	---> order by	---> addOrder(Order.asc())
		// count, avg, min, max	--> Projections	---> Projections.avg groupProperty
		// join
		
		
		// Association joins
		// First Method
		
		// from Employee e where e.department.name=java 

/*
 	List <Employee>employees = session.createCriteria(Employee.class)
			    .add( Restrictions.like("staffName", "r%") )
			    .createCriteria("departmentId")
			      //  .add( Restrictions.like("name", "j%") )
			    .list();
 
		employees.stream().forEach((employee)->{
			System.out.println(employee.getStaffName());
			System.out.println(employee.getDepartment());
		});
	*/	
	
	
	/*
	List <Map>employees = session.createCriteria(Employee.class,"emp")
		    .add( Restrictions.like("staffName", "r%") )
		    .createCriteria("departmentId","dept")
		        .add( Restrictions.like("name", "j%") )
		      .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP) 
		    .list();
	
		employees.stream().forEach((map)->{
			Department department = (Department)map.get("dept");
			System.out.println(department.getDepartmentId());
			Employee e= (Employee) map.get("emp");
			System.out.println(e.getEmployeeId());
		});
		*/
		
		// select * from department d join emp e on d.dept_id=e.dept_id
		/// select d,e from Department d join d.employees;
		
		//Employee e=(Employee)session.get(Employee.class, 3);
		//System.out.println(e.getStaffName());
		
	/*
		List<Department> departments = session.createCriteria(Department.class,"d")
						.createAlias("d.employees", "e")
						.list();
		
		departments.stream().forEach((department)->{
			System.out.println(department.getDepartmentId());
			System.out.println(department.getEmployees());
		});
	
	*/	
/*
		DEFAULT: The default setting that is used from the configuration file.
		EAGER: Deprecated. Use FetchMode.JOIN instead.
		JOIN: Retrieves the associated object’s data by using an outer join.
		LAZY: Deprecated. Use FetchMode.SELECT instead.
		SELECT: Fetches eagerly using an additional SELECT query. 
		Unless the lazy option is disabled explicitly in the configuration file,
		 the second SELECT query is executed when the association is accessed.
*/

	///*	
		List<Department> departments = session.createCriteria(Department.class,"department")
				.setFetchMode("employees", FetchMode.JOIN)
				.list();

		departments.stream().forEach((department)->{
				System.out.println(department.getDepartmentId());
				System.out.println(department.getEmployees().size());
		});
		//*/
		
		tx.commit();
		session.close();
		
		}

	
}
