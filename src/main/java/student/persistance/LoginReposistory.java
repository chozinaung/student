package student.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import student.model.Login;

public class LoginReposistory {
	// connection
		public static Connection con = null;
		static {
			con = MyConnection.getConnection();
		}

		// insert
		public int add(Login login) {
			int result = 0;
			String sql = "INSERT INTO user(id,username,password,email,userrole)VALUES(?,?,?,?,?)";

			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, login.getId());
				ps.setString(2, login.getUsername());
				ps.setString(3, login.getPassword());
				ps.setString(4, login.getEmail());
				ps.setString(5, login.getUserrole());

				result = ps.executeUpdate();

			} catch (SQLException e) {
				result = 0;
				System.out.println("author insert error :  " + e);
			}
			return result;

		}

}
