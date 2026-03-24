package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * <strong>Transaction (işlem)</strong>: birden fazla SQL adımını tek bir atomik birim gibi düşünme.
 * <p>
 * JDBC'de varsayılan olarak {@link Connection#getAutoCommit()} genelde {@code true}: her ifade kendi
 * başına hemen kalıcı olur. Finansal transfer gibi "ya hepsi ya hiç" senaryolarında
 * {@code setAutoCommit(false)} ile manuel {@link Connection#commit()} / {@link Connection#rollback()} kullanılır.
 * <p>
 * InnoDB (MySQL'de yaygın motor) transaction'ları destekler; MyISAM gibi motorlarda davranış farklı olabilir.
 */
public final class TransactionExample {

    private static final String INSERT_STUDENT = "INSERT INTO students (full_name, email) VALUES (?, ?)";

    private TransactionExample() {
    }

    /**
     * İki INSERT aynı transaction içinde commit edilir — ikisi de kalıcı olur veya hata olursa rollback ile geri alınır.
     */
    public static void demonstrateSuccessfulCommit(DatabaseConfig config) throws SQLException {
        try (Connection connection = DriverManager.getConnection(
                config.getJdbcUrl(), config.getUsername(), config.getPassword())) {

            boolean previousAutoCommit = connection.getAutoCommit();
            connection.setAutoCommit(false);
            try {
                insertStudent(connection, "Transaction Kullanıcı 1", "tx.user1@example.com");
                insertStudent(connection, "Transaction Kullanıcı 2", "tx.user2@example.com");
                connection.commit();
                System.out.println("Transaction commit edildi: iki kayıt birlikte kalıcı oldu.");
            } catch (SQLException e) {
                connection.rollback();
                System.out.println("Hata nedeniyle rollback yapıldı: " + e.getMessage());
                throw e;
            } finally {
                connection.setAutoCommit(previousAutoCommit);
            }
        }
    }

    /**
     * İlk INSERT başarılı, ikinci aynı e-posta ile UNIQUE ihlali; rollback ile ilki de geri alınır.
     */
    public static void demonstrateRollbackOnFailure(DatabaseConfig config) throws SQLException {
        final String sharedEmail = "duplicate.tx@example.com";
        try (Connection connection = DriverManager.getConnection(
                config.getJdbcUrl(), config.getUsername(), config.getPassword())) {

            boolean previousAutoCommit = connection.getAutoCommit();
            connection.setAutoCommit(false);
            try {
                insertStudent(connection, "Birinci", sharedEmail);
                insertStudent(connection, "İkinci Aynı Email", sharedEmail);
                connection.commit();
            } catch (SQLIntegrityConstraintViolationException e) {
                connection.rollback();
                System.out.println("Beklenen: UNIQUE kısıtı — rollback ile transaction içindeki tüm değişiklikler geri alındı.");
                System.out.println("  Mesaj: " + e.getMessage());
            } finally {
                connection.setAutoCommit(previousAutoCommit);
            }
        }
    }

    private static void insertStudent(Connection connection, String fullName, String email)
            throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(INSERT_STUDENT)) {
            ps.setString(1, fullName);
            ps.setString(2, email);
            ps.executeUpdate();
        }
    }
}
