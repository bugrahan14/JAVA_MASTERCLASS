package overloading;

/**
 * Method overloading: Aynı isim, farklı parametre listesi (tip veya sayı).
 */
public class OverloadingOrnekleri {

    public static void main(String[] args) {
        System.out.println(topla(2, 3));           // int, int
        System.out.println(topla(2.5, 3.5));       // double, double
        System.out.println(topla(1, 2, 3));         // üç parametre
        System.out.println(topla(1, 2, 3, 4));     // varargs
    }

    public static int topla(int a, int b) {
        return a + b;
    }

    public static double topla(double a, double b) {
        return a + b;
    }

    public static int topla(int a, int b, int c) {
        return a + b + c;
    }

    /** Varargs: 0 veya daha fazla int. */
    public static int topla(int... sayilar) {
        int toplam = 0;
        for (int s : sayilar) {
            toplam += s;
        }
        return toplam;
    }
}
