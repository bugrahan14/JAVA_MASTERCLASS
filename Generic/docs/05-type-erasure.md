# 5. Type Erasure (Tip Silme)

Java'da generic bilgisi **sadece derleme zamanında** kullanılır. JVM (bytecode ve runtime) generic tip parametrelerini **görmez**; derleyici bunları siler ve gerekli yerlere **cast** ekler. Buna **type erasure** denir.

## Nasıl çalışır?

Derleyici:

1. Tip parametrelerini kaldırır (veya üst sınıfa indirger).
2. Gerekli yerlere tip dönüşümü (cast) ekler.
3. Gerekirse bridge metotlar üretir.

Örnek:

```java
public class Box<T> {
    private T value;
    public void set(T value) { this.value = value; }
    public T get() { return value; }
}
```

Erasure sonrası (kavramsal olarak) şuna dönüşür:

```java
public class Box {
    private Object value;
    public void set(Object value) { this.value = value; }
    public Object get() { return value; }
}
```

Bounded tip için (`<T extends Number>`) silme sonrası `T` → `Number` olur, `Object` değil.

## Kısıtlamalar ve pratik sonuçlar

### `new T()` yapılamaz

`T` runtime'da yok olduğu için hangi sınıfın örneğini oluşturacağınız belli değildir:

```java
public class Container<T> {
    // public T create() { return new T(); }  // Derleme hatası
}
```

**Çözüm örnekleri:** Factory parametresi (`Supplier<T>`), reflection (dikkatli kullanım), veya tasarımı buna göre değiştirmek.

### `instanceof T` kullanılamaz

Runtime'da `T` diye bir tip kalmadığı için kontrol anlamsızdır:

```java
// if (obj instanceof T)  // Derleme hatası
```

### Generic tip bilgisi runtime'da ayırt edilemez

`List<String>` ve `List<Integer>` bytecode'ta ikisi de `List` gibi görünür; reifiable değillerdir. Örneğin:

```java
List<String> strings = new ArrayList<>();
List<Integer> ints = new ArrayList<>();
// strings ve ints'in runtime'da "generic tipi" farklı değilmiş gibi işlenir
```

Bu yüzden `new List<String>[]` gibi generic diziler oluşturamazsınız; tip güvenliği runtime'da kontrol edilemez.

## Clean code çıkarımları

- Generics'in **sınırlarını** bilin: runtime'da tip parametresi yok.
- Runtime'da tip bilgisine ihtiyaç varsa tasarımı buna göre yapın (örneğin `Class<T>` parametresi taşımak, veya tipi tutan bir alan).
- Reflection veya workaround kullanacaksanız dokümante edin ve sadece gerekli yerlerde kullanın.

## Ne yapmalı / Neden kaçınmalı

| Yap | Yapma |
|-----|--------|
| Erasure'ı bil; runtime'da T'ye güvenme | `instanceof T` veya `new T()` yazmaya çalışma |
| Tip bilgisi gerekiyorsa `Class<T>` veya factory kullan | Gereksiz reflection ile generic bypass etme |

## İlgili örnek kod

- `src/main/java/com/generics/bestpractices/TypeErasureDemo.java`
- `src/main/java/com/generics/bestpractices/FactoryPatternWithGenerics.java` — `new T()` yerine factory kullanımı

Sonraki adım: [Clean Code Kuralları (06-clean-code.md)](06-clean-code.md)
