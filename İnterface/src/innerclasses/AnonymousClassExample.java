package innerclasses;

/**
 * Anonymous class: isimsiz, tek kullanımlık (Runnable).
 * Aynı senaryo lambda ile de yazılabilir.
 */
public class AnonymousClassExample {

    public static void runWithRunnable() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Runnable çalıştı.");
            }
        };
        r.run();
    }

    public static void runWithLambda() {
        Runnable r = () -> System.out.println("Lambda Runnable çalıştı.");
        r.run();
    }
}
