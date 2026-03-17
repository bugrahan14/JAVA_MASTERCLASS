package tutorial;

/**
 * Adım 1: Program, Process ve JVM.
 * <p>
 * Bu adımda öğreneceksiniz: Bir Java programı çalıştığında işletim sistemi
 * bir process oluşturur. Bu process'in içinde JVM çalışır; main() metodu
 * bu tek process içinde çalışır. Multithreading'e geçmeden önce "tek process"
 * kavramını netleştiriyoruz.
 */
public final class Step01_ProgramVeProcess {

    public static void main(String[] args) {
        System.out.println("========== ADIM 1: Program, Process ve JVM ==========\n");

        // Program: yazdığımız kod (örn. bu .java dosyası).
        System.out.println("• Program: Yazdığımız kaynak kod (bu sınıf).");

        // Process: işletim sistemi bu programı çalıştırmak için ayrı bir "process" açar.
        // Her process'in kendi bellek alanı (address space), kendi kaynakları vardır.
        System.out.println("• Process: İşletim sistemi programı çalıştırınca oluşan bağımsız örnek.");
        System.out.println("  - Kendi belleği, kendi dosya tanımlayıcıları vb.");

        // JVM: Java programı aslında "java" komutuyla başlatılır; JVM bir process olarak çalışır.
        // main() bu process içinde tek bir "yürütme akışı" ile başlar.
        System.out.println("• JVM: 'java' komutuyla başlatılan process; main() bu process içinde çalışır.");

        System.out.println("\nŞu an bu kod TEK process içinde, TEK yürütme akışıyla çalışıyor.");
        System.out.println("Sonraki adımda bu process içinde birden fazla 'thread' (akış) oluşturmayı göreceğiz.\n");
    }
}
