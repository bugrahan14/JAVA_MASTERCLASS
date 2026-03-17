package com.multithreading.bestpractices;

/**
 * Thread, Runnable ve lock isimlendirme; paket ve sınıf yapısı önerileri.
 * Clean code: Anlamlı isimler, tek sorumluluk, tutarlı paket hiyerarşisi.
 */
public final class NamingAndStructure {

    public static void main(String[] args) {
        printGuidelines();
    }

    private static void printGuidelines() {
        System.out.println("=== İsimlendirme ve Yapı ===\n");

        System.out.println("THREAD / RUNNABLE:");
        System.out.println("  - new Thread(runnable, \"Worker-1\") — thread'e anlamlı isim verin.");
        System.out.println("  - Runnable: TaskFromDatabase, ImageProcessor — ne yaptığı belli olsun.\n");

        System.out.println("LOCK / MONITOR:");
        System.out.println("  - private final Object accountLock = new Object();");
        System.out.println("  - private final ReentrantLock cacheLock = new ReentrantLock();\n");

        System.out.println("PAKET YAPISI:");
        System.out.println("  - com.multithreading.fundamentals  — temel kavramlar");
        System.out.println("  - com.multithreading.synchronization — kilit, race condition");
        System.out.println("  - com.multithreading.executors    — thread pool, görev yönetimi");
        System.out.println("  - com.multithreading.coordination  — latch, barrier, semaphore\n");

        System.out.println("SINIF:");
        System.out.println("  - Her sınıf tek kavram (örn. sadece deadlock örneği).");
        System.out.println("  - Demo/örnek sınıfları *Demo, *Example ile bitirebilir.");
    }
}
