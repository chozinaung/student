package student.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import student.model.Login;
import student.model.User;

public class UserReposistory {
	private static final String Code = null;
	// connection
	public static Connection con = null;
	static {
		con = MyConnection.getConnection();
	}
	
	//login user
		public User getByLogin(Login login) {
			User user=new User();
			String sql="SELECT * FROM user where username=? and password=?";
					try {
						PreparedStatement ps=con.prepareStatement(sql);
						ps.setString(1, login.getUsername());
						ps.setString(2,login.getPassword());
						ResultSet rs=ps.executeQuery();
						while(rs.next()) {
							user.setId(rs.getInt("id"));
							user.setUsername(rs.getString("username"));
							user.setPassword(rs.getString("password"));
							user.setEmail(rs.getString("email"));
							user.setUserrole(rs.getString("userrole"));
						}
					}catch(SQLException e){
						
						System.out.println("User getByLogin err:" +e);
						
					}
					return user;
		}






	// insert
	public int add(User user) {
		int result = 0;
		String sql = "INSERT INTO user(id,username,password,email,userrole)VALUES(?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,  user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3,  user.getPassword());
			ps.setString(4,  user.getEmail());
			ps.setString(5,  user.getUserrole());
			

			result = ps.executeUpdate();

		} catch (SQLException e) {
			result = 0;
			System.out.println("user insert error :  " + e);
		}
		return result;
}
	// Update
		public int Update(User user) {
			int result = 0;
			String sql = "UPDATE author SET id=?,username=?,password=?,email=?userrole WHERE id =?";

			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, user.getId());
				ps.setString(2, user.getUsername());
				ps.setString(3,  user.getPassword());
				ps.setString(4,  user.getEmail());
				ps.setString(5,  user.getUserrole());
				

				ps.setInt(1, user.getId());

				result = ps.executeUpdate();

			} catch (SQLException e) {
				result = 0;
				System.out.println("author edit error :  " + e);
			}
			return result;

		}

	//delete
		public int delete(String code) {
			int result = 0;
			String sql = "DELETE FROM user WHERE id=?";

			try {
				PreparedStatement ps = con.prepareStatement(sql);
				

				result = ps.executeUpdate();

			} catch (SQLException e) {
				result = 0;

			}
			return result;
		}
	// getAll

public List<User> getAll() {
	
	List<User> users = new ArrayList<>();
	String sql = "SELECT *FROM user";

	try {
		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			user.setUserrole(rs.getString("userrole"));
			users.add(user);
		}
	} catch (SQLException e) {
		System.out.println("user select error :  " + e);
		return users;
	}
	return users;
}

// getone

public User getById(int id) {
	User user = null;
	String sql = "SELECT *FROM user WHERE id=?";
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			user = new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			user.setUserrole(rs.getString("userrole"));
			
		}
	} catch (SQLException e) {
		user = null;

		System.out.println("user getByCode error :  " + e);

	}
	return user;

}
	
}
