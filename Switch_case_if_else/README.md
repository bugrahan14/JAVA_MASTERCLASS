# Java if-else ve switch-case (Clean Code)

Bu proje Java'da **if-else** ve **switch-case** yapılarını temelden detaylı anlatan örnekleri ve dokümantasyonu içerir.

## Yapı

- **Dokümantasyon:** [docs/IfElseVeSwitchCase.md](docs/IfElseVeSwitchCase.md) — Temel sözdizimi, Clean Code önerileri ve her iki konu için **püf noktaları** tabloları.
- **Örnek kodlar:** İki ayrı pakette:
  - **`ifelse`** — Tek if, if-else, if-else if, guard clause ve erken return örnekleri.
  - **`switchcase`** — Klasik switch, break/default, Java 14+ switch expression ve enum kullanımı.
  - **`cleancode`** — Aynı senaryonun kötü/iyi karşılaştırması (uzun if-else vs switch + guard clause).

## Derleme ve çalıştırma

Kaynak klasörü `src`; paketler `ifelse`, `switchcase`, `cleancode`. JDK 14+ önerilir (switch expression için).

```bash
cd src
javac ifelse/IfElseTemel.java
java ifelse.IfElseTemel

javac switchcase/SwitchCaseTemel.java
java switchcase.SwitchCaseTemel

javac cleancode/CleanCodeKarsilastirma.java
java cleancode.CleanCodeKarsilastirma
```

## Püf noktaları özeti

- **if-else:** Her zaman blok kullan, guard clause ve erken return ile iç içe yapıyı azalt, anlamlı isimler ver.
- **switch-case:** break kullan (veya Java 14+ arrow syntax), default'u unutma, uzun case'leri metoda taşı, mümkünse enum kullan.

Detaylı tablolar ve açıklamalar için [docs/IfElseVeSwitchCase.md](docs/IfElseVeSwitchCase.md) dosyasına bakın.
