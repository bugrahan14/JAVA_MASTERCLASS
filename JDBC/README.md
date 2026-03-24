# JDBC ve MySQL — Temelden Öğrenme Projesi

Bu depo, **Java JDBC** (Java Database Connectivity) ile **MySQL** veritabanına bağlanmayı, sorgu çalıştırmayı ve sonuç okumayı **adım adım** gösteren küçük bir Maven projesidir. Kaynak kodda **Türkçe açıklayıcı yorumlar** ve **temiz kod** alışkanlıkları (anlamlı isimler, `try-with-resources`, `PreparedStatement`, DAO ayrımı) kullanılmıştır.

## JDBC ve MySQL ilişkisi

- **JDBC**: Java’nın standart veritabanı API’sidir; uygulamanız `java.sql` paketi üzerinden bağlantı ve sorgu işlemlerini yapar.
- **MySQL**: Verilerin durduğu sunucu ve motor (ör. InnoDB).
- **Sürücü (driver)**: Projede `mysql-connector-j` bağımlılığı, JDBC ile MySQL protokolü arasında köprü kurar.

Uygulama → JDBC API → MySQL sürücüsü → MySQL sunucusu.

## Önkoşullar

- **JDK 17** veya üzeri
- **Apache Maven** (PATH’te `mvn` komutu)
- Çalışan bir **MySQL 8** sunucusu (yerel veya uzak)

İsteğe bağlı — MySQL’i Docker ile:

```bash
docker run --name mysql-jdbc -e MYSQL_ROOT_PASSWORD=secret -e MYSQL_DATABASE=jdbc_learning -p 3306:3306 -d mysql:8
```

## Veritabanını hazırlama

1. MySQL’e yönetici veya yetkili kullanıcı ile bağlanın.
2. Projedeki şema dosyasını çalıştırın:

   ```bash
   mysql -u root -p < src/main/resources/schema.sql
   ```

   Windows’ta dosya yolunu kendi proje dizininize göre düzenleyin; alternatif olarak içeriği MySQL Workbench veya başka bir istemciden yapıştırıp çalıştırın.

3. `jdbc_learning` veritabanı ve `students` tablosu oluşur; birkaç örnek satır eklenir.

## Yapılandırma ve güvenlik

1. [`src/main/resources/application.properties`](src/main/resources/application.properties) içinde **`jdbc.url`** ve **`jdbc.username`** değerlerini kendi ortamınıza göre düzenleyin.
2. **Şifreyi dosyaya yazmayın.** Ortam değişkeni **`JDBC_MYSQL_PASSWORD`** ile verin.

   **PowerShell:**

   ```powershell
   $env:JDBC_MYSQL_PASSWORD = "sifreniz"
   ```

   **Linux / macOS:**

   ```bash
   export JDBC_MYSQL_PASSWORD=sifreniz
   ```

Üretimde şifreler için gizli yönetimi (Vault, Kubernetes Secret vb.) kullanın; öğrenme projesinde ortam değişkeni yeterlidir.

## Derleme ve çalıştırma

Proje kökünde:

```bash
mvn -q compile exec:java
```

Menüden 1–6 arası seçeneklerle örnekleri çalıştırabilirsiniz; **0** çıkıştır.

IDE kullanıyorsanız ana sınıf: `com.example.jdbc.JdbcLearningMain`.

## Proje yapısı ve sınıf haritası

| Dosya | Ne öğretir? |
|--------|-------------|
| [`DatabaseConfig.java`](src/main/java/com/example/jdbc/DatabaseConfig.java) | Properties + ortam değişkeninden yapılandırma; şifreyi koda gömmeme |
| [`DatabaseConnection.java`](src/main/java/com/example/jdbc/DatabaseConnection.java) | `DriverManager.getConnection`, `Connection`, `DatabaseMetaData`, `try-with-resources` |
| [`PreparedStatementExample.java`](src/main/java/com/example/jdbc/PreparedStatementExample.java) | Parametreli INSERT; `Statement` ile string birleştirmenin SQL enjeksiyonu riski |
| [`ResultSetExample.java`](src/main/java/com/example/jdbc/ResultSetExample.java) | `executeQuery`, `ResultSet`, `next()`, kolon okuma |
| [`TransactionExample.java`](src/main/java/com/example/jdbc/TransactionExample.java) | `setAutoCommit(false)`, `commit`, `rollback` |
| [`Student.java`](src/main/java/com/example/jdbc/Student.java) | Basit domain modeli (POJO); JDBC’den bağımsız |
| [`StudentDao.java`](src/main/java/com/example/jdbc/StudentDao.java) | DAO deseni; CRUD ve `Optional` ile okunabilirlik |
| [`JdbcLearningMain.java`](src/main/java/com/example/jdbc/JdbcLearningMain.java) | Etkileşimli menü ve tüm örnekleri bir arada çalıştırma |
| [`schema.sql`](src/main/resources/schema.sql) | Örnek veritabanı ve tablo tanımı |

## Önemli güvenlik ve kalite notları

- Sorgularda kullanıcı girdisini **asla** SQL metnine doğrudan eklemeyin; **`PreparedStatement`** ve `?` parametreleri kullanın.
- `Connection`, `PreparedStatement`, `ResultSet` kaynaklarını **`try-with-resources`** ile kapatın.
- Gerçek uygulamalarda tekrar tekrar `DriverManager` ile bağlantı açmak yerine **bağlantı havuzu** (ör. HikariCP) tercih edilir.
- Kalıcı nesne-ilişki eşlemesi için bir sonraki adım **JPA / Hibernate** olabilir; JDBC altyapıyı anlamak bu araçları doğru kullanmanıza yardım eder.

## Sorun giderme

- **`Communications link failure`**: MySQL çalışıyor mu, `jdbc.url` içindeki host/port doğru mu kontrol edin.
- **`Access denied`**: Kullanıcı adı/şifre ve `JDBC_MYSQL_PASSWORD` doğru mu; kullanıcının `jdbc_learning` veritabanına yetkisi var mı?
- **`Unknown database`**: `schema.sql` çalıştırıldı mı?
- **`The server time zone` uyarıları**: URL’de `serverTimezone=UTC` (veya bölgenize uygun değer) kullanın; örnek properties dosyasında tanımlıdır.

## Lisans ve amaç

Eğitim amaçlı örnek kod; üretim kullanımı için hata yönetimi, loglama, doğrulama ve havuzlama eklemeniz gerekir.
