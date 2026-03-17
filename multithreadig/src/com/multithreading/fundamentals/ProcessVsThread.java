package com.multithreading.fundamentals;

/**
 * Process ve Thread kavramlarının farkını açıklar.
 * <p>
 * Process: İşletim sistemi tarafından çalıştırılan, kendi bellek alanı (address space),
 * kaynakları ve en az bir thread'i olan bağımsız program örneği.
 * Thread: Bir process içinde çalışan, process'in kaynaklarını paylaşan hafif yürütme birimi.
 * Aynı process'teki thread'ler heap ve static alanları paylaşır; sadece kendi stack'leri ayrıdır.
 */
public final class ProcessVsThread {

    public static void main(String[] args) {
        printProcessVsThreadExplanation();
    }

    private static void printProcessVsThreadExplanation() {
        System.out.println("=== Process vs Thread ===\n");

        System.out.println("PROCESS:");
        System.out.println("  - Kendi bellek alanı (address space), kendi kaynakları");
        System.out.println("  - Process'ler birbirinden izole; iletişim IPC ile");
        System.out.println("  - Örnek: JVM bir process, her Java uygulaması ayrı process\n");

        System.out.println("THREAD:");
        System.out.println("  - Aynı process içinde; heap ve static alanı paylaşır");
        System.out.println("  - Her thread'in kendi stack'i ve program sayacı (PC) vardır");
        System.out.println("  - Hafif (creation/context switch maliyeti process'ten düşük)\n");

        System.out.println("Java'da: main() çalıştığında tek bir 'main' thread ile başlarsınız.");
        System.out.println("Yeni thread'ler Thread sınıfı veya Runnable ile oluşturulur.");
    }
}
