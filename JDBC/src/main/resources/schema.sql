-- Örnek veritabanı ve tablo: JDBC öğrenme projesi
-- Kullanım: mysql -u root -p < src/main/resources/schema.sql
-- veya MySQL Workbench / istemci üzerinden bu dosyayı çalıştırın

CREATE DATABASE IF NOT EXISTS jdbc_learning
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE jdbc_learning;

-- Öğrenci kayıtları: DAO ve CRUD örnekleri için basit model
DROP TABLE IF EXISTS students;

CREATE TABLE students (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(120) NOT NULL,
    email VARCHAR(160) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UNIQUE KEY uk_students_email (email)
) ENGINE=InnoDB;

INSERT INTO students (full_name, email) VALUES
    ('Ayşe Yılmaz', 'ayse.yilmaz@example.com'),
    ('Mehmet Kaya', 'mehmet.kaya@example.com'),
    ('Zeynep Demir', 'zeynep.demir@example.com');
