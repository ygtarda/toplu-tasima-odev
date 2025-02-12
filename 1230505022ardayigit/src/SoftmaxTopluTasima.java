public class SoftmaxTopluTasima {

    // Burada üç farklı mahalle tanımlanıyor.
    private static final String[] MAHALLELER = {"Mahalle A", "Mahalle B", "Mahalle C"};

    // Mahalleleri değerlendirmek için belirlenen kriterlerin ağırlıkları.
    // Örneğin, nüfusun ağırlığı %30, ulaşımın ağırlığı %20 gibi belirlenmiş.
    private static final double[] AGIRLIKLAR = {0.30, 0.20, 0.20, 0.15, 0.15};

    // Mahallelere ait kriter değerleri. Örneğin, nüfus, ulaşım, maliyet gibi faktörler.
    // Nüfus 1000'e bölünerek normalize edilmiştir.
    private static final double[][] KRITERLER = {
            {5000 / 1000.0, 7, 10, 8, 9},
            {7000 / 1000.0, 5, 15, 6, 7},
            {4000 / 1000.0, 8, 12, 9, 8}
    };

    // Softmax fonksiyonu, verilen skorları olasılığa çevirerek bir mahalle seçim modeli oluşturuyor.
    private static double[] softmax(double[] skorlar) {
        double[] olasiliklar = new double[skorlar.length];
        double toplam = 0.0;

        // En büyük skoru buluyoruz. Bu, sayısal kararlılığı artırmak için yapılıyor.
        double maxSkor = skorlar[0];
        for (double skor : skorlar) {
            if (skor > maxSkor) {
                maxSkor = skor;
            }
        }

        // Softmax formülüne uygun şekilde üstel (exponential) değerleri hesaplıyoruz.
        for (int i = 0; i < skorlar.length; i++) {
            olasiliklar[i] = Math.exp(skorlar[i] - maxSkor); // Normalizasyon yapılıyor.
            toplam += olasiliklar[i];
        }

        // Olasılıkları 0-1 arasında normalize ediyoruz.
        for (int i = 0; i < skorlar.length; i++) {
            olasiliklar[i] /= toplam;
        }

        return olasiliklar;
    }

    public static void main(String[] args) {
        double[] skorlar = new double[MAHALLELER.length];

        // Her mahalle için skor hesaplanıyor.
        // Her kriterin ağırlık katsayısı ile çarpımı yapılıyor ve toplam skor elde ediliyor.
        for (int i = 0; i < MAHALLELER.length; i++) {
            for (int j = 0; j < AGIRLIKLAR.length; j++) {
                skorlar[i] += KRITERLER[i][j] * AGIRLIKLAR[j];
            }
        }

        // Softmax fonksiyonunu çağırarak skorlardan olasılıklar elde ediyoruz.
        double[] olasiliklar = softmax(skorlar);

        // Mahallelere ait olasılıkları ekrana yazdırıyoruz.
        System.out.println("Mahallelerin Seçilme Olasılıkları:");
        for (int i = 0; i < MAHALLELER.length; i++) {
            System.out.printf("%s: %.2f%%\n", MAHALLELER[i], olasiliklar[i] * 100);
        }

        // En yüksek olasılığa sahip mahalleyi buluyoruz.
        int enUygunIndex = 0;
        for (int i = 1; i < MAHALLELER.length; i++) {
            if (olasiliklar[i] > olasiliklar[enUygunIndex]) {
                enUygunIndex = i;
            }
        }

        // En uygun mahalleyi ekrana yazdırıyoruz.
        System.out.printf("\nEn uygun mahalle: %s (%.2f%% olasılıkla)\n", MAHALLELER[enUygunIndex], olasiliklar[enUygunIndex] * 100);
    }
}
