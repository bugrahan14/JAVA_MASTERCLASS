# Java Generics: Temelden Detaylı ve Clean Code Anlatımı

Bu proje, **Java generics** konusunu en temelden alıp wildcard ve type erasure'a kadar eksiksiz işleyen, **clean code** prensipleriyle yazılmış doküman ve örnek kodları içerir.

## İçerik Yapısı

| Bölüm | Doküman | Açıklama |
|-------|---------|----------|
| 1 | [Neden Generics?](docs/01-why-generics.md) | Motivasyon, tip güvenliği, kod tekrarının azalması |
| 2 | [Temel Kavramlar](docs/02-basics.md) | Type parameter, type argument, raw type |
| 3 | [Sınırlı Tip Parametreleri](docs/03-bounded-types.md) | `extends`, multiple bounds |
| 4 | [Wildcards ve PECS](docs/04-wildcards-pecs.md) | `?`, `extends`, `super`, Producer Extends Consumer Super |
| 5 | [Type Erasure](docs/05-type-erasure.md) | Tip silme, kısıtlamalar, pratik sonuçlar |
| 6 | [Clean Code Kuralları](docs/06-clean-code.md) | Özet kurallar, anti-pattern'ler, yap/yapma tablosu |

## Proje Yapısı

```
Generic/
├── README.md
├── docs/           # Konu anlatımları (Türkçe)
├── src/
│   └── main/java/
│       └── com/generics/
│           ├── basics/        # Box<T>, generic metot örnekleri
│           ├── bounded/      # Number ile sınırlı örnekler
│           ├── wildcards/    # PECS örnekleri
│           └── bestpractices/ # Clean code karşılaştırmaları
└── pom.xml         # Maven yapılandırması
```

## Gereksinimler

- JDK 8 veya üzeri
- Maven 3.x (opsiyonel; `mvn compile` ile derleme)

## Derleme ve Çalıştırma

```bash
mvn clean compile
```

Örnek sınıfları çalıştırmak için (örnek):

```bash
mvn exec:java -Dexec.mainClass="com.generics.basics.BoxDemo"
```

## Lisans

Eğitim amaçlı kullanım için serbesttir.
