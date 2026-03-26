# Java Lambda — Genel Rehber

Bu depo, Java’da **lambda ifadelerini** en temel kavramlardan başlayarak örnek kod ve Türkçe açıklamalarla anlatır. Kodlar **clean code** ve **okunabilirlik** öncelikleriyle düzenlenmiştir.

## Gereksinimler

- **JDK 17+** (projede `maven.compiler.release` ve `javac --release 17` ile uyumludur)
- İsteğe bağlı: **Apache Maven** (yüklüyse `mvn compile exec:java` kullanılabilir)

## Projeyi çalıştırma

Maven yoksa:

```powershell
cd "c:\Users\ertas\OneDrive\Masaüstü\Lambda"
New-Item -ItemType Directory -Force -Path "target\classes" | Out-Null
javac -encoding UTF-8 --release 17 -d target\classes src\main\java\com\example\lambda\*.java
java -cp target\classes com.example.lambda.Main
```

Maven varsa:

```bash
mvn compile exec:java -Dexec.mainClass=com.example.lambda.Main
```

## Lambda nedir? (özet)

- Lambda, **tek soyut metodu olan bir arayüzün** (fonksiyonel arayüz) uygulanmasını **kısa sözdizimi** ile yazmanın yoludur.
- `(parametreler) -> ifade` veya `(parametreler) -> { /* blok */ }` biçimindedir.
- Amaç: anonim sınıf tekrarını azaltmak, **Comparator**, **Stream**, **Collection** API’leriyle doğal bir stil sağlamak.

## Kaynak dosyalar (ne nerede?)

| Dosya | Konu |
|--------|------|
| `TemelLambda.java` | Lambda sözdizimi, anonim sınıf ile karşılaştırma, `Comparator` |
| `YerlesikFonksiyonelTurler.java` | `Predicate`, `Function`, `Consumer`, `Supplier` |
| `MethodReferenceDemo.java` | `::` ile statik / örnek / kurucu referansları |
| `LambdaVeStreams.java` | Stream pipeline içinde lambda kullanımı |
| `TemizKodPrensipleri.java` | Uzun lambdaları metoda taşıma, anlamlı `Predicate`, null güvenliği |
| `Main.java` | Tüm örnekleri sırayla çalıştırır |

## Temiz kod ilkeleri (lambda bağlamında)

1. **Kısa ve tek sorumluluk:** Karmaşık mantığı lambda içinde büyütmek yerine private yardımcı metoda veya isimli `Predicate` / `Function` değişkenine ayırın.
2. **Standart tipler:** Mümkünse `java.util.function` paketindeki arayüzleri kullanın; ekip içi ortak dil oluşur.
3. **Method reference:** Sadece mevcut bir metodu iletiyorsanız `Sınıf::metot` daha sade olabilir; anlam kayboluyorsa lambda ile açık yazın.
4. **Stream’de yan etki:** Mümkünse `collect` / `reduce` ile sonuç üretin; `forEach` içinde paylaşılan mutable durumu şişirmekten kaçının.
5. **null ve koleksiyonlar:** `List.of` **null eleman kabul etmez**; null içeren örnekler için `ArrayList` veya `Arrays.asList` kullanın.

## Öğrenme sırası (önerilen)

1. `TemelLambda` — sözdizimi ve fonksiyonel arayüz fikri  
2. `YerlesikFonksiyonelTurler` — günlük işler için hazır tipler  
3. `MethodReferenceDemo` — `::` kısayolu  
4. `LambdaVeStreams` — bildirimsel veri işleme  
5. `TemizKodPrensipleri` — sürdürülebilir stil  

## Ek okuma (resmi / güvenilir)

- [Oracle: Lambda Expressions](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)  
- [java.util.function](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/package-summary.html)  

---

*Kod içi açıklamalar Türkçe yorum satırları ve Javadoc ile verilmiştir; detay için ilgili `.java` dosyalarını açmanız yeterlidir.*
