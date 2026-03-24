package com.example.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JDBC'nin en temel adımı: MySQL sunucusuna <strong>bağlantı (Connection)</strong> açmak.
 * <p>
 * <strong>JDBC nedir?</strong> Java uygulamalarının ilişkisel veritabanlarıyla konuşmasını
 * standart bir API ile sağlayan arayüzdür. Gerçek protokol konuşmasını
 * <em>sürücü (driver)</em> yapar; projede bu rolü {@code mysql-connector-j} üstlenir.
 * <p>
 * Eski kodlarda {@code Class.forName("com.mysql.cj.jdbc.Driver")} ile sürücü yükleme
 * görülebilir. Modern JDBC (ServiceLoader) ile sürücü genelde classpath'te olduğu sürece
 * otomatik tanınır; yine de bağlantı URL'sinin {@code jdbc:mysql:...} olması gerekir.
 */
public final class DatabaseConnection {

    private DatabaseConnection() {
        // Yardımcı sınıf — örnek metotlar static
    }

    /**
     * Verilen yapılandırma ile veritabanına bağlanır, meta veriyi okur ve bağlantıyı kapatır.
     * <p>
     * {@code try-with-resources}: {@link Connection} {@link AutoCloseable} olduğu için
     * blok bitince {@code close()} otomatik çağrılır — sızıntı riski azalır (clean code + güvenli kaynak yönetimi).
     *
     * @param config URL, kullanıcı, şifre
     * @throws SQLException JDBC veya ağ/MySQL kaynaklı hata
     */
    public static void demonstrateOpenAndClose(DatabaseConfig config) throws SQLException {
        // DriverManager: sürücü kayıtlıysa URL'ye göre uygun bağlantıyı üretir
        try (Connection connection = DriverManager.getConnection(
                config.getJdbcUrl(), config.getUsername(), config.getPassword())) {

            // Bağlantının geçerli olduğunu ve sunucuyla konuşabildiğimizi teyit ederiz
            if (connection.isClosed()) {
                throw new SQLException("Bağlantı kapalı görünüyor (beklenmeyen durum).");
            }

            // DatabaseMetaData: ürün adı/sürümü gibi bilgiler — öğrenme amaçlı
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println("Bağlantı başarılı.");
            System.out.println("  JDBC sürücüsü: " + metaData.getDriverName() + " " + metaData.getDriverVersion());
            System.out.println("  Veritabanı ürünü: " + metaData.getDatabaseProductName()
                    + " " + metaData.getDatabaseProductVersion());
        }
        // try bloğu bittiğinde connection.close() otomatik çağrıldı
    }
}
