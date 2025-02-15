public class SoftmaxTopluTasima {

    // Mahalle isimleri
    private static final String[] MAHALLELER = {"Mahalle A", "Mahalle B", "Mahalle C"};

    // Kriterler için ağırlıklar
    private static final double[] AGIRLIKLAR = {0.30, 0.20, 0.20, 0.15, 0.15};

    // Mahallelerin kriter değerleri
    private static final double[][] KRITERLER = {
            {5000 / 1000.0, 7, 10, 8, 9}, // Mahalle A
            {7000 / 1000.0, 5, 15, 6, 7}, // Mahalle B
            {4000 / 1000.0, 8, 12, 9, 8}  // Mahalle C
    };

    // Softmax fonksiyonu
    private static double[] softmax(double[] skorlar) {
        double[] olasiliklar = new double[skorlar.length];
        double toplam = 0.0;

        // En büyük skoru bul
        double maxSkor = skorlar[0];
        for (double skor : skorlar) {
            if (skor > maxSkor) {
                maxSkor = skor;
            }
        }

        // Üstel değerleri hesapla ve toplamı bul
        for (int i = 0; i < skorlar.length; i++) {
            olasiliklar[i] = Math.exp(skorlar[i] - maxSkor);
            toplam += olasiliklar[i];
        }

        // Olasılıkları normalize et
        for (int i = 0; i < skorlar.length; i++) {
            olasiliklar[i] /= toplam;
        }

        return olasiliklar;
    }

    public static void main(String[] args) {
        double[] skorlar = new double[MAHALLELER.length];

        // Her mahalle için skor hesapla
        for (int i = 0; i < MAHALLELER.length; i++) {
            for (int j = 0; j < AGIRLIKLAR.length; j++) {
                skorlar[i] += KRITERLER[i][j] * AGIRLIKLAR[j];
            }
        }

        // Softmax uygula
        double[] olasiliklar = softmax(skorlar);

        // Sonuçları ekrana yazdır
        System.out.println("Mahallelerin Seçilme Olasılıkları:");
        for (int i = 0; i < MAHALLELER.length; i++) {
            System.out.printf("%s: %.2f%%\n", MAHALLELER[i], olasiliklar[i] * 100);
        }

        // En uygun mahalleyi bul
        int enUygunIndex = 0;
        for (int i = 1; i < MAHALLELER.length; i++) {
            if (olasiliklar[i] > olasiliklar[enUygunIndex]) {
                enUygunIndex = i;
            }
        }
        System.out.printf("\nEn uygun mahalle: %s (%.2f%% olasılıkla)\n", MAHALLELER[enUygunIndex], olasiliklar[enUygunIndex] * 100);

        // Maliyet-fayda analizi
        System.out.println("\nMaliyet-Fayda Analizi:");
        for (int i = 0; i < MAHALLELER.length; i++) {
            double maliyet = KRITERLER[i][2]; // Maliyet değeri
            double fayda = skorlar[i]; // Fayda değeri (skor)
            System.out.printf("%s - Maliyet: %.2f, Fayda: %.2f\n", MAHALLELER[i], maliyet, fayda);
        }
    }
}