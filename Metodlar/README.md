# Java Metodlar – Eğitim Projesi

Bu proje, **Java metodları**, **metodlarda işlemler** ve **method overloading** konularını en temelden, clean code ilkeleriyle anlatan bir eğitim içeriğidir.

## İçerik

- **[METODLAR.md](METODLAR.md)** — Tüm konuların Türkçe, detaylı anlatımı ve kod örnekleri (metod nedir, bileşenler, çağırma, işlemler, overloading, clean code).

## Proje Yapısı

```
Metodlar/
├── METODLAR.md          # Ana eğitim dokümanı
├── README.md            # Bu dosya
├── src/                 # Kaynak kod (.java)
│   ├── temel/
│   ├── islemler/
│   ├── overloading/
│   └── cleancode/
└── out/                 # Derlenmiş sınıflar (.class) — ayrı paket
    ├── temel/
    ├── islemler/
    ├── overloading/
    └── cleancode/
```

Kaynak dosyalar `src/`, derlenen `.class` dosyaları `out/` klasöründe tutulur.

## Derleme ve Çalıştırma

Proje kökünden (Metodlar klasöründen):

```bash
# Tüm kaynakları out/ klasörüne derle (-d out = .class çıktı dizini)
javac -d out src/temel/*.java src/islemler/*.java src/overloading/*.java src/cleancode/*.java
```

Çalıştırırken classpath olarak `out` kullanın:

```bash
java -cp out temel.MetodTemelleri
java -cp out temel.MetodCagirma
java -cp out islemler.MetodlardaIslemler
java -cp out overloading.OverloadingOrnekleri
java -cp out overloading.OverloadingCleanCode
java -cp out cleancode.TemizMetodOrnekleri
```

Tek sınıf derlemek için (örnek):

```bash
javac -d out src/temel/MetodTemelleri.java
java -cp out temel.MetodTemelleri
```

## Gereksinimler

- Java JDK 8 veya üzeri (örnekler basit Java sözdizimi kullanır).
