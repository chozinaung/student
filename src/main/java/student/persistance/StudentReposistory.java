package student.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import student.model.Course;
import student.model.Student;


public class StudentReposistory {
	private static final String Code = null;
	// connection
	public static Connection con = null;
	static {
		con = MyConnection.getConnection();
	}
	
	//login student
		public Student getByStudent(Student student) {
			Student students=new Student();
			String sql="SELECT * FROM student where name=? and id=?";
					try {
						PreparedStatement ps=con.prepareStatement(sql);
						ps.setInt(1, student.getId());
						ps.setString(2,student.getName());
						ResultSet rs=ps.executeQuery();
						while(rs.next()) {
							student.setId(rs.getInt("id"));
							student.setName(rs.getString("name"));
							student.setBirthday(rs.getString("bitthday"));
							student.setGender(rs.getString("gender"));
							student.setPhone(rs.getString("phone"));
							student.setEducation(rs.getString("education"));
						}
					}catch(SQLException e){
						
						System.out.println("student getByLogin err:" +e);
						
					}
					return students;
		}






	// insert
	public int add(Student student) {
		
	
		String sql = "INSERT INTO student(id,name,bitthday,gender,phone,education)VALUES(?,?,?,?,?,?)";
		int result = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setString(3, student.getBirthday());
			ps.setString(4,  student.getGender());
			ps.setString(5,  student.getPhone());
			ps.setString(6,  student.getEducation());
			ps.executeUpdate();
			
			

		} catch (SQLException e) {
			result = 0;
			System.out.println("student insert error :  " + e);
		}
		return result;

	}
//	getAll

		public List<Student> getAll() {
		
		List<Student> students = new ArrayList<>();
		String sql = "SELECT *FROM student";

		
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Student student=new Student();
				ps.setInt(1, student.getId());
				ps.setString(2, student.getName());
				ps.setString(3, student.getBirthday());
				ps.setString(4,  student.getGender());
				ps.setString(5,  student.getPhone());
				ps.setString(6,  student.getEducation());
				

				students.add(student);
			}
		} catch (SQLException e) {
			System.out.println("student select error :  " + e);
			return students;
		}
		return students;
	}
		
		// getone

		public Student getById(int id) {
		Student student = null;
			String sql = "SELECT *FROM student WHERE id=?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
				      student = new Student();
					student.setId(rs.getInt("id"));
					student.setName(rs.getString("name"));
				    student.setGender(rs.getString("gender"));
				    student.setBirthday(rs.getString("bitthday"));
					student.setPhone(rs.getString("phone"));
					student.setEducation(rs.getString("education"));

				}
			} catch (SQLException e) {
			student = null;

				System.out.println("author getByCode error :  " + e);

			}
			return student;

		}

}
