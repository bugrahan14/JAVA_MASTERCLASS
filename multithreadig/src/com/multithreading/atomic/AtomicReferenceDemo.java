package com.multithreading.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * AtomicReference: Referansın atomik güncellenmesi (ör. basit state makinesi).
 * compareAndSet ile lock-free state geçişi.
 */
public final class AtomicReferenceDemo {

    private enum State {
        IDLE,
        RUNNING,
        DONE
    }

    private final AtomicReference<State> state = new AtomicReference<>(State.IDLE);

    public static void main(String[] args) throws InterruptedException {
        AtomicReferenceDemo demo = new AtomicReferenceDemo();
        demo.runDemo();
    }

    private void runDemo() throws InterruptedException {
        System.out.println("=== AtomicReference ===\n");

        System.out.println("Başlangıç: " + state.get());

        Thread t = new Thread(() -> {
            transition(State.IDLE, State.RUNNING);
            System.out.println("Çalışıyor: " + state.get());
            sleepQuietly(100);
            transition(State.RUNNING, State.DONE);
        });
        t.start();
        t.join();

        System.out.println("Son: " + state.get());
    }

    private void transition(State expected, State newState) {
        boolean ok = state.compareAndSet(expected, newState);
        if (!ok) {
            throw new IllegalStateException("Beklenen " + expected + " ama " + state.get());
        }
    }

    private static void sleepQuietly(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
