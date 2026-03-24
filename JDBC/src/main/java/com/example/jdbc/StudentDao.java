package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <strong>DAO (Data Access Object)</strong>: veritabanı erişimini tek sınıfta toplar.
 * <p>
 * Clean code ilkeleri:
 * <ul>
 *   <li>SQL sabitleri sınıf seviyesinde, tekrar yok.</li>
 *   <li>Her metot kısa ve tek bir sorgu/iş akışına odaklı.</li>
 *   <li>{@code Optional} ile "bulunamadı" durumu null yerine açık ifade edilir.</li>
 *   <li>İstisnalar üst katmana {@code SQLException} olarak iletilir; burada yutulmaz.</li>
 * </ul>
 */
public final class StudentDao {

    private static final String SQL_SELECT_BY_ID =
            "SELECT id, full_name, email, created_at FROM students WHERE id = ?";
    private static final String SQL_SELECT_ALL =
            "SELECT id, full_name, email, created_at FROM students ORDER BY id";
    private static final String SQL_INSERT =
            "INSERT INTO students (full_name, email) VALUES (?, ?)";
    private static final String SQL_UPDATE =
            "UPDATE students SET full_name = ?, email = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM students WHERE id = ?";

    private final DatabaseConfig config;

    public StudentDao(DatabaseConfig config) {
        this.config = config;
    }

    private Connection openConnection() throws SQLException {
        return DriverManager.getConnection(
                config.getJdbcUrl(), config.getUsername(), config.getPassword());
    }

    /**
     * Anahtara göre tek kayıt; yoksa boş Optional.
     */
    public Optional<Student> findById(long id) throws SQLException {
        try (Connection connection = openConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID)) {
            statement.setLong(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapRow(rs));
                }
            }
        }
        return Optional.empty();
    }

    public List<Student> findAll() throws SQLException {
        List<Student> list = new ArrayList<>();
        try (Connection connection = openConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL);
                ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        }
        return list;
    }

    /**
     * Yeni öğrenci ekler; üretilen id'yi JDBC üzerinden almak için bu örnekte basit tutup
     * tekrar sorgu yapmıyoruz (isterseniz {@code Statement.RETURN_GENERATED_KEYS} ile genişletilir).
     */
    public int save(Student student) throws SQLException {
        try (Connection connection = openConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_INSERT)) {
            statement.setString(1, student.getFullName());
            statement.setString(2, student.getEmail());
            return statement.executeUpdate();
        }
    }

    public int update(Student student) throws SQLException {
        if (student.getId() == null) {
            throw new IllegalArgumentException("Güncelleme için id dolu olmalı.");
        }
        try (Connection connection = openConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_UPDATE)) {
            statement.setString(1, student.getFullName());
            statement.setString(2, student.getEmail());
            statement.setLong(3, student.getId());
            return statement.executeUpdate();
        }
    }

    public int deleteById(long id) throws SQLException {
        try (Connection connection = openConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_DELETE)) {
            statement.setLong(1, id);
            return statement.executeUpdate();
        }
    }

    private static Student mapRow(ResultSet rs) throws SQLException {
        long id = rs.getLong("id");
        String fullName = rs.getString("full_name");
        String email = rs.getString("email");
        String createdAt = rs.getTimestamp("created_at").toString();
        return new Student(id, fullName, email, createdAt);
    }
}
