# 1. Neden Generics?

Generics, Java 5 ile gelen ve **tip güvenliğini** derleme zamanında sağlayan, **kod tekrarını** azaltan bir özelliktir. Bu bölümde neden ihtiyaç duyulduğunu ve clean code açısından ne kazandırdığını göreceksiniz.

## Motivasyon

### Tip güvenliği

Generics öncesinde koleksiyonlar (örneğin `List`, `Map`) her şeyi `Object` olarak tutuyordu. Eleman alırken her seferinde **cast** yapmanız gerekirdi. Yanlış tipe cast ederseniz hata **runtime**'da, yani program çalışırken ortaya çıkar:

```java
// Generics OLMADAN (kötü örnek)
List list = new ArrayList();
list.add("Merhaba");
list.add(42);  // Yanlışlıkla Integer ekledik — derleyici ses çıkarmaz!
String s = (String) list.get(1);  // ClassCastException — program çökebilir
```

Generics ile aynı liste **sadece** `String` kabul eder; yanlış tip eklemek **derleme** aşamasında engellenir:

```java
// Generics İLE (iyi örnek)
List<String> list = new ArrayList<>();
list.add("Merhaba");
// list.add(42);  // Derleme hatası: Integer String değil
String s = list.get(0);  // Cast gerekmez; tip güvenli
```

**Clean code ilkesi:** Mümkün olduğunca cast kullanmayın; tipi derleyiciye bırakın.

### Kod tekrarının azalması

Aynı mantığı farklı tipler için tekrar yazmak yerine, bir kez **generic** yazarsınız:

- `Integer` için kutu, `String` için kutu, `Person` için kutu ayrı ayrı sınıflar yerine
- Tek bir `Box<T>` sınıfı ile hepsini karşılarsınız.

Bu da **DRY** (Don't Repeat Yourself) prensibiyle uyumludur.

## Özet Karşılaştırma

| Konu | Generics olmadan | Generics ile |
|------|-------------------|--------------|
| Eleman alma | `(String) list.get(0)` — cast gerekir | `list.get(0)` — doğrudan `String` |
| Yanlış tip ekleme | Runtime'da ClassCastException | Derleme hatası |
| Kod tekrarı | Her tip için ayrı sınıf/metot | Tek generic sınıf/metot |

## İlgili örnek kod

- `src/main/java/com/generics/basics/BoxDemo.java` — `Box<T>` ile tip güvenli kutu kullanımı
- `src/main/java/com/generics/basics/WhyGenericsDemo.java` — raw list vs `List<String>` karşılaştırması

Sonraki adım: [Temel Kavramlar (02-basics.md)](02-basics.md)
