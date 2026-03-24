package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * <strong>Statement</strong> ile <strong>PreparedStatement</strong> farkı ve SQL enjeksiyonu konusu.
 * <p>
 * <ul>
 *   <li>{@link java.sql.Statement}: SQL metni doğrudan birleştirilirse kullanıcı girdisi ile
 *       komut enjekte edilebilir (güvensiz desen).</li>
 *   <li>{@link java.sql.PreparedStatement}: SQL şablonu bir kez verilir; değerler
 *       {@code setString}, {@code setLong} vb. ile <em>parametre</em> olarak bağlanır.
 *       Sürücü bunları kaçışlar; enjeksiyon riski büyük ölçüde kalkar (clean code: her zaman tercih edin).</li>
 * </ul>
 */
public final class PreparedStatementExample {

    private static final String INSERT_STUDENT_SQL =
            "INSERT INTO students (full_name, email) VALUES (?, ?)";

    private PreparedStatementExample() {
    }

    /**
     * Parametreli INSERT örneği: isim ve e-posta güvenli şekilde bağlanır.
     *
     * @param fullName kullanıcıdan gelen ad (örnek senaryo — gerçekte doğrulama da gerekir)
     * @param email    e-posta
     * @return eklenen satır sayısı (INSERT için genelde 1)
     */
    public static int insertStudent(DatabaseConfig config, String fullName, String email)
            throws SQLException {
        try (Connection connection = DriverManager.getConnection(
                config.getJdbcUrl(), config.getUsername(), config.getPassword());
                PreparedStatement statement = connection.prepareStatement(INSERT_STUDENT_SQL)) {

            // Parametre indeksleri 1'den başlar (SQL standardı JDBC'de böyle)
            statement.setString(1, fullName);
            statement.setString(2, email);

            // executeUpdate: INSERT, UPDATE, DELETE için; etkilenen satır sayısını döner
            return statement.executeUpdate();
        }
    }

    /**
     * KÖTÜ ÖRNEK (bilerek gösterilmiyor): {@code "SELECT * FROM students WHERE email = '" + email + "'"}
     * — email içinde {@code ' OR '1'='1} gibi bir metin komutu bozup güvenlik açığı yaratır.
     * PreparedStatement ile {@code WHERE email = ?} ve {@code setString(1, email)} kullanın.
     */
    public static void printSecurityNote() {
        System.out.println("SQL birleştirme ile sorgu kurmayın; her zaman PreparedStatement + ? parametreleri kullanın.");
    }
}
