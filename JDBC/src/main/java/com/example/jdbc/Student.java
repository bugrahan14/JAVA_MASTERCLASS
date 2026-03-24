package com.example.jdbc;

import java.util.Objects;

/**
 * {@code students} tablosunun Java tarafındaki karşılığı (basit domain modeli / POJO).
 * <p>
 * Clean code: veritabanı kolonları ile anlamlı alan isimleri eşleşir ({@code full_name} → {@code fullName}).
 * Bu sınıf JDBC detayı içermez; sadece veri taşır (katmanların ayrılması).
 */
public final class Student {

    /**
     * Veritabanında henüz yoksa (yeni kayıt) null olabilir.
     */
    private final Long id;
    private final String fullName;
    private final String email;
    /**
     * Okuma sırasında gösterim için; yeni kayıtta genelde null.
     */
    private final String createdAt;

    /**
     * SELECT sonucundan oluşturma (tam satır).
     */
    public Student(long id, String fullName, String email, String createdAt) {
        this.id = id;
        this.fullName = Objects.requireNonNull(fullName, "fullName");
        this.email = Objects.requireNonNull(email, "email");
        this.createdAt = createdAt;
    }

    /**
     * INSERT öncesi: id ve created_at sunucu tarafından üretilir.
     */
    public Student(String fullName, String email) {
        this.id = null;
        this.fullName = Objects.requireNonNull(fullName, "fullName");
        this.email = Objects.requireNonNull(email, "email");
        this.createdAt = null;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", fullName='" + fullName + "', email='" + email
                + "', createdAt='" + createdAt + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student student)) {
            return false;
        }
        return Objects.equals(id, student.id)
                && Objects.equals(fullName, student.fullName)
                && Objects.equals(email, student.email)
                && Objects.equals(createdAt, student.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, email, createdAt);
    }
}
