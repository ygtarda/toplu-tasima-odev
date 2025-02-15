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



## 📊 Örnek Çıktı

```
Mahallelerin Seçilme Olasılıkları:
Mahalle A: 23,97%
Mahalle B: 43,68%
Mahalle C: 32,36%

En uygun mahalle: Mahalle B (43,68% olasılıkla)

Maliyet-Fayda Analizi:
Mahalle A - Maliyet: 10,00, Fayda: 7,45
Mahalle B - Maliyet: 15,00, Fayda: 8,05
Mahalle C - Maliyet: 12,00, Fayda: 7,75
```

