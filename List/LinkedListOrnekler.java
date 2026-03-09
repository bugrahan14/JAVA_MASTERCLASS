import java.util.LinkedList;
import java.util.List;

/**
 * LİNKEDLİST - KAPSAMLI ÖRNEKLER
 * -------------------------------
 * LinkedList: Çift yönlü bağlı liste (her node: önceki + sonraki referans).
 * Hem List hem Deque arayüzünü implemente eder; baş/son ekleme-çıkarma hızlı.
 * Rastgele erişim (get/set index) O(n); ArrayList'te O(1).
 */
public class LinkedListOrnekler {

    public static void main(String[] args) {
        listOlarakKullanım();
        queueVeDequeOrnekleri();
        arrayListVsLinkedList();
    }

    /** List arayüzü olarak: get, set, add, remove — ArrayList ile aynı API */
    public static void listOlarakKullanım() {
        System.out.println("\n=== LİNKEDLİST LİST OLARAK ===\n");

        List<String> list = new LinkedList<>();
        list.add("Bir");
        list.add("İki");
        list.add("Üç");
        System.out.println("Liste: " + list);
        System.out.println("get(1): " + list.get(1));
        list.set(0, "Birinci");
        list.add(1, "Ara"); // indeks 1'e ekle (ortaya ekleme)
        System.out.println("set ve add(1,\"Ara\") sonrası: " + list);
        list.remove(2);
        System.out.println("remove(2) sonrası: " + list);
    }

    /** Queue/Deque: addFirst, addLast, pollFirst, pollLast — FIFO (kuyruk) ve LIFO (yığın) */
    public static void queueVeDequeOrnekleri() {
        System.out.println("\n=== LİNKEDLİST QUEUE / DEQUE ===\n");

        LinkedList<Integer> deque = new LinkedList<>();

        // FIFO (First In First Out) - Kuyruk: sona ekle, baştan al
        deque.addLast(10);
        deque.addLast(20);
        deque.addLast(30);
        System.out.println("FIFO eklenen: 10, 20, 30");
        System.out.println("pollFirst (kuyruktan çık): " + deque.pollFirst());
        System.out.println("pollFirst: " + deque.pollFirst());
        System.out.println("Kalan: " + deque);

        // LIFO (Last In First Out) - Yığın: başa ekle, baştan al (veya sona ekle sondan al)
        deque.clear();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        System.out.println("\nLIFO (stack): addFirst 1,2,3 -> " + deque);
        System.out.println("pollFirst (üstten al): " + deque.pollFirst());
        System.out.println("pollFirst: " + deque.pollFirst());
    }

    /** ArrayList vs LinkedList: erişim O(1) vs O(n); baş/orta ekleme-silme; ne zaman hangisi */
    public static void arrayListVsLinkedList() {
        System.out.println("\n=== ARRAYLİST vs LİNKEDLİST ===\n");

        System.out.println("ArrayList:");
        System.out.println("  - İndeksle erişim (get/set): O(1)");
        System.out.println("  - Sona ekleme: O(1) amortized");
        System.out.println("  - Başa/ortaya ekleme-silme: O(n) (kaydırma)");
        System.out.println("  - Bellek: tek blok array, daha az overhead");
        System.out.println();
        System.out.println("LinkedList:");
        System.out.println("  - İndeksle erişim: O(n) (baştan/sondan traverse)");
        System.out.println("  - Başa/sona ekleme-çıkarma: O(1)");
        System.out.println("  - Ortaya ekleme: O(n) (konuma gitmek) + O(1) ekleme");
        System.out.println("  - Bellek: her eleman için node (prev, next, value)");
        System.out.println();
        System.out.println("Ne zaman LinkedList: Sık baş/son ekleme-çıkarma, kuyruk/yığın (Queue/Deque).");
        System.out.println("Ne zaman ArrayList: Rastgele erişim, çoğunlukla okuma, genel amaçlı liste.");
    }
}
