package temel;

/**
 * Metod çağırma: Aynı sınıf içinden, static ve instance metod örnekleri.
 */
public class MetodCagirma {

    public static void main(String[] args) {
        // Static metod: Sınıf adıyla çağrılır
        Yardimci.selamla();

        // Aynı sınıf içinden static metod
        ekranaYaz("Aynı sınıftan çağrı");

        // Instance metod: Nesne oluşturup çağırırız
        MetodCagirma ornek = new MetodCagirma();
        ornek.instanceSelamla();
    }

    public static void ekranaYaz(String mesaj) {
        System.out.println(mesaj);
    }

    public void instanceSelamla() {
        System.out.println("Instance metod çalıştı.");
    }
}

class Yardimci {
    public static void selamla() {
        System.out.println("Yardimci sınıfından selam!");
    }
}
