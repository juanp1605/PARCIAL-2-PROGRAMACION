package modelo;

import db.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Grade {

    private int id;
    private int enrollment_id;
    private int grade_type_id;
    private double grade;

    public Grade(int id, int enrollment_id, int grade_type_id, double grade) {
        this.id = id;
        this.enrollment_id = enrollment_id;
        this.grade_type_id = grade_type_id;
        this.grade = grade;
    }

    public int getId() { return id; }

    public int getEnrollment_id() { return enrollment_id; }

    public int getGrade_type_id() { return grade_type_id; }

    public double getGrade() { return grade; }

    public static void insertGrade(Grade grade) {
        Connection con = connection.getConnection();

        String sql = "INSERT INTO grades (id, enrrollment_id, grade_type_id, grade) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, grade.getId());
            statement.setInt(2, grade.getEnrollment_id());
            statement.setInt(3, grade.getGrade_type_id());
            statement.setDouble(4, grade.getGrade());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Grade> getAllGrades() {
        Connection con = connection.getConnection();
        List<Grade> grades = new ArrayList<>();

        String sql = "SELECT * FROM grades";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Grade grade = new Grade(
                        rs.getInt("id"),
                        rs.getInt("enrrollment_id"),
                        rs.getInt("grade_type_id"),
                        rs.getDouble("grade")
                );
                grades.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grades;
    }
}