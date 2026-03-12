# Java: Interface, Abstract Class ve Inner Class

Bu proje, Java'da **interface**, **abstract class** ve **inner class** konularını en temelden alarak, **Clean Code** prensipleriyle anlatan dokümantasyon ve çalıştırılabilir örnekleri içerir.

## İçindekiler

- [Dokümantasyon](#dokümantasyon)
- [Proje Yapısı](#proje-yapısı)
- [Örnekleri Çalıştırma](#örnekleri-çalıştırma)

## Dokümantasyon

Tüm konuların detaylı anlatımı (Türkçe):

- **[docs/INTERFACE_ABSTRACT_INNER.md](docs/INTERFACE_ABSTRACT_INNER.md)** — Interface, abstract class ve inner class'ın tanımları, sözdizimi, kullanım alanları, Clean Code notları ve "Ne zaman hangisi?" özeti.

## Proje Yapısı

```
src/
  interfaces/      → Interface örnekleri (temel, default/static, functional)
  abstracts/       → Abstract class ve Template Method örnekleri
  innerclasses/    → Member, static nested, local ve anonymous inner class örnekleri
```

- **interfaces**: `Reportable`, `PdfReport`, `ConsoleReport`; default/static metotlar; functional interface ve lambda.
- **abstracts**: Soyut `Shape` benzeri sınıf; Template Method ile `DataProcessor` örneği.
- **innerclasses**: Member inner (iterator benzeri), static nested (Builder), local class, anonymous class örnekleri.

Her pakette `*Demo.java` sınıfları örnekleri çalıştırılabilir hale getirir.

## Örnekleri Çalıştırma

Proje düz Java kaynakları içerir. Kaynak kökü `src` olacak şekilde derleyip çalıştırabilirsiniz.

Örnek (kök klasör `İnterface` iken):

```bash
# Derleme (tüm kaynaklar)
javac -d out src/interfaces/*.java src/abstracts/*.java src/innerclasses/*.java

# Çalıştırma
java -cp out interfaces.InterfacesDemo
java -cp out abstracts.AbstractsDemo
java -cp out innerclasses.InnerClassesDemo
```
