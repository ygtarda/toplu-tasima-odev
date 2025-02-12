# Softmax ile Toplu Taşıma Planlaması

Bu proje, Kırklareli'nin üç farklı mahallesi için en uygun toplu taşıma hattını belirlemek amacıyla Softmax algoritmasını kullanmaktadır. Projede belirli kriterler ağırlıklandırılarak en uygun mahalle seçimi yapılmaktadır.

## 📌 Proje Açıklaması

Bu çalışma, aşağıdaki kriterleri değerlendirerek en uygun mahalleyi seçmektedir:

- **Nüfus Yoğunluğu**
- **Mevcut Ulaşım Altyapısı**
- **Maliyet Analizi**
- **Çevresel Etki**
- **Sosyal Fayda**

Kriterler belirli ağırlıklarla çarpılarak her mahalle için toplam skor hesaplanmaktadır. Daha sonra **Softmax fonksiyonu** uygulanarak mahallelerin seçilme olasılıkları hesaplanmaktadır.

## 🚀 Kullanılan Teknolojiler

- **Java** (Softmax hesaplamaları ve konsol çıktısı için)
- **Matematiksel Modelleme** (Softmax fonksiyonu ve ağırlıklı ortalama hesaplamaları)

## 🔧 Kurulum ve Çalıştırma

1. **Projeyi Klonlayın**
   ```bash
   git clone https://github.com/kullaniciadi/softmax-toplu-tasima.git
   cd softmax-toplu-tasima
   ```
2. **Java Derleme ve Çalıştırma**
   ```bash
   javac SoftmaxTopluTasima.java
   java SoftmaxTopluTasima
   ```
3. **Sonuçlar Konsola Yazdırılacaktır.**

## 📊 Örnek Çıktı

```
Mahallelerin Seçilme Olasılıkları:
Mahalle A: 40.25%
Mahalle B: 35.12%
Mahalle C: 24.63%

En uygun mahalle: Mahalle A (40.25% olasılıkla)
```

## 📽️ Video Açıklaması

Bu projenin nasıl çalıştığını ve Softmax algoritmasının nasıl uygulandığını anlatan video bağlantısını buraya ekleyiniz.

