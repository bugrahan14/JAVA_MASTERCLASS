# 2. Temel Kavramlar

Bu bölümde type parameter, type argument ve raw type kavramlarını clean code perspektifiyle işliyoruz.

## 2.1 Type Parameter (Tip Parametresi)

Generic sınıf veya metot tanımında köşeli parantez içinde kullandığınız **placeholder** bir isimdir. Yaygın konvansiyonlar:

| İsim | Kullanım |
|------|----------|
| `T` | Type — genel bir tip |
| `E` | Element — koleksiyon elemanı |
| `K` | Key — anahtar |
| `V` | Value — değer |

**Clean code:** Anlamlı ve tutarlı isim kullanın; gerektiğinde `TKey`, `TValue` gibi daha açıklayıcı isimler tercih edilebilir.

### Generic sınıf

```java
public class Box<T> {
    private T value;

    public void set(T value) { this.value = value; }
    public T get() { return value; }
}
```

`T` burada "bu kutuda ne tip tutulacaksa o" anlamına gelir.

### Generic metot

```java
public static <T> T getFirst(List<T> list) {
    if (list == null || list.isEmpty()) return null;
    return list.get(0);
}
```

Metot tanımındaki `<T>`, "bu metot bir tip parametresi kullanıyor" der; `List<T>` ve dönüş tipi `T` bu parametreye bağlıdır.

### Birden fazla tip parametresi

```java
public class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() { return key; }
    public V getValue() { return value; }
}
```

## 2.2 Type Argument (Tip Argümanı)

Generic tipe **somut** olarak verdiğiniz tiptir. Derleyici `T` yerine bu tipi koyar.

```java
Box<String> stringBox = new Box<>();
Box<Integer> intBox = new Box<>();
Pair<String, Integer> pair = new Pair<>("yaş", 25);
```

- `Box<String>` → `T` = `String`
- `Pair<String, Integer>` → `K` = `String`, `V` = `Integer`

Diamond operatörü `<>` (Java 7+): Sağ tarafta tipi tekrar yazmamak için kullanılır; derleyici soldaki tip argümanından çıkarım yapar.

```java
Box<String> box = new Box<>();  // new Box<String>() ile aynı
```

## 2.3 Raw Type ve Neden Kaçınılmalı

**Raw type**, tip argümanı **verilmeden** generic sınıfın kullanılmasıdır: `Box`, `List`, `Pair` gibi.

- Tarihsel neden: Eski (generics öncesi) kodla uyumluluk.
- **Clean code:** Raw type kullanmayın; her zaman tip argümanı verin. Derleyici uyarı üretir; bu uyarıları susturmak yerine doğru tipi yazın.

```java
Box rawBox = new Box();        // Uyarı; tip güvenliği yok
rawBox.set("test");
rawBox.set(42);                // Derleyici engel olmaz — tehlikeli
```

Doğru kullanım:

```java
Box<String> box = new Box<>();
box.set("test");
// box.set(42);  // Derleme hatası
```

## Ne yapmalı / Neden kaçınmalı

| Yap | Yapma |
|-----|--------|
| `Box<T>`, `List<E>` gibi tip parametresi kullan | Raw type (`Box`, `List`) kullanma |
| Anlamlı parametre isimleri (T, E, K, V) seç | Anlamsız veya karışık isimler kullanma |
| Diamond `<>` ile kısa ve okunaklı kod yaz | Gereksiz tekrarlı `new Box<String>()` yazma |

## İlgili örnek kod

- `src/main/java/com/generics/basics/Box.java`
- `src/main/java/com/generics/basics/Pair.java`
- `src/main/java/com/generics/basics/GenericMethodExamples.java`
- `src/main/java/com/generics/basics/BoxDemo.java`

Sonraki adım: [Sınırlı Tip Parametreleri (03-bounded-types.md)](03-bounded-types.md)
