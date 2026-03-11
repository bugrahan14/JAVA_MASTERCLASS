package cleancode;

/**
 * Aynı senaryonun "kötü" ve "iyi" versiyonu:
 * - Kötü: Uzun if-else if zinciri, tek metotta her şey.
 * - İyi: switch (veya enum) + kısa bloklar / metot çağrıları.
 */
public class CleanCodeKarsilastirma {

    public enum Rol {
        ADMIN, EDITOR, USER, MISAFIR
    }

    // ---------- Kötü: Uzun if-else if zinciri ----------
    public static void kotuYetkiKontrolu(String rol) {
        if (rol.equals("ADMIN")) {
            System.out.println("Tüm yetkiler.");
        } else if (rol.equals("EDITOR")) {
            System.out.println("Düzenleme ve yayınlama.");
        } else if (rol.equals("USER")) {
            System.out.println("Sadece okuma ve kendi içeriği.");
        } else if (rol.equals("MISAFIR")) {
            System.out.println("Sadece okuma.");
        } else {
            System.out.println("Bilinmeyen rol.");
        }
    }

    // ---------- İyi: switch + kısa bloklar (Java 14+ expression) ----------
    public static void iyiYetkiKontrolu(Rol rol) {
        String mesaj = switch (rol) {
            case ADMIN -> "Tüm yetkiler.";
            case EDITOR -> "Düzenleme ve yayınlama.";
            case USER -> "Sadece okuma ve kendi içeriği.";
            case MISAFIR -> "Sadece okuma.";
        };
        System.out.println(mesaj);
    }

    // ---------- İyi: Guard clause ile validasyon ----------
    public static double kotuIndirimHesapla(double tutar, int adet) {
        if (adet > 0) {
            if (tutar > 0) {
                if (adet >= 10) {
                    return tutar * 0.85;
                } else if (adet >= 5) {
                    return tutar * 0.90;
                } else {
                    return tutar;
                }
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    public static double iyiIndirimHesapla(double tutar, int adet) {
        if (adet <= 0 || tutar <= 0) {
            return 0;
        }
        if (adet >= 10) {
            return tutar * 0.85;
        }
        if (adet >= 5) {
            return tutar * 0.90;
        }
        return tutar;
    }

    public static void main(String[] args) {
        kotuYetkiKontrolu("EDITOR");
        iyiYetkiKontrolu(Rol.EDITOR);
        System.out.println(kotuIndirimHesapla(100, 10));
        System.out.println(iyiIndirimHesapla(100, 10));
    }
}
