package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <strong>ResultSet</strong>: SELECT sorgusunun satır sonuçlarını satır satır okuduğumuz nesne.
 * <p>
 * Önemli noktalar:
 * <ul>
 *   <li>İmleç (cursor) başlangıçta genelde ilk satırın <em>önündedir</em>; okumak için
 *       {@code next()} ile ilerlenir.</li>
 *   <li>Kolonlara indeks (1 tabanlı) veya isimle erişilir: {@code getLong("id")}, {@code getString(2)}.</li>
 *   <li>ResultSet de kapatılmalıdır; try-with-resources ile PreparedStatement ile birlikte
 *       veya ayrı kaynak olarak yönetilir.</li>
 * </ul>
 */
public final class ResultSetExample {

    private static final String SELECT_ALL_STUDENTS =
            "SELECT id, full_name, email, created_at FROM students ORDER BY id";

    private ResultSetExample() {
    }

    /**
     * Tüm öğrencileri okuyup basit veri transfer nesnelerine doldurur.
     * Clean code: JDBC detayı bu sınıfta kalır; dönüş tipi domain listesi.
     */
    public static List<Student> fetchAllStudents(DatabaseConfig config) throws SQLException {
        List<Student> students = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(
                config.getJdbcUrl(), config.getUsername(), config.getPassword());
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL_STUDENTS);
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String fullName = resultSet.getString("full_name");
                String email = resultSet.getString("email");
                // TIMESTAMP -> java.sql.Timestamp; burada anlık gösterim için toString yeterli
                String createdAt = resultSet.getTimestamp("created_at").toString();
                students.add(new Student(id, fullName, email, createdAt));
            }
        }
        return students;
    }

    /**
     * Konsola özet yazdırır (öğrenme çıktısı).
     */
    public static void printAllStudents(DatabaseConfig config) throws SQLException {
        List<Student> list = fetchAllStudents(config);
        System.out.println("Toplam öğrenci: " + list.size());
        for (Student s : list) {
            System.out.println("  " + s);
        }
    }
}
