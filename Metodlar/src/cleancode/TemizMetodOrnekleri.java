package cleancode;

/**
 * Clean code: Tek sorumluluk, kısa metodlar, anlamlı isimler.
 * Kötü vs iyi örnek karşılaştırması.
 */
public class TemizMetodOrnekleri {

    public static void main(String[] args) {
        System.out.println("Geçerli kullanıcı: " + kullaniciGecerliMi("ali", 20));
        System.out.println("Fiyat (KDV): " + fiyatKdvDahil(100.0));
    }

    // --- İYİ: Tek sorumluluk, anlamlı isim ---
    public static boolean kullaniciGecerliMi(String ad, int yas) {
        return adBosDegil(ad) && yasAraliginda(yas, 0, 150);
    }

    private static boolean adBosDegil(String ad) {
        return ad != null && !ad.isBlank();
    }

    private static boolean yasAraliginda(int yas, int min, int max) {
        return yas >= min && yas <= max;
    }

    // --- İYİ: Küçük, okunabilir metod ---
    public static double fiyatKdvDahil(double fiyat) {
        double kdvOrani = 0.18;
        return fiyat * (1 + kdvOrani);
    }
}
