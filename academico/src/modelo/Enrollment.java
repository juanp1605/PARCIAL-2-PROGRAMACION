package modelo;

import db.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Enrollment {
    private int id;
    private int studentId;
    private int courseId;
    private String createdAt;

    public Enrollment(int id, int studentId, int courseId, String createdAt) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public static void insertEnrollment(Enrollment enrollment) {
        Connection con = connection.getConnection();

        String sql = "INSERT INTO enrollment (id, student_id, course_id, created_at) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, enrollment.getId());
            statement.setInt(2, enrollment.getStudentId());
            statement.setInt(3, enrollment.getCourseId());
            statement.setString(4, enrollment.getCreatedAt());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Enrollment> getAllEnrollments() {
        Connection con = connection.getConnection();
        List<Enrollment> enrollments = new ArrayList<>();

        String sql = "SELECT * FROM enrollment";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Enrollment enrollment = new Enrollment(
                        rs.getInt("id"),
                        rs.getInt("student_id"),
                        rs.getInt("course_id"),
                        rs.getString("created_at")
                );
                enrollments.add(enrollment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enrollments;
    }
}