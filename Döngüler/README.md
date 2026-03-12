# Java Döngüler – Temelden Detaylı Örnekler

Bu proje, Java'da **while**, **for** ve **do-while** döngülerini temelden detaylı anlatan, Clean Code prensiplerine uygun örnek kodları içerir.

## Proje Yapısı

| Dosya | İçerik |
|-------|--------|
| [WhileDongusu.java](WhileDongusu.java) | while sözdizimi, koşul, break/continue, sonsuz döngü uyarısı |
| [ForDongusu.java](ForDongusu.java) | Klasik for, geriye sayım, 2'şer/5'er artış, iç içe for, for-each (dizi ve List) |
| [DoWhileDongusu.java](DoWhileDongusu.java) | do-while ile while farkı, menü döngüsü (0 ile çıkış) |

## Döngü Seçimi Kılavuzu

- **while:** Kaç tekrar yapılacağı önceden net değilse veya koşul karmaşıksa. Koşul başta kontrol edilir; false ise gövde hiç çalışmaz.
- **for:** Başlangıç, bitiş ve artış netse (sayıtlı tekrarlar). Okunabilir ve tek satırda yönetilebilir.
- **do-while:** En az bir kez işlem yapılacaksa (menü, kullanıcı girdisi, dosya/akış okuma). Gövde önce çalışır, koşul sonda kontrol edilir.

## Çalıştırma

Her sınıf bağımsız çalıştırılabilir:

```bash
javac WhileDongusu.java && java WhileDongusu
javac ForDongusu.java && java ForDongusu
javac DoWhileDongusu.java && java DoWhileDongusu
```

`DoWhileDongusu` menü örneği için konsoldan sayı girişi bekler; çıkmak için `0` yazın.

## Clean Code Uygulanan Kurallar

- Anlamlı değişken ve metot isimleri (`sayac`, `hedefDeger`, `kullaniciCikisIstemedi`)
- Magic number yok; `private static final` sabitler kullanıldı
- Her örnek tek sorumluluklu, kısa metotlara bölündü
- Yorumlar sadece gerekli yerlerde; kod kendini açıklıyor
