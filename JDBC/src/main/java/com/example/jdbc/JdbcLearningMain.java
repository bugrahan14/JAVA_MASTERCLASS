package com.example.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Örnekleri sırayla çalıştırmak için giriş noktası.
 * <p>
 * Maven: {@code mvn -q compile exec:java}
 * <p>
 * Önce {@code schema.sql} ile veritabanını oluşturun ve {@code JDBC_MYSQL_PASSWORD} ortam değişkenini ayarlayın.
 */
public final class JdbcLearningMain {

    private JdbcLearningMain() {
    }

    public static void main(String[] args) {
        System.out.println("=== JDBC + MySQL Öğrenme Örnekleri ===\n");

        final DatabaseConfig config;
        try {
            config = DatabaseConfig.loadFromClasspath();
        } catch (IllegalStateException e) {
            System.err.println("Yapılandırma hatası: " + e.getMessage());
            return;
        }

        try (Scanner scanner = new Scanner(System.in, java.nio.charset.StandardCharsets.UTF_8)) {
            while (true) {
                printMenu();
                System.out.print("Seçiminiz (0 çıkış): ");
                String line = scanner.nextLine().trim();
                if ("0".equals(line)) {
                    System.out.println("Güle güle.");
                    return;
                }
                try {
                    runChoice(line, config, scanner);
                } catch (SQLException e) {
                    System.err.println("SQL/JDBC hatası: " + e.getMessage());
                    e.printStackTrace(System.err);
                }
                System.out.println();
            }
        }
    }

    private static void printMenu() {
        System.out.println("1 — Bağlantı aç/kapat (Connection, meta veri)");
        System.out.println("2 — PreparedStatement ile INSERT (+ SQL enjeksiyonu notu)");
        System.out.println("3 — ResultSet ile tüm öğrencileri listele");
        System.out.println("4 — Transaction: başarılı commit");
        System.out.println("5 — Transaction: hata sonrası rollback (UNIQUE ihlali)");
        System.out.println("6 — DAO: findById, findAll, save, update, delete (etkileşimli)");
        System.out.println("0 — Çıkış");
    }

    private static void runChoice(String choice, DatabaseConfig config, Scanner scanner)
            throws SQLException {
        switch (choice) {
            case "1" -> DatabaseConnection.demonstrateOpenAndClose(config);
            case "2" -> {
                PreparedStatementExample.printSecurityNote();
                System.out.print("Ad soyad: ");
                String name = scanner.nextLine().trim();
                System.out.print("E-posta: ");
                String email = scanner.nextLine().trim();
                int rows = PreparedStatementExample.insertStudent(config, name, email);
                System.out.println("Eklenen satır: " + rows);
            }
            case "3" -> ResultSetExample.printAllStudents(config);
            case "4" -> TransactionExample.demonstrateSuccessfulCommit(config);
            case "5" -> TransactionExample.demonstrateRollbackOnFailure(config);
            case "6" -> runDaoDemo(config, scanner);
            default -> System.out.println("Geçersiz seçim.");
        }
    }

    private static void runDaoDemo(DatabaseConfig config, Scanner scanner) throws SQLException {
        StudentDao dao = new StudentDao(config);
        System.out.println("DAO alt menü: a=liste, b=id ile bul, c=kaydet, d=güncelle, e=sil");
        System.out.print("Alt komut: ");
        String cmd = scanner.nextLine().trim().toLowerCase();
        switch (cmd) {
            case "a" -> {
                for (Student s : dao.findAll()) {
                    System.out.println(s);
                }
            }
            case "b" -> {
                System.out.print("id: ");
                long id = Long.parseLong(scanner.nextLine().trim());
                dao.findById(id).ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Kayıt yok."));
            }
            case "c" -> {
                System.out.print("Ad soyad: ");
                String name = scanner.nextLine().trim();
                System.out.print("E-posta: ");
                String email = scanner.nextLine().trim();
                int n = dao.save(new Student(name, email));
                System.out.println("save etkilenen satır: " + n);
            }
            case "d" -> {
                System.out.print("id: ");
                long id = Long.parseLong(scanner.nextLine().trim());
                optionalStudentUpdate(scanner, dao, id);
            }
            case "e" -> {
                System.out.print("Silinecek id: ");
                long id = Long.parseLong(scanner.nextLine().trim());
                int n = dao.deleteById(id);
                System.out.println("delete etkilenen satır: " + n);
            }
            default -> System.out.println("Bilinmeyen alt komut.");
        }
    }

    private static void optionalStudentUpdate(Scanner scanner, StudentDao dao, long id)
            throws SQLException {
        var existing = dao.findById(id);
        if (existing.isEmpty()) {
            System.out.println("Kayıt yok.");
            return;
        }
        Student current = existing.get();
        System.out.println("Mevcut: " + current);
        System.out.print("Yeni ad (boş bırakırsanız eski kalır): ");
        String name = scanner.nextLine().trim();
        System.out.print("Yeni e-posta (boş bırakırsanız eski kalır): ");
        String email = scanner.nextLine().trim();
        String newName = name.isEmpty() ? current.getFullName() : name;
        String newEmail = email.isEmpty() ? current.getEmail() : email;
        int n = dao.update(new Student(id, newName, newEmail, current.getCreatedAt()));
        System.out.println("update etkilenen satır: " + n);
    }
}
