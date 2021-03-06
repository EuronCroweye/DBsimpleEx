package mainApp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import emplyees.Employee;

public class RetrievApp {

	public static void main(String[] args) {
	SessionFactory factory =new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Employee.class)
			.buildSessionFactory();
	
	Session session= factory.getCurrentSession();
	
	try {
		
		int employeeId=1;
		session.beginTransaction();
		
		Employee theOne= session.get(Employee.class, employeeId);
		System.out.println(theOne);

		List<Employee> employees=
				session
				.createQuery("from Employee")
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
