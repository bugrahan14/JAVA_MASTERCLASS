package com.collection.framework.fundamentals;

import java.util.*;

/**
 * ITERATOR vs FOR-DÖNGÜSÜ - CLEAN CODE
 * -------------------------------------
 * - Liste üzerinde gezerken eleman SİLİYORSAN: Iterator.remove() kullan.
 *   Aksi halde ConcurrentModificationException riski vardır.
 * - Sadece okuma/gezinme: for-each veya for döngüsü yeterli.
 */
public class IteratorVsForLoop {

    public static void main(String[] args) {
        safeRemovalWithIterator();
        unsafeRemovalWithForLoop();
        alternativeSafeRemoval();
    }

    /** Doğru: Iterator ile güvenli silme */
    private static void safeRemovalWithIterator() {
        System.out.println("=== ITERATOR İLE GÜVENLİ SİLME ===\n");
        List<String> list = new ArrayList<>(List.of("a", "b", "c", "b", "d"));
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if ("b".equals(it.next())) {
                it.remove();
            }
        }
        System.out.println("Sonuç: " + list);
    }

    /**
     * Yanlış: for-each ile silme → ConcurrentModificationException.
     * (Bu metodu çağırmak exception fırlatır; eğitim amaçlı.)
     */
    @SuppressWarnings("unused")
    private static void unsafeRemovalWithForLoop() {
        List<String> list = new ArrayList<>(List.of("a", "b", "c"));
        // for (String s : list) {
        //     if ("b".equals(s)) list.remove(s); // RUNTIME EXCEPTION!
        // }
        System.out.println("\nNot: for-each ile remove() ConcurrentModificationException'a yol açar.\n");
    }

    /** Alternatif: Java 8+ removeIf — en temiz yol */
    private static void alternativeSafeRemoval() {
        System.out.println("=== removeIf İLE GÜVENLİ SİLME (Java 8+) ===\n");
        List<String> list = new ArrayList<>(List.of("a", "b", "c", "b", "d"));
        list.removeIf("b"::equals);
        System.out.println("Sonuç: " + list);
    }
}
