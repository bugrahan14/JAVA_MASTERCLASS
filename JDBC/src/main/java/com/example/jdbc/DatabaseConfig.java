package com.example.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

/**
 * Veritabanı bağlantı bilgilerini classpath üzerindeki {@code application.properties}
 * dosyasından ve şifre için ortam değişkeninden okur.
 * <p>
 * Clean code: yapılandırma tek yerde toplanır; kod içinde URL/kullanıcı dağılmaz.
 * Güvenlik: şifre dosyada tutulmaz; böylece depoya yanlışlıkla commit edilme riski azalır.
 */
public final class DatabaseConfig {

    /**
     * Ortam değişkeni adı — şifreyi buradan okuyoruz (üretim ve geliştirme için aynı desen).
     */
    public static final String PASSWORD_ENV_VAR = "JDBC_MYSQL_PASSWORD";

    private static final String PROPERTIES_RESOURCE = "/application.properties";

    private final String jdbcUrl;
    private final String username;
    private final String password;

    private DatabaseConfig(String jdbcUrl, String username, String password) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
    }

    /**
     * Classpath'teki {@code application.properties} dosyasını yükleyerek yapılandırma oluşturur.
     *
     * @throws IllegalStateException dosya bulunamaz, okunamaz veya zorunlu anahtarlar eksikse
     */
    public static DatabaseConfig loadFromClasspath() {
        Properties properties = new Properties();
        try (InputStream input = DatabaseConfig.class.getResourceAsStream(PROPERTIES_RESOURCE)) {
            if (input == null) {
                throw new IllegalStateException(
                        "Classpath'te bulunamadı: " + PROPERTIES_RESOURCE
                                + " — dosyanın src/main/resources altında olduğundan emin olun.");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new IllegalStateException("Yapılandırma dosyası okunamadı: " + PROPERTIES_RESOURCE, e);
        }

        String url = requireProperty(properties, "jdbc.url");
        String user = requireProperty(properties, "jdbc.username");
        String password = System.getenv(PASSWORD_ENV_VAR);
        if (password == null || password.isBlank()) {
            throw new IllegalStateException(
                    "Şifre tanımlı değil. Ortam değişkeni ayarlayın: " + PASSWORD_ENV_VAR);
        }

        return new DatabaseConfig(url, user, password);
    }

    private static String requireProperty(Properties properties, String key) {
        String value = properties.getProperty(key);
        if (value == null || value.isBlank()) {
            throw new IllegalStateException("Eksik veya boş yapılandırma anahtarı: " + key);
        }
        return value.trim();
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        // Şifreyi asla loglamayın — burada sadece URL ve kullanıcı (öğretim amaçlı kısa özet)
        return "DatabaseConfig{jdbcUrl='" + jdbcUrl + "', username='" + username + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DatabaseConfig that)) {
            return false;
        }
        return Objects.equals(jdbcUrl, that.jdbcUrl)
                && Objects.equals(username, that.username)
                && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jdbcUrl, username, password);
    }
}
