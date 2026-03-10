# Java OOP — Temelden Eğitim

Bu proje, Java Nesne Yönelimli Programlama (OOP) konusunu en temelden başlayarak, clean code ilkeleri ve pratik örneklerle anlatır.

## Proje Yapısı

```
OOP/
├── README.md
└── src/
    ├── 01_classes_and_objects/   # Sınıf ve nesne
    ├── 02_constructors/          # Kurucular
    ├── 03_encapsulation/         # Kapsülleme
    ├── 04_inheritance/           # Kalıtım
    ├── 05_polymorphism/          # Çok biçimlilik
    ├── 06_abstraction/           # Soyutlama (abstract + interface)
    ├── 07_solid/                 # SOLID prensipleri
    └── practice/                 # Birleşik pratik: kütüphane mini projesi
```

## Konu Listesi

| Paket | Konu | Ana Kavramlar |
|-------|------|----------------|
| 01 | Sınıf ve nesne | Sınıf, alan, metot, nesne, referans |
| 02 | Kurucular | Constructor, overload, this() |
| 03 | Kapsülleme | private, getter/setter, veri koruma |
| 04 | Kalıtım | extends, super, override, protected |
| 05 | Çok biçimlilik | Üst tip referansı, runtime polymorphism |
| 06 | Soyutlama | abstract sınıf, interface |
| 07 | SOLID | S-O-L-I-D prensipleri |
| practice | Pratik proje | Kütüphane yönetimi (tüm konular) |

## Nasıl Çalıştırılır

Proje standart Java kaynak dizini kullanır (`src/` altında paketler). Derleme ve çalıştırma:

**Tüm sınıfları derleme (OOP dizininden):**
```bash
mkdir -p out
javac -d out src/01_classes_and_objects/*.java src/02_constructors/*.java src/03_encapsulation/*.java src/04_inheritance/*.java src/05_polymorphism/*.java src/06_abstraction/*.java src/07_solid/*.java src/practice/*.java
```

**Tek bir demo çalıştırma (örnek):**
```bash
javac -d out src/01_classes_and_objects/*.java
java -cp out classes_and_objects.ClassesAndObjectsDemo
```

Klasör adları 01_, 02_... ile; paket adları Java kurallarına uygun (classes_and_objects, constructors, encapsulation, inheritance, polymorphism, abstraction, solid, practice).

**IDE kullanıyorsanız:** `src` klasörünü kaynak kökü (source root) olarak işaretleyin; main metodu olan `*Demo` sınıflarını çalıştırabilirsiniz.

## Clean Code (Özet)

- **İsimlendirme:** Sınıf PascalCase, metot/değişken camelCase.
- **Sorumluluk:** Her sınıf tek bir işten sorumlu.
- **Metot:** Kısa, tek iş; parametre sayısı az.
- **Sabitler:** Magic number/string yerine `static final` veya enum.

---

Konuları sırayla takip etmeniz önerilir: 01 → 02 → … → 07 → practice.
