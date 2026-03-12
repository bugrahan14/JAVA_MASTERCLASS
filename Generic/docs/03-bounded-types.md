# 3. Bounded Type Parameters (Sınırlı Tip Parametreleri)

Bazen tip parametresinin **belirli bir üst sınıf veya arayüzü** karşılamasını isteriz. Böylece generic içinde o tipe özgü metotları güvenle çağırabiliriz.

## Upper bound: `extends`

`<T extends U>` ifadesi: **T, U veya U'nun bir alt tipi olmalıdır.**

Örnek: Sadece sayısal tiplerle çalışan bir sınıf:

```java
public class NumberBox<T extends Number> {
    private T value;

    public NumberBox(T value) { this.value = value; }

    public int intValue() {
        return value.intValue();  // Number'da intValue() var
    }

    public double doubleValue() {
        return value.doubleValue();
    }
}
```

Kullanım:

```java
NumberBox<Integer> ib = new NumberBox<>(42);
NumberBox<Double> db = new NumberBox<>(3.14);
// NumberBox<String> sb = new NumberBox<>("x");  // Derleme hatası
```

**Amaç:** Generic içinde `T` üzerinde sadece `Number`'ın (ve alt sınıflarının) sağladığı metotları kullanabilmek.

## Multiple bounds (Çoklu sınır)

`T` hem bir sınıfı hem bir veya daha fazla arayüzü karşılayabilir:

```java
public class BoundedExample<T extends Number & Comparable<T>> {
    public boolean isGreaterThan(T a, T b) {
        return a.compareTo(b) > 0;
    }
}
```

Kurallar:

- En fazla **bir sınıf** olabilir (ve ilk sırada yazılır).
- Sonrasında `&` ile arayüzler eklenir.
- **Clean code:** Gerçekten ihtiyaç yoksa karmaşık bound kullanmayın; okunabilirlik azalır.

## Ne yapmalı / Neden kaçınmalı

| Yap | Yapma |
|-----|--------|
| Sadece ihtiyaç duyduğun metotları kullanabiliyorsan `extends` kullan | Gereksiz yere çok üst tip veya çoklu bound ekleme |
| `Number`, `Comparable` gibi anlamlı üst tipler seç | Okunabilirliği bozan çok karmaşık bound'lar yazma |

## İlgili örnek kod

- `src/main/java/com/generics/bounded/NumberBox.java`
- `src/main/java/com/generics/bounded/BoundedExample.java`
- `src/main/java/com/generics/bounded/NumberBoxDemo.java`

Sonraki adım: [Wildcards ve PECS (04-wildcards-pecs.md)](04-wildcards-pecs.md)
