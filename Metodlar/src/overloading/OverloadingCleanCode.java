package overloading;

/**
 * Overloading'in anlamlı kullanımı: Hesap ve string birleştirme örnekleri.
 */
public class OverloadingCleanCode {

    public static void main(String[] args) {
        System.out.println(Hesaplayici.alan(5));              // kare
        System.out.println(Hesaplayici.alan(4, 6));           // dikdörtgen
        System.out.println(Mesaj.birlestir("Merhaba", "Dünya"));
        System.out.println(Mesaj.birlestir("A", "B", "C"));
    }
}

class Hesaplayici {
    /** Kare alanı. */
    public static double alan(double kenar) {
        return kenar * kenar;
    }

    /** Dikdörtgen alanı. */
    public static double alan(double en, double boy) {
        return en * boy;
    }
}

class Mesaj {
    public static String birlestir(String a, String b) {
        return a + " " + b;
    }

    public static String birlestir(String a, String b, String c) {
        return a + " " + b + " " + c;
    }
}
