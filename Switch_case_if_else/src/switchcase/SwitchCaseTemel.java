package switchcase;

/**
 * Java switch-case yapısı: Klasik switch, break/default ve Java 14+ switch expression.
 *
 * PÜF NOKTALARI (switch-case):
 * - Klasik switch'te her case sonunda break yazın (bilinçli fall-through hariç).
 * - Java 14+ arrow syntax (case x -> ...) break ihtiyacını ortadan kaldırır.
 * - default'u unutmayın; beklenmeyen değer için hata veya log.
 * - Uzun case blokları için ayrı metot çağrısı yapın.
 * - Sabit listesi için enum kullanmak tip güvenliği sağlar.
 */
public class SwitchCaseTemel {

    public enum Gun {
        PAZARTESI, SALI, CARSAMBA, PERSEMBE, CUMA, CUMARTESI, PAZAR
    }

    // ---------- 1. Klasik switch (break ve default) ----------
    public static String gunAdiKlasik(int gunNo) {
        String ad;
        switch (gunNo) {
            case 1:
                ad = "Pazartesi";
                break;
            case 2:
                ad = "Salı";
                break;
            case 3:
                ad = "Çarşamba";
                break;
            case 4:
                ad = "Perşembe";
                break;
            case 5:
                ad = "Cuma";
                break;
            case 6:
                ad = "Cumartesi";
                break;
            case 7:
                ad = "Pazar";
                break;
            default:
                throw new IllegalArgumentException("Geçersiz gün numarası: " + gunNo);
        }
        return ad;
    }

    // ---------- 2. Bilinçli fall-through (yorumla belirtilmeli) ----------
    public static boolean haftaSonuMu(int gunNo) {
        switch (gunNo) {
            case 6:
            case 7:
                // Fall-through: 6 ve 7 hafta sonu
                return true;
            default:
                return false;
        }
    }

    // ---------- 3. Java 14+ switch expression (arrow syntax, değer döndürme) ----------
    public static int ayGunSayisi(String ay) {
        return switch (ay.toUpperCase()) {
            case "OCAK", "MART", "MAYIS", "TEMMUZ", "AGUSTOS", "EKIM", "ARALIK" -> 31;
            case "NISAN", "HAZIRAN", "EYLUL", "KASIM" -> 30;
            case "SUBAT" -> 28;
            default -> throw new IllegalArgumentException("Bilinmeyen ay: " + ay);
        };
    }

    // ---------- 4. Enum ile switch (tip güvenliği) ----------
    public static boolean calismaGunuMu(Gun gun) {
        return switch (gun) {
            case PAZARTESI, SALI, CARSAMBA, PERSEMBE, CUMA -> true;
            case CUMARTESI, PAZAR -> false;
        };
    }

    // ---------- 5. Uzun mantık: case içinde metot çağrısı (Clean Code) ----------
    public static void islemYap(String komut) {
        switch (komut != null ? komut.toUpperCase() : "") {
            case "KAYDET" -> kaydet();
            case "SIL" -> sil();
            case "LISTELE" -> listele();
            default -> System.out.println("Bilinmeyen komut: " + komut);
        }
    }

    private static void kaydet() {
        System.out.println("Kaydediliyor...");
    }

    private static void sil() {
        System.out.println("Siliniyor...");
    }

    private static void listele() {
        System.out.println("Listeleniyor...");
    }

    public static void main(String[] args) {
        System.out.println(gunAdiKlasik(3));
        System.out.println(haftaSonuMu(6));
        System.out.println(ayGunSayisi("MART"));
        System.out.println(calismaGunuMu(Gun.CUMA));
        islemYap("KAYDET");
    }
}
