package modelo;

import db.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeType {
    private int id;
    private String name;
    private double weight; // Cambiado a double para reflejar DECIMAL(5,2)
    private String createdAt;

    public GradeType(int id, String name, double weight, String createdAt) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public static void insertGradeType(GradeType gradeType) {
        Connection con = connection.getConnection();

        String sql = "INSERT INTO grade_type (id, name, weight, created_at) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, gradeType.getId());
            statement.setString(2, gradeType.getName());
            statement.setDouble(3, gradeType.getWeight());
            statement.setString(4, gradeType.getCreatedAt());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<GradeType> getAllGradeTypes() {
        Connection con = connection.getConnection();
        List<GradeType> gradeTypes = new ArrayList<>();

        String sql = "SELECT * FROM grade_type";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                GradeType gradeType = new GradeType(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("weight"),
                        rs.getString("created_at")
                );
                gradeTypes.add(gradeType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gradeTypes;
    }
}
