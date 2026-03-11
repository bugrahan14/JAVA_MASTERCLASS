# Java if-else ve switch-case Temelden Detaylı Anlatım (Clean Code)

Bu dokümantasyon Java'da **if-else** ve **switch-case** yapılarını temelden ileri seviyeye, Clean Code prensipleriyle açıklar.

---

## 1. if-else Yapısı

### 1.1 Temel Sözdizimi

- **Tek if:** `if (koşul) { ... }` — Koşul true ise blok çalışır.
- **if-else:** `if (koşul) { ... } else { ... }` — İki dallı karar.
- **if-else if-else:** Birden fazla koşul sırayla değerlendirilir; ilk doğru koşulun bloğu çalışır.

Parantez ve blok kuralları:
- Koşul her zaman `( )` içinde yazılır.
- Clean Code: Gövde tek satır olsa bile **her zaman süslü parantez `{ }` kullanın**; sonradan ekleme yaparken hata riski azalır.

### 1.2 Tek if

Koşul doğruysa çalışan tek dal. Örneğin: yetki kontrolü, validasyon.

### 1.3 if-else

İki seçenekten birini çalıştırır. Okunabilirlik için koşulu anlamlı bir boolean değişkene atayabilirsiniz: `isValid`, `hasPermission` gibi.

### 1.4 if-else if-else Zinciri

Çoklu koşul. Aynı değişken sabit değerlerle kıyaslanıyorsa (örn. 1, 2, 3) **switch** daha okunabilir olabilir; aralık veya karmaşık ifadeler için if-else if uygundur.

### 1.5 İç İçe if (Nested) ve Düzleştirme

İç içe if'ler okunabilirliği düşürür. **Guard clause** ve **erken return** kullanarak yapıyı düzleştirin: önce hata/geçersiz durumları kontrol edip return edin, ana mantığı en dışta bırakın.

### 1.6 if-else için Clean Code Özeti

- Pozitif koşullar tercih edin (mümkünse `if (geçerli)` gibi).
- Anlamlı değişken ve metot isimleri kullanın.
- 3–4’ten fazla dal varsa switch veya polimorfizm/strateji düşünün.
- Her zaman blok kullanın; guard clause ile derinliği azaltın.

---

## 2. if-else Püf Noktaları

| Püf Noktası | Açıklama |
|-------------|----------|
| **Her zaman blok kullan** | Tek satırlık gövde için bile `{ }` kullanın; bakım ve hata önleme için. |
| **Guard clause** | Önce geçersiz/erken çıkış durumlarını kontrol edip return edin; else sayısını azaltın. |
| **Pozitif koşul** | `if (!geçersiz)` yerine `if (geçerli)` yazmak daha okunabilirdir (gerekirse değişken adını buna göre seçin). |
| **Karmaşıklık sınırı** | Çok fazla if-else if dalı varsa switch veya strateji/enum ile yeniden yapılandırın. |
| **Anlamlı isimler** | `if (x > 5)` yerine `boolean yeterliBakiye = x > 5; if (yeterliBakiye)` gibi. |
| **Erken return** | Metot içinde “mutlu yol”u koruyup, hata/özel durumları en üstte ele alın. |

---

## 3. switch-case Yapısı

### 3.1 Temel Sözdizimi

```text
switch (değişken) {
    case değer1:
        // ...
        break;
    case değer2:
        // ...
        break;
    default:
        // ...
}
```

Desteklenen tipler: **byte, short, int, char, String, enum** (ve ilgili wrapper tipleri).

### 3.2 break ve Fall-through

- **break** olmazsa bir sonraki case’e “düşer” (fall-through). Çoğu durumda her case sonunda `break` yazın.
- Fall-through bilinçli kullanılacaksa mutlaka yorumla belirtin.

### 3.3 default Kullanımı

Her zaman **default** dalını düşünün; beklenmeyen değerler için hata fırlatma veya loglama yapın.

### 3.4 Java 14+ switch Expression

- **Arrow syntax:** `case değer -> ifade;` — break gerekmez.
- Çoklu case: `case 1, 2, 3 -> ...`
- Değer döndürebilir: `int x = switch (n) { case 1 -> 10; default -> 0; };`

### 3.5 Ne Zaman switch, Ne Zaman if-else?

- **switch:** Aynı değişkenin **sabit değerlerle** (ve enum/String sabitleriyle) kıyaslanması.
- **if-else:** Aralık kontrolü (örn. `x > 5 && x < 10`), karmaşık boolean ifadeler, farklı değişkenler.

### 3.6 switch-case için Clean Code Özeti

- Case bloklarını kısa tutun; uzun mantık için ayrı metot çağrısı yapın.
- Çok sayıda case’te enum veya Map/strateji pattern düşünün.
- default’u unutmayın; beklenmeyen değeri açıkça ele alın.

---

## 4. switch-case Püf Noktaları

| Püf Noktası | Açıklama |
|-------------|----------|
| **break unutmayın** | Klasik switch’te her case sonunda `break` yazın (bilinçli fall-through hariç). |
| **Arrow syntax (Java 14+)** | `case x -> ...` kullanarak break ihtiyacını ve hata riskini azaltın. |
| **default zorunlu** | Tüm olası değerleri kapsamıyorsanız default’ta hata veya log ekleyin. |
| **Uzun case → metot** | Case içi 2–3 satırdan uzunsa ayrı metoda taşıyın. |
| **Enum tercih** | String/int sabitleri yerine enum kullanmak tip güvenliği ve okunabilirlik sağlar. |
| **Switch expression** | Değer üretiyorsanız `switch (x) { case A -> değer1; ... }` ile ifade olarak kullanın. |

---

## 5. Karşılaştırma ve Özet

| Kriter | if-else | switch-case |
|--------|---------|-------------|
| Kullanım | Aralık, karmaşık koşul, birden fazla değişken | Aynı değişkenin sabit değerlerle kıyaslanması |
| Okunabilirlik | Çok dalda zorlaşabilir | Sabit listesi için genelde daha net |
| Performans | Derleyici optimizasyonları her ikisini de iyileştirir; öncelik okunabilirlik olsun | |

**Özet:** Koşul “bu değişken şu sabitlerden biri mi?” ise switch (veya enum/Map); “aralık veya karmaşık mantık” ise if-else tercih edin. Her iki yapıda da Clean Code için kısa bloklar, anlamlı isimler ve gerektiğinde guard clause / erken return kullanın.
