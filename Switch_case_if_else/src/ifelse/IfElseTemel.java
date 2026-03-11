package ifelse;

/**
 * Java if-else yapısı: Temelden Clean Code prensiplerine.
 *
 * PÜF NOKTALARI (if-else):
 * - Her zaman süslü parantez { } kullanın (tek satırlık gövde için bile).
 * - Guard clause: Önce geçersiz durumları kontrol edip return edin.
 * - Pozitif koşul tercih edin; anlamlı boolean isimleri (isValid, hasPermission).
 * - 3-4'ten fazla dal varsa switch veya strateji düşünün.
 * - Erken return ile iç içe if'leri düzleştirin.
 */
public class IfElseTemel {

    // ---------- 1. Tek if (Clean Code: her zaman blok kullan) ----------
    public static void tekIfOrnek(int yas) {
        if (yas >= 18) {
            System.out.println("Reşitsiniz.");
        }
    }

    // ---------- 2. if-else; anlamlı koşul ismi ----------
    public static void ifElseOrnek(int bakiye, int cekilecek) {
        boolean yeterliBakiye = bakiye >= cekilecek;
        if (yeterliBakiye) {
            System.out.println("İşlem yapılabilir.");
        } else {
            System.out.println("Yetersiz bakiye.");
        }
    }

    // ---------- 3. if-else if-else zinciri ----------
    public static String notHarfi(int puan) {
        if (puan >= 90) {
            return "A";
        } else if (puan >= 80) {
            return "B";
        } else if (puan >= 70) {
            return "C";
        } else if (puan >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    // ---------- 4. Kötü: İç içe if (derin ve okunması zor) ----------
    public static void kotuIciciceIf(String kullanici, boolean admin, int izin) {
        if (kullanici != null) {
            if (admin) {
                if (izin > 0) {
                    System.out.println("Erişim verildi.");
                } else {
                    System.out.println("İzin yok.");
                }
            } else {
                System.out.println("Admin değil.");
            }
        } else {
            System.out.println("Kullanıcı yok.");
        }
    }

    // ---------- 5. İyi: Guard clause ve erken return ile düzleştirme ----------
    public static void iyiGuardClause(String kullanici, boolean admin, int izin) {
        if (kullanici == null) {
            System.out.println("Kullanıcı yok.");
            return;
        }
        if (!admin) {
            System.out.println("Admin değil.");
            return;
        }
        if (izin <= 0) {
            System.out.println("İzin yok.");
            return;
        }
        System.out.println("Erişim verildi.");
    }

    // ---------- 6. Erken return ile "mutlu yol" ----------
    public static boolean gecerliSiparis(int adet, double fiyat) {
        if (adet <= 0) {
            return false;
        }
        if (fiyat <= 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        tekIfOrnek(20);
        ifElseOrnek(100, 50);
        System.out.println(notHarfi(85));
        iyiGuardClause("ali", true, 1);
        System.out.println(gecerliSiparis(2, 10.5));
    }
}
