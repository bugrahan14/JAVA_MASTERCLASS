package tutorial;

/**
 * Adım 2: Thread nedir?
 * <p>
 * Bu adımda öğreneceksiniz: Thread, bir process içindeki yürütme birimidir.
 * Aynı process'teki thread'ler heap ve static alanları paylaşır; her thread'in
 * kendi stack'i ve program sayacı (PC) vardır. Böylece aynı anda birden fazla
 * işi "paralel" (veya eşzamanlı) yapabiliriz.
 */
public final class Step02_ThreadNedir {

    public static void main(String[] args) {
        System.out.println("========== ADIM 2: Thread Nedir? ==========\n");

        System.out.println("• Thread = Process içinde çalışan hafif yürütme birimi.");
        System.out.println("  - Bir process'te birden fazla thread olabilir.");
        System.out.println("  - Hepsi aynı process'in heap'ini ve static alanlarını PAYLAŞIR.");
        System.out.println("  - Her thread'in kendi stack'i vardır (yerel değişkenler orada).");
        System.out.println("  - Her thread'in kendi program sayacı (hangi komutta olduğu) vardır.\n");

        System.out.println("• Neden thread?");
        System.out.println("  - Aynı anda birden fazla işi ilerletmek (örn. ağ isteği + UI güncelleme).");
        System.out.println("  - Çok çekirdekli işlemcide gerçek paralel çalışma.\n");

        System.out.println("• Java'da: main() çalıştığında zaten bir thread'desiniz — 'main' thread.");
        System.out.println("  Sonraki adımda ikinci bir thread nasıl oluşturulur, onu göreceğiz.\n");
    }
}
