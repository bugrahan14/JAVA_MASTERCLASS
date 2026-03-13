# Java Collection Framework — Temelden Detaylı Rehber

Bu proje, **Java Collection Framework** konusunu en temelden alarak, detaylı ve eksiksiz biçimde, **clean code** prensipleriyle anlatan örnekleri içerir.

---

## İçindekiler

1. [Temel Hiyerarşi](#1-temel-hiyerarşi)
2. [List](#2-list)
3. [Set](#3-set)
4. [Queue ve Deque](#4-queue-ve-deque)
5. [Map](#5-map)
6. [Yardımcı Sınıflar](#6-yardımcı-sınıflar)
7. [Clean Code Pratikleri](#7-clean-code-pratikleri)
8. [Karşılaştırma Özeti](#8-karşılaştırma-özeti)

---

## 1. Temel Hiyerarşi

- **Iterable&lt;T&gt;**  
  Tüm koleksiyonların kökü. `for-each` ve `iterator()` sağlar.

- **Collection&lt;E&gt;**  
  Ortak sözleşme: `add`, `remove`, `contains`, `size`, `isEmpty`, `clear`, `toArray`.

- **Alt arayüzler:**
  - **List&lt;E&gt;** — Sıralı, indeksli, tekrara izin verir.
  - **Set&lt;E&gt;** — Tekrarsız (unique) elemanlar.
  - **Queue&lt;E&gt;** — Kuyruk (FIFO / öncelik).

- **Map&lt;K,V&gt;**  
  Collection'dan türemez; ayrı hiyerarşi. Key–value çiftleri.

**Clean code:** Değişken tipini arayüz (List, Set, Map) yap; implementasyonu (ArrayList, HashSet, HashMap) sadece sağ tarafta seç.

---

## 2. List

| Yapı         | Açıklama | get/set | add (sonda) | add(i)/remove(i) | Ne zaman? |
|-------------|----------|---------|-------------|-------------------|-----------|
| **ArrayList**  | Dinamik dizi | O(1) | O(1)* | O(n) | Random access sık; varsayılan tercih. |
| **LinkedList** | Çift yönlü bağlı liste | O(n) | O(1) | O(n) | Başta/sonda sık ekleme-çıkarma; queue/stack. |
| **Vector**     | Eski, senkron | O(1) | O(1)* | O(n) | Yeni kodda ArrayList + senkron wrapper tercih edilir. |

- **List** metodları: `add(e)`, `add(index, e)`, `get(i)`, `set(i, e)`, `remove(i)`, `remove(Object)`, `indexOf`, `lastIndexOf`, `subList`, `listIterator`.
- **subList(from, to)** orijinal listeye “bağlı”; sub üzerinde yapılan değişiklik orijinali etkiler.
- Döngüde **silme** yapıyorsan `Iterator.remove()` veya `list.removeIf(...)` kullan; for-each ile `remove` çağırma (ConcurrentModificationException riski).

---

## 3. Set

| Yapı            | Sıra        | Tekrar | null  | Karmaşıklık |
|-----------------|------------|--------|-------|-------------|
| **HashSet**       | Yok        | Yok    | 1 key | O(1)*       |
| **LinkedHashSet**| Ekleme sırası | Yok | 1 key | O(1)*       |
| **TreeSet**      | Sıralı     | Yok    | Yok   | O(log n)    |

- Set’te **equals** ve **hashCode** (HashSet/LinkedHashSet için) tutarlı olmalı.
- TreeSet için **Comparable** veya **Comparator** gerekir; null kabul edilmez.

---

## 4. Queue ve Deque

- **Queue:** `offer`/`add`, `poll`/`remove`, `peek`/`element`. Başarısızda offer=false, poll/peek=null; add/remove/element exception.
- **Deque:** Çift uçlu; `offerFirst`/`offerLast`, `pollFirst`/`pollLast`, `peekFirst`/`peekLast`. Stack: `push` = addFirst, `pop` = pollFirst.
- **ArrayDeque:** Stack ve FIFO kuyruk için önerilen (LinkedList’ten genelde daha verimli).
- **PriorityQueue:** Öncelik kuyruğu (heap); offer/poll/peek O(log n). Comparable veya Comparator.

---

## 5. Map

| Yapı            | Sıra   | null key | Karmaşıklık |
|-----------------|--------|----------|-------------|
| **HashMap**       | Yok   | 1 tane   | O(1)*       |
| **LinkedHashMap**| Ekleme/erişim | 1 | O(1)*       |
| **TreeMap**      | Key’e göre sıralı | Yok | O(log n) |

- **put**, **get**, **remove**, **containsKey**, **getOrDefault**, **putIfAbsent**.
- Görünümler: **keySet()**, **values()**, **entrySet()**.

---

## 6. Yardımcı Sınıflar

- **java.util.Collections:** `sort`, `reverse`, `shuffle`, `binarySearch`, `min`, `max`, `frequency`, `unmodifiableList`, `synchronizedList`, `rotate`, `swap`, `fill` vb.
- **java.util.Arrays:** `sort`, `binarySearch`, `copyOf`, `copyOfRange`, `fill`, `asList`, `toString`.
- **List.of / Set.of / Map.of (Java 9+):** Immutable, null’sız; sabit veri için tercih edin.

---

## 7. Clean Code Pratikleri

1. **Program to interface:** Değişken tipi `List`, `Set`, `Map`, `Queue`, `Deque` olsun.
2. **Kapasite:** Tahmin edilebiliyorsa `new ArrayList<>(capacity)` veya `new HashMap<>(capacity)` kullanın.
3. **Immutable:** Değişmeyecek veri için `List.of()`, `Set.of()`, `Map.of()`.
4. **Silme:** Döngüde silme için `Iterator.remove()` veya `removeIf(...)`; for-each ile `remove` kullanmayın.
5. **Null:** TreeSet, TreeMap, PriorityQueue null kabul etmez; buna göre tasarlayın.
6. **equals/hashCode:** Set/Map’te kullanılan key/eleman sınıflarında ikisini de tutarlı override edin.
7. **Stack:** Eski `Stack` yerine `Deque` (ör. `ArrayDeque`) kullanın.
8. **Boş dönüş:** Koleksiyon döndüren metodlar null yerine boş koleksiyon (`Collections.emptyList()`, `List.of()`) dönsün.

---

## 8. Karşılaştırma Özeti

- **List:** Sıralı, indeksli, tekrarlı → **ArrayList** (varsayılan), **LinkedList**, **Vector**.
- **Set:** Tekrarsız → **HashSet**, **LinkedHashSet**, **TreeSet**.
- **Queue/Deque:** **ArrayDeque** (stack + FIFO), **LinkedList**, **PriorityQueue** (öncelik).
- **Map:** **HashMap**, **LinkedHashMap**, **TreeMap**.

---

## Proje Yapısı ve Çalıştırma

```
Collection/
├── README.md
└── src/com/collection/framework/
    ├── Runner.java                    ← Tüm demoları sırayla çalıştırır
    ├── fundamentals/                  ← Iterable, Collection, Iterator
    ├── list/                          ← List, ArrayList, LinkedList, Vector
    ├── set/                           ← Set, HashSet, LinkedHashSet, TreeSet
    ├── queue/                         ← Queue, Deque, PriorityQueue, ArrayDeque
    ├── map/                           ← Map, HashMap, LinkedHashMap, TreeMap
    ├── utils/                         ← Collections, Arrays, karşılaştırma
    └── bestpractices/                 ← Clean code, equals/hashCode
```

**Derleme ve çalıştırma (kök dizin `Collection`):**

```bash
javac -d out src/com/collection/framework/**/*.java src/com/collection/framework/*.java
java -cp out com.collection.framework.Runner
```

Windows (PowerShell) için paketleri tek tek vermek gerekebilir; alternatif olarak tüm `.java` dosyalarını tek seferde derleyebilirsiniz:

```bash
javac -d out -sourcepath src src/com/collection/framework/Runner.java
java -cp out com.collection.framework.Runner
```

Tek bir demo sınıfı çalıştırmak için örnek:

```bash
java -cp out com.collection.framework.list.ArrayListDeepDive
```

---

Bu dokümantasyon ve örnekler, Java Collection Framework’ü temelden, ince ayrıntısına kadar clean code ile anlamanız için hazırlanmıştır.
