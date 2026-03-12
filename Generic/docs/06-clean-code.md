# 6. Clean Code ile İlgili Kurallar ve Anti-Pattern'ler

Bu bölüm, Java generics kullanırken uyulması gereken **clean code** kurallarını ve sık görülen **anti-pattern**'leri özetler.

## Özet kurallar

1. **Anlamlı isimlendirme:** `T`, `E`, `K`, `V` konvansiyonuna uyun; gerektiğinde `TKey`, `TValue` gibi daha açıklayıcı isimler kullanın.
2. **En dar kapsam:** Sadece bir metotta generic gerekiyorsa sınıfı generic yapmayın; generic metot yeterli olabilir.
3. **Raw type kullanmayın:** Uyarıları `@SuppressWarnings` ile susturmak yerine doğru tip argümanını yazın.
4. **Wildcard'ı doğru yerde kullanın:** API'de esneklik gerekiyorsa PECS'e göre `? extends` / `? super` tercih edin.
5. **Karmaşık imzalardan kaçının:** Çok fazla bound veya iç içe generic okunabilirliği düşürür; gerekirse yardımcı tip veya metotlara bölün.
6. **Type erasure'ı unutmayın:** Runtime'da `T` yoktur; `new T()` veya `instanceof T` kullanılamaz.

## Yap / Yapma tablosu

| Konu | Yap | Yapma |
|------|-----|--------|
| **Tip parametresi** | `Box<T>`, `List<E>`, `Pair<K,V>` — anlamlı isim | Raw type `Box`, `List` kullanma |
| **Tip argümanı** | `new Box<>()`, `List<String>` — her zaman belirt | `new Box()` veya uyarıyı görmezden gelme |
| **Kapsam** | Sadece metotta gerekiyorsa generic metot | Gereksiz generic sınıf |
| **Wildcard** | Producer → `? extends T`, Consumer → `? super T` (PECS) | Tüketiciye extends, üreticiye super kullanma |
| **Bound** | Sadece ihtiyaç duyduğun sınırı koy | Gereksiz çoklu bound, okunamaz imzalar |
| **Runtime tip** | `Class<T>` veya factory ile tip taşı | `new T()`, `instanceof T` kullanma |
| **Uyarılar** | Tipi düzelt, raw type'dan kurtul | `@SuppressWarnings("unchecked")` ile susturma (istisna: gerçekten gerekli yerler) |

## Anti-pattern'ler

### 1. Raw type kullanımı

```java
// Anti-pattern
List list = new ArrayList();
list.add("x");
list.add(42);
String s = (String) list.get(1);  // Runtime hatası riski
```

**Doğru:** `List<String> list = new ArrayList<>();` ve sadece String ekleyin.

### 2. Wildcard'a eleman eklemeye çalışma

```java
// Anti-pattern
public void fill(List<?> list) {
    list.add("x");  // Derleme hatası; ? bilinmiyor
}
```

**Doğru:** Tüketici için `List<? super String>` veya generic metot: `<T> void fill(List<T> list, T value)`.

### 3. Producer'a super, consumer'a extends kullanma (PECS ihlali)

```java
// Anti-pattern: src'den okuyorsun ama super kullanıyorsun
void copy(List<? super T> dest, List<? super T> src)
```

**Doğru:** `void copy(List<? super T> dest, List<? extends T> src)` — src producer, dest consumer.

### 4. Gereksiz karmaşık bound

```java
// Anti-pattern: Gerçekten gerekmedikçe
public class Util<T extends Number & Comparable<T> & Serializable & Cloneable> { ... }
```

**Doğru:** Sadece kullandığınız metotları sağlayan en dar bound'u yazın.

### 5. Runtime'da generic tipi kullanmaya çalışma

```java
// Anti-pattern
public class Box<T> {
    public boolean isInstance(Object o) {
        return o instanceof T;  // Derleme hatası
    }
}
```

**Doğru:** `Class<T>` parametresi taşıyıp `clazz.isInstance(o)` kullanın veya tasarımı değiştirin.

### 6. Uyarıyı susturup raw type'a devam etme

```java
// Anti-pattern
@SuppressWarnings("unchecked")
List list = getRawList();
```

**Doğru:** `getRawList()`'in generic dönmesini sağlayın; mümkün değilse sadece dar bir blokta ve yorumla birlikte `@SuppressWarnings` kullanın.

## İlgili örnek kod

- `src/main/java/com/generics/bestpractices/GoodVsBadGenerics.java` — iyi ve kötü kullanım karşılaştırmaları
- Tüm `basics`, `bounded`, `wildcards` paketlerindeki örnekler

---

[← 05-type-erasure](05-type-erasure.md) | [README'ye dön](../README.md)
