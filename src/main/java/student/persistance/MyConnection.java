package student.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	
	static Connection con=null;
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String db = "jdbc:mysql://localhost:3306/student_m_m";
			String username = "root";
			String password = "root";
		    con = DriverManager.getConnection(db, username, password);
			System.out.println("OKKKKKKK");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver class not found");
		}

		catch (SQLException e) {
			System.out.println("Database connection is not ok"+e);
		}
		return con;
	}

		
	}


