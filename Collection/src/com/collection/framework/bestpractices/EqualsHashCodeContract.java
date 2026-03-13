package com.collection.framework.bestpractices;

import java.util.*;

/**
 * EQUALS & HASHCODE SÖZLEŞMESİ
 * -----------------------------
 * Set ve Map (HashMap, HashSet) key/eleman eşitliği için hashCode() ve equals() kullanır.
 *
 * Sözleşme:
 * - equals(a,b) true ise hashCode(a) == hashCode(b) olmalı.
 * - hashCode aynı olan iki eleman equals olmak zorunda değil (collision).
 * - equals tutarlı olmalı (reflexive, symmetric, transitive, consistent, null false).
 *
 * Clean code: Key veya Set elemanı olacak sınıflarda her ikisini de override edin;
 * IDE veya Objects.hash/Objects.equals kullanın. Immutable alanlardan hashCode hesaplayın.
 */
public class EqualsHashCodeContract {

    public static void main(String[] args) {
        withoutOverrideProblem();
        withOverrideCorrect();
    }

    /** equals/hashCode override edilmeyen sınıf: Set/Map'te aynı içerik farklı kabul edilir */
    private static void withoutOverrideProblem() {
        System.out.println("=== OVERRIDE OLMADAN (SORUNLU) ===\n");
        Set<BadPoint> set = new HashSet<>();
        set.add(new BadPoint(1, 2));
        set.add(new BadPoint(1, 2)); // aynı koordinat ama farklı instance
        System.out.println("BadPoint (equals/hashCode yok) set size: " + set.size()); // 2!
    }

    /** Doğru: equals ve hashCode override */
    private static void withOverrideCorrect() {
        System.out.println("\n=== OVERRIDE İLE (DOĞRU) ===\n");
        Set<GoodPoint> set = new HashSet<>();
        set.add(new GoodPoint(1, 2));
        set.add(new GoodPoint(1, 2));
        System.out.println("GoodPoint (equals/hashCode var) set size: " + set.size()); // 1
    }

    static class BadPoint {
        final int x, y;
        BadPoint(int x, int y) { this.x = x; this.y = y; }
    }

    static class GoodPoint {
        private final int x, y;
        GoodPoint(int x, int y) { this.x = x; this.y = y; }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GoodPoint that = (GoodPoint) o;
            return x == that.x && y == that.y;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
