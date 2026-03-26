package com.example.lambda;

/**
 * Tüm örnekleri sırayla çalıştıran giriş noktası.
 */
public final class Main {

    public static void main(String[] args) {
        System.out.println("=== TemelLambda ===");
        TemelLambda.ornekleriCalistir();

        System.out.println("\n=== YerlesikFonksiyonelTurler ===");
        YerlesikFonksiyonelTurler.ornekleriCalistir();

        System.out.println("\n=== MethodReferenceDemo ===");
        MethodReferenceDemo.ornekleriCalistir();

        System.out.println("\n=== LambdaVeStreams ===");
        LambdaVeStreams.ornekleriCalistir();

        System.out.println("\n=== TemizKodPrensipleri ===");
        TemizKodPrensipleri.ornekleriCalistir();
    }
}
