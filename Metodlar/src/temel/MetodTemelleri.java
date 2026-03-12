package temel;

/**
 * Java'da metod tanımı, parametre, return ve void kavramlarının temel örnekleri.
 * Clean code: Anlamlı isimler, tek sorumluluk.
 */
public class MetodTemelleri {

    public static void main(String[] args) {
        selamla();
        System.out.println("Toplam: " + topla(3, 5));
        System.out.println("Karesi: " + kareAl(4));
        System.out.println("Geçerli mi: " + pozitifMi(7));
    }

    /** void: Değer döndürmez, sadece iş yapar. */
    public static void selamla() {
        System.out.println("Merhaba!");
    }

    /** Dönüş tipi int; return ile değer döner. */
    public static int topla(int a, int b) {
        return a + b;
    }

    /** Parametre alır, hesaplar, döner. */
    public static int kareAl(int sayi) {
        return sayi * sayi;
    }

    /** boolean dönen metod. */
    public static boolean pozitifMi(int sayi) {
        return sayi > 0;
    }
}
