package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		
		String jdbcUrl="jdbc:mysql://localhost:3306/cotumer_employee?useSSL=false&serverTimezone=UTC";
		String user="hbstudent";
		String pass="hbstudent";
		
		try {
		System.out.println("Connectiog to database"+ jdbcUrl);
		
		Connection myConn=
				DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection successful!");
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
