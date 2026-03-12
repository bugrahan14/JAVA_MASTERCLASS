package interfaces;

/**
 * Interface örnekleri: temel kullanım, default/static metotlar, functional interface.
 */
public class InterfacesDemo {

    public static void main(String[] args) {
        Reportable pdf = new PdfReport("PDF Rapor", "Bu raporun uzun içeriği burada yer alır.");
        Reportable console = new ConsoleReport("Konsol", "Kısa metin");

        System.out.println("--- Temel Reportable ---");
        printReport(pdf);
        printReport(console);

        System.out.println("--- Default getSummary ---");
        System.out.println(pdf.getSummary());
        System.out.println(console.getSummary());

        System.out.println("--- Static empty ---");
        Reportable empty = Reportable.empty("Boş Rapor");
        printReport(empty);

        System.out.println("--- Functional interface (Formatter) + lambda ---");
        Formatter upper = s -> s.toUpperCase();
        Formatter lower = String::toLowerCase;
        String word = "Merhaba";
        System.out.println(upper.format(word));
        System.out.println(lower.format(word));
    }

    private static void printReport(Reportable report) {
        System.out.println(report.getTitle() + " | " + report.getContent());
    }
}
