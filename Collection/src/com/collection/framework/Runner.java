package com.collection.framework;

import com.collection.framework.fundamentals.CollectionHierarchy;
import com.collection.framework.fundamentals.IteratorVsForLoop;
import com.collection.framework.list.*;
import com.collection.framework.set.*;
import com.collection.framework.queue.*;
import com.collection.framework.map.*;
import com.collection.framework.utils.*;
import com.collection.framework.bestpractices.*;

/**
 * Tüm Java Collection Framework demo sınıflarını sırayla çalıştırır.
 * Her modül kendi içinde başlık ve örnek çıktı üretir.
 */
public class Runner {

    public static void main(String[] args) {
        System.out.println("\n********** JAVA COLLECTION FRAMEWORK - TAM DEMO **********\n");

        run("Temel hiyerarşi & Iterator", () -> CollectionHierarchy.main(args));
        run("Iterator vs for-loop (güvenli silme)", () -> IteratorVsForLoop.main(args));

        run("List arayüzü", () -> ListInterfaceOverview.main(args));
        run("ArrayList detay", () -> ArrayListDeepDive.main(args));
        run("LinkedList detay", () -> LinkedListDeepDive.main(args));
        run("Vector & Stack", () -> VectorAndStack.main(args));

        run("Set arayüzü", () -> SetInterfaceOverview.main(args));
        run("HashSet detay", () -> HashSetDeepDive.main(args));
        run("LinkedHashSet & TreeSet", () -> LinkedHashSetAndTreeSet.main(args));

        run("Queue & Deque", () -> QueueAndDequeOverview.main(args));
        run("PriorityQueue", () -> PriorityQueueDemo.main(args));

        run("Map arayüzü", () -> MapInterfaceOverview.main(args));
        run("HashMap, LinkedHashMap, TreeMap", () -> HashMapLinkedHashMapTreeMap.main(args));

        run("Collections yardımcı", () -> CollectionsUtility.main(args));
        run("Arrays yardımcı", () -> ArraysUtility.main(args));
        run("Karşılaştırma özeti", () -> CollectionComparisonTable.main(args));

        run("Clean code pratikleri", () -> CleanCodePractices.main(args));
        run("equals & hashCode sözleşmesi", () -> EqualsHashCodeContract.main(args));

        System.out.println("\n********** DEMO TAMAMLANDI **********\n");
    }

    private static void run(String name, Runnable r) {
        System.out.println("\n>>> " + name);
        try {
            r.run();
        } catch (Exception e) {
            System.err.println("Hata: " + e.getMessage());
        }
    }
}
