package mainApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import emplyees.Employee;

public class App {

	public static void main(String[] args) {
	SessionFactory factory =new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Employee.class)
			.buildSessionFactory();
	
	Session session= factory.getCurrentSession();
	
	try {
		
		Employee emp1=new Employee("All","Pacino","Donkey");
		Employee emp2=new Employee("Luu","Foo","Donkey");
		Employee emp3=new Employee("Vegas","Mary","Burger");
		session.beginTransaction();
		session.save(emp1);
		session.save(emp2);
		session.save(emp3);
		session.getTransaction().commit();
		
		
		
		
		
	}
		finally{
			factory.close();
		}
	
	
	
	}
}
