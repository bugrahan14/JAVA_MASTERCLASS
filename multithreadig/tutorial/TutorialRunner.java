package tutorial;

/**
 * Sadece tutorial adımlarını (Step01 … Step15) sırayla çalıştırır.
 * 0'dan multithreading anlatımını tek seferde görmek için bu sınıfı çalıştırın.
 */
public final class TutorialRunner {

    public static void main(String[] args) {
        System.out.println("\n********** MULTITHREADING TUTORIAL — 0'DAN TEK TEK **********\n");

        run("Adım 1: Program ve Process", () -> Step01_ProgramVeProcess.main(args));
        run("Adım 2: Thread nedir?", () -> Step02_ThreadNedir.main(args));
        run("Adım 3: İlk thread", () -> runMain(() -> Step03_IlkThread.main(args)));
        run("Adım 4: Runnable kullanımı", () -> runMain(() -> Step04_RunnableKullanimi.main(args)));
        run("Adım 5: Main thread", () -> Step05_MainThread.main(args));
        run("Adım 6: Daemon thread", () -> runMain(() -> Step06_DaemonThread.main(args)));
        run("Adım 7: Thread yaşam döngüsü", () -> runMain(() -> Step07_ThreadYasamDongusu.main(args)));
        run("Adım 8: Paylaşılan veri ve sorun", () -> runMain(() -> Step08_PaylasilanVeriVeSorun.main(args)));
        run("Adım 9: synchronized metot", () -> runMain(() -> Step09_SynchronizedMetot.main(args)));
        run("Adım 10: synchronized blok", () -> runMain(() -> Step10_SynchronizedBlok.main(args)));
        run("Adım 11: volatile", () -> runMain(() -> Step11_Volatile.main(args)));
        run("Adım 12: ExecutorService", () -> runMain(() -> Step12_ExecutorService.main(args)));
        run("Adım 13: Concurrent collections", () -> runMain(() -> Step13_ConcurrentCollections.main(args)));
        run("Adım 14: Atomic ve Lock", () -> runMain(() -> Step14_AtomicVeLock.main(args)));
        run("Adım 15: Özet", () -> Step15_Ozet.main(args));

        System.out.println("\n********** TUTORIAL TAMAMLANDI **********\n");
    }

    private static void run(String baslik, Runnable r) {
        System.out.println("\n>>> " + baslik);
        try {
            r.run();
        } catch (Exception e) {
            System.err.println("Hata: " + e.getMessage());
        }
    }

    /** main() throws InterruptedException olan adımlar için sarmalayıcı. */
    private static void runMain(ThrowingRunnable r) {
        try {
            r.run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FunctionalInterface
    private interface ThrowingRunnable {
        void run() throws Exception;
    }
}
