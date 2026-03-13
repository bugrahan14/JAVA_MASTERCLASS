package com.collection.framework.set;

import java.util.*;

/**
 * HASHSET - DETAYLI İNCELEME
 * --------------------------
 * HashMap tabanlı; elemanlar aslında map'in key'leri (value sabit dummy).
 * add/remove/contains: ortalama O(1). Sıra garantisi YOK.
 *
 * Önemli: Elemanlar için hashCode() ve equals() doğru override edilmeli.
 * (Immutable key tercih edilir; değişirse hash bucket yanlış kalır.)
 *
 * Clean code: Kendi sınıflarını Set'te kullanacaksan equals + hashCode tutarlı olmalı.
 */
public class HashSetDeepDive {

    public static void main(String[] args) {
        basicUsage();
        customObjectRequiresHashCodeEquals();
        iterationOrder();
    }

    private static void basicUsage() {
        System.out.println("=== HASHSET TEMEL ===\n");
        Set<Integer> set = new HashSet<>(Set.of(5, 1, 9, 2));
        System.out.println("İçerik (sıra garanti değil): " + set);
        set.add(5); // zaten var, değişiklik yok
        System.out.println("5 tekrar eklendi, boyut: " + set.size());
    }

    private static void customObjectRequiresHashCodeEquals() {
        System.out.println("\n=== ÖZEL SINIF: equals & hashCode ===\n");
        Set<Person> people = new HashSet<>();
        people.add(new Person("Ali", 25));
        people.add(new Person("Ayşe", 30));
        people.add(new Person("Ali", 25)); // aynı sayılmalı
        System.out.println("Kişi sayısı (tekrarsız): " + people.size());
        System.out.println("people: " + people);
    }

    private static void iterationOrder() {
        System.out.println("\n=== GEZİNME SIRASI ===\n");
        Set<String> set = new HashSet<>(List.of("C", "A", "B"));
        System.out.println("HashSet iteration sırası garanti değil:");
        set.forEach(s -> System.out.print(s + " "));
        System.out.println();
    }

    /** equals ve hashCode override edilmiş örnek sınıf */
    static final class Person {
        private final String name;
        private final int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public String toString() {
            return name + "(" + age + ")";
        }
    }
}
