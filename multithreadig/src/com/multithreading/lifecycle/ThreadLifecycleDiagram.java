package com.multithreading.lifecycle;

/**
 * Thread yaşam döngüsü akışı — açıklama amaçlı.
 * getState() değerleri: NEW -> RUNNABLE <-> BLOCKED | WAITING | TIMED_WAITING -> TERMINATED
 */
public final class ThreadLifecycleDiagram {

    public static void main(String[] args) {
        printLifecycleExplanation();
    }

    private static void printLifecycleExplanation() {
        System.out.println("=== Thread Yaşam Döngüsü ===\n");

        System.out.println("  [NEW]");
        System.out.println("    | new Thread(...)");
        System.out.println("    v");
        System.out.println("  [RUNNABLE]  <-- start() sonrası; çalışıyor veya çalışmaya hazır (scheduler)");
        System.out.println("    |");
        System.out.println("    |-- synchronized beklerken  -> [BLOCKED]");
        System.out.println("    |-- wait() çağrısı           -> [WAITING]");
        System.out.println("    |-- sleep(ms), wait(ms)     -> [TIMED_WAITING]");
        System.out.println("    |");
        System.out.println("    v run() bitince");
        System.out.println("  [TERMINATED]\n");

        System.out.println("BLOCKED  -> lock serbest kalınca RUNNABLE'a döner.");
        System.out.println("WAITING  -> notify/notifyAll ile RUNNABLE'a döner.");
        System.out.println("TIMED_WAITING -> süre dolunca veya interrupt ile RUNNABLE'a döner.");
    }
}
