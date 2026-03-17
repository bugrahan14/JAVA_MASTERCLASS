package com.multithreading.lifecycle;

/**
 * Thread.getState() ile thread durumları: NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED.
 * Her durum kısa bir örnekle gösterilir.
 */
public final class ThreadStatesDemo {

    private static final Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Thread Durumları (getState()) ===\n");

        demonstrateNew();
        demonstrateRunnableAndTerminated();
        demonstrateBlocked();
        demonstrateTimedWaiting();
        demonstrateWaiting();
    }

    private static void demonstrateNew() {
        Thread t = new Thread(() -> {});
        System.out.println("NEW: start() öncesi -> " + t.getState());
    }

    private static void demonstrateRunnableAndTerminated() throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        System.out.println("Başlamadan önce: " + t.getState());
        t.start();
        Thread.sleep(50);
        System.out.println("Çalışırken (RUNNABLE): " + t.getState());
        t.join();
        System.out.println("Bittikten sonra (TERMINATED): " + t.getState() + "\n");
    }

    private static void demonstrateBlocked() throws InterruptedException {
        Thread holder = new Thread(() -> {
            synchronized (LOCK) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        holder.start();
        Thread.sleep(50);

        Thread waiter = new Thread(() -> {
            synchronized (LOCK) {
                // lock'u alır, sonra bırakır
            }
        });
        waiter.start();
        Thread.sleep(50);
        System.out.println("Lock beklerken (BLOCKED): " + waiter.getState());
        holder.join();
        waiter.join();
        System.out.println();
    }

    private static void demonstrateTimedWaiting() throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        t.start();
        Thread.sleep(50);
        System.out.println("sleep() sırasında (TIMED_WAITING): " + t.getState());
        t.join();
        System.out.println();
    }

    private static void demonstrateWaiting() throws InterruptedException {
        Thread t = new Thread(() -> {
            synchronized (LOCK) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        t.start();
        Thread.sleep(100);
        System.out.println("wait() sırasında (WAITING): " + t.getState());
        synchronized (LOCK) {
            LOCK.notify();
        }
        t.join();
        System.out.println();
    }
}
