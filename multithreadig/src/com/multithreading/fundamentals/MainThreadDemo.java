package com.multithreading.fundamentals;

/**
 * Main thread kavramı: JVM uygulamayı başlattığında oluşturulan ilk thread.
 * Thread.currentThread() ile hangi thread'de çalıştığımızı öğreniriz.
 */
public final class MainThreadDemo {

    public static void main(String[] args) {
        System.out.println("=== Main Thread ===\n");

        Thread main = Thread.currentThread();
        System.out.println("Mevcut thread: " + main);
        System.out.println("  İsim: " + main.getName());
        System.out.println("  ID: " + main.getId());
        System.out.println("  Öncelik: " + main.getPriority());
        System.out.println("  Daemon: " + main.isDaemon());

        System.out.println("\nmain() bu bilgileri veren thread'de çalışıyor — yani 'main' thread.");
    }
}
