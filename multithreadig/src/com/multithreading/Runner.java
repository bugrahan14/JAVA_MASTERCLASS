package com.multithreading;

import com.multithreading.fundamentals.ProcessVsThread;
import com.multithreading.fundamentals.ThreadCreation;
import com.multithreading.fundamentals.MainThreadDemo;
import com.multithreading.fundamentals.DaemonThreadDemo;
import com.multithreading.lifecycle.ThreadStatesDemo;
import com.multithreading.lifecycle.ThreadLifecycleDiagram;
import com.multithreading.synchronization.RaceConditionExample;
import com.multithreading.synchronization.SynchronizedCounter;
import com.multithreading.synchronization.SynchronizedBlockExample;
import com.multithreading.synchronization.DeadlockExample;
import com.multithreading.synchronization.DeadlockPrevention;
import com.multithreading.visibility.VisibilityProblemDemo;
import com.multithreading.visibility.VolatileFlagDemo;

import tutorial.TutorialRunner;

import com.multithreading.executors.ExecutorServiceBasics;
import com.multithreading.executors.ThreadPoolTypes;
import com.multithreading.executors.CallableAndFuture;
import com.multithreading.executors.ScheduledExecutorDemo;
import com.multithreading.concurrentcollections.ConcurrentHashMapDemo;
import com.multithreading.concurrentcollections.BlockingQueueDemo;
import com.multithreading.concurrentcollections.CopyOnWriteArrayListDemo;
import com.multithreading.locks.ReentrantLockExample;
import com.multithreading.locks.ReadWriteLockExample;
import com.multithreading.locks.TryLockExample;
import com.multithreading.atomic.AtomicIntegerDemo;
import com.multithreading.atomic.AtomicReferenceDemo;
import com.multithreading.coordination.WaitNotifyDemo;
import com.multithreading.coordination.CountDownLatchDemo;
import com.multithreading.coordination.CyclicBarrierDemo;
import com.multithreading.coordination.SemaphoreDemo;
import com.multithreading.bestpractices.NamingAndStructure;
import com.multithreading.bestpractices.AvoidingSharedMutableState;
import com.multithreading.bestpractices.ResourceCleanup;
import com.multithreading.bestpractices.SummaryChecklist;

/**
 * Tüm Java Multithreading & Concurrency demo sınıflarını sırayla çalıştırır.
 * Önce tutorial (0'dan anlatım), sonra diğer modüller.
 */
public final class Runner {

    public static void main(String[] args) {
        System.out.println("\n********** JAVA MULTITHREADING & CONCURRENCY - TAM DEMO **********\n");

        run("Tutorial (0'dan tek tek)", () -> runMain(() -> TutorialRunner.main(args)));

        run("Process vs Thread", () -> ProcessVsThread.main(args));
        run("Thread oluşturma (Runnable vs extend)", () -> runMain(() -> ThreadCreation.main(args)));
        run("Main thread", () -> MainThreadDemo.main(args));
        run("Daemon thread", () -> runMain(() -> DaemonThreadDemo.main(args)));

        run("Thread durumları", () -> runMain(() -> ThreadStatesDemo.main(args)));
        run("Thread yaşam döngüsü", () -> ThreadLifecycleDiagram.main(args));

        run("Race condition", () -> runMain(() -> RaceConditionExample.main(args)));
        run("Synchronized sayaç", () -> runMain(() -> SynchronizedCounter.main(args)));
        run("Synchronized blok", () -> runMain(() -> SynchronizedBlockExample.main(args)));
        run("Deadlock örneği", () -> runMain(() -> DeadlockExample.main(args)));
        run("Deadlock önleme", () -> runMain(() -> DeadlockPrevention.main(args)));

        run("Görünürlük sorunu", () -> runMain(() -> VisibilityProblemDemo.main(args)));
        run("volatile ile görünürlük", () -> runMain(() -> VolatileFlagDemo.main(args)));

        run("ExecutorService temelleri", () -> runMain(() -> ExecutorServiceBasics.main(args)));
        run("Thread pool türleri", () -> runMain(() -> ThreadPoolTypes.main(args)));
        run("Callable ve Future", () -> CallableAndFuture.main(args));
        run("ScheduledExecutor", () -> runMain(() -> ScheduledExecutorDemo.main(args)));

        run("ConcurrentHashMap", () -> runMain(() -> ConcurrentHashMapDemo.main(args)));
        run("BlockingQueue", () -> runMain(() -> BlockingQueueDemo.main(args)));
        run("CopyOnWriteArrayList", () -> runMain(() -> CopyOnWriteArrayListDemo.main(args)));

        run("ReentrantLock", () -> runMain(() -> ReentrantLockExample.main(args)));
        run("ReadWriteLock", () -> runMain(() -> ReadWriteLockExample.main(args)));
        run("tryLock", () -> runMain(() -> TryLockExample.main(args)));

        run("AtomicInteger", () -> runMain(() -> AtomicIntegerDemo.main(args)));
        run("AtomicReference", () -> runMain(() -> AtomicReferenceDemo.main(args)));

        run("wait/notify", () -> runMain(() -> WaitNotifyDemo.main(args)));
        run("CountDownLatch", () -> runMain(() -> CountDownLatchDemo.main(args)));
        run("CyclicBarrier", () -> runMain(() -> CyclicBarrierDemo.main(args)));
        run("Semaphore", () -> runMain(() -> SemaphoreDemo.main(args)));

        run("İsimlendirme ve yapı", () -> NamingAndStructure.main(args));
        run("Paylaşılan durumdan kaçınma", () -> AvoidingSharedMutableState.main(args));
        run("Kaynak temizliği", () -> runMain(() -> ResourceCleanup.main(args)));
        run("Özet checklist", () -> SummaryChecklist.main(args));

        System.out.println("\n********** DEMO TAMAMLANDI **********\n");
    }

    private static void run(String name, Runnable r) {
        System.out.println("\n>>> " + name);
        try {
            r.run();
        } catch (Exception e) {
            System.err.println("Hata: " + e.getMessage());
        }
    }

    /** main() throws InterruptedException olan demolar için sarmalayıcı. */
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
