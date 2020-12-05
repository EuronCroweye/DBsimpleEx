package mainApp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import emplyees.Employee;

public class RetrievCompanyNameApp {

	public static void main(String[] args) {
	SessionFactory factory =new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Employee.class)
			.buildSessionFactory();
	
	Session session= factory.getCurrentSession();
	
	try {
		
		int employeeId=1;
		session.beginTransaction();
		



		List<Employee> employees=
				session
				.createQuery("from Employee where company='Burger'")
				.getResultList();
		
		for(Employee theEmployee:employees) {
		System.out.println(theEmployee);
		}
		
		session.getTransaction().commit();
		
		
		
		
		
	}
		finally{
			factory.close();
		}
	
	
	
	}
}
