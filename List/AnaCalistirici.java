/**
 * Tüm Array, List, ArrayList ve LinkedList örneklerini sırayla çalıştırır.
 * Derleme: javac *.java
 * Çalıştırma: java AnaCalistirici
 */
public class AnaCalistirici {

    public static void main(String[] args) {
        System.out.println("========== JAVA ARRAY, LİST, ARRAYLİST, LİNKEDLİST - UYGULAMALI REHBER ==========");

        System.out.println("\n" + "=".repeat(60) + "\n>>> ARRAY TEMEL VE ÖRNEKLER\n" + "=".repeat(60));
        ArrayTemelVeOrnekler.temelTanımlamaVeErisim();
        ArrayTemelVeOrnekler.dongulerVeCokBoyutlu();
        ArrayTemelVeOrnekler.yayginIslemler();
        ArrayTemelVeOrnekler.sinirlamalarVeMotivasyon();

        System.out.println("\n" + "=".repeat(60) + "\n>>> LİST ARAYÜZÜ VE ARRAYLİST\n" + "=".repeat(60));
        ListArayuzuVeArrayList.listArayuzuVeArrayListTemel();
        ListArayuzuVeArrayList.baslangicDegerleri();
        ListArayuzuVeArrayList.pratikOrnekler();
        ListArayuzuVeArrayList.bestPracticeOrnekleri();

        System.out.println("\n" + "=".repeat(60) + "\n>>> LİNKEDLİST ÖRNEKLER\n" + "=".repeat(60));
        LinkedListOrnekler.listOlarakKullanım();
        LinkedListOrnekler.queueVeDequeOrnekleri();
        LinkedListOrnekler.arrayListVsLinkedList();

        System.out.println("\n" + "=".repeat(60) + "\n>>> KARŞILAŞTIRMA VE BEST PRACTICES\n" + "=".repeat(60));
        KarsilastirmaVeBestPractices.ozetTabloyuYazdir();
        KarsilastirmaVeBestPractices.bestPracticesOzeti();

        System.out.println("\n========== TÜM ÖRNEKLER TAMAMLANDI ==========");
    }
}
