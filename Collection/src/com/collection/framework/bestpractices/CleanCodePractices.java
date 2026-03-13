package com.collection.framework.bestpractices;

import java.util.*;

/**
 * COLLECTION FRAMEWORK - CLEAN CODE PRATİKLERİ
 * --------------------------------------------
 * 1. Program to interface: List/Set/Map kullan, ArrayList/HashSet doğrudan değişken tipi yapma.
 * 2. Kapasite: Tahmin edilebiliyorsa ArrayList/ HashMap constructor'da initial capacity ver.
 * 3. Immutable: Değişmeyecek listeler için List.of(), Set.of(), Map.of() (Java 9+).
 * 4. Silme: Döngüde silme yapıyorsan Iterator.remove() veya removeIf(); for-each ile remove çağırma.
 * 5. Null: TreeSet/TreeMap ve PriorityQueue null kabul etmez; dikkat et.
 * 6. equals/hashCode: Set/Map key'lerinde kullanılan sınıflar için tutarlı override.
 * 7. Stack: Vector/Stack yerine Deque (ArrayDeque) kullan.
 */
public class CleanCodePractices {

    public static void main(String[] args) {
        programToInterface();
        useImmutableWhenPossible();
        safeRemoval();
        meaningfulNamesAndSmallMethods();
    }

    /** Değişken tipi arayüz olsun; implementasyon sadece sağ tarafta */
    private static void programToInterface() {
        System.out.println("=== PROGRAM TO INTERFACE ===\n");
        List<String> list = new ArrayList<>();   // doğru
        Set<Integer> set = new HashSet<>();      // doğru
        Map<String, Integer> map = new HashMap<>(); // doğru
        // ArrayList<String> list = new ArrayList<>(); // kaçının (implementasyona bağımlılık)
        list.add("örnek");
        set.add(1);
        map.put("a", 1);
        System.out.println("list=" + list + ", set=" + set + ", map=" + map);
    }

    /** Değişmeyecek veri: List.of, Set.of, Map.of */
    private static void useImmutableWhenPossible() {
        System.out.println("\n=== IMMUTABLE KOLEKSİYONLAR ===\n");
        List<String> fixed = List.of("A", "B", "C");
        Set<Integer> fixedSet = Set.of(1, 2, 3);
        Map<String, Integer> fixedMap = Map.of("x", 1, "y", 2);
        System.out.println("Sabit veri için List.of/Set.of/Map.of kullanın.");
    }

    /** Güvenli silme: removeIf veya Iterator.remove */
    private static void safeRemoval() {
        System.out.println("\n=== GÜVENLİ SİLME ===\n");
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        list.removeIf(n -> n % 2 == 0);
        System.out.println("removeIf(çift): " + list);
    }

    /** Anlamlı isimler ve küçük metodlar: koleksiyon döndüren metodlar boş koleksiyon dönsün, null değil */
    private static void meaningfulNamesAndSmallMethods() {
        System.out.println("\n=== ANLAMLI İSİMLER & BOŞ KOLEKSİYON ===\n");
        List<String> activeUsers = getActiveUserNames();
        if (activeUsers.isEmpty()) {
            System.out.println("Aktif kullanıcı yok.");
        } else {
            System.out.println("Aktif kullanıcı sayısı: " + activeUsers.size());
        }
    }

    /** Boş liste döndür; null döndürme (NullPointerException riski) */
    private static List<String> getActiveUserNames() {
        // Veri yoksa Collections.emptyList() veya List.of() dönebilir
        return new ArrayList<>(); // veya List.of()
    }
}
