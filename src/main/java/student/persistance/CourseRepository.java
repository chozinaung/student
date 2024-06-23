package student.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import student.model.Course;

public class CourseRepository {
    // Connection
    public static Connection con = null;

    static {
        con = MyConnection.getConnection();
    }

    public int add(Course course) {
        String sql = "INSERT INTO course(id, name) VALUES(?, ?)";
        int result = 0;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, course.getId());
            ps.setString(2, course.getName());
            result = ps.executeUpdate();
            
           
        } catch (SQLException e) {
            System.out.println("Course insert error: " + e);
        }
        return result;
    }

    public int edit(Course course) {
        String sql = "UPDATE course SET name=? WHERE id=?";
        int result = 0;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, course.getName());
            ps.setInt(2, course.getId());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Course edit error: " + e);
        }
        return result;
    }

    public int delete(int id) {
        String sql = "DELETE FROM course WHERE id=?";
        int result = 0;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Course delete error: " + e);
        }
        return result;
    }

    public List<Course> getAll() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM course";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getInt("id"));
                course.setName(rs.getString("name"));
                courses.add(course);
            }
        } catch (SQLException e) {
            System.out.println("Course select error: " + e);
        }
        return courses;
    }

    public Course getById(int id) {
        Course course = null;
        String sql = "SELECT * FROM course WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    course = new Course();
                    course.setId(rs.getInt("id"));
                    course.setName(rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Course getById error: " + e);
        }
        return course;
    }
}
