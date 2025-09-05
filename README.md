# Data Design Bank Account System

Bu proje, bir banka hesabının aylık hareketlerini ve politikalarını modelleyen nesne yönelimli bir Java sistemidir. Hesap bakiyesi, işlemler, faiz ve ücret politikaları modüler olarak tanımlanmıştır.

## Genel Yapı

### Ana Sınıflar
- **Account**: Banka hesabını temsil eder. Para yatırma, çekme ve ay kapama işlemlerini yönetir.
- **Ledger**: Hesaba ait tüm işlemleri (`Transaction`) tutar.
- **Transaction**: Tek bir işlemi (tarih, tip, tutar, açıklama) temsil eder.
- **TxType**: İşlem tiplerini tanımlar (DEPOSIT, WITHDRAWAL, INTEREST, FEE).
- **MonthlyStatement**: Bir ayın özetini tutar: açılış/kapanış bakiyesi, faiz, ücret ve işlemler.
- **AccountSnapshot**: Hesabın bir ay sonundaki özetini tutar; faiz ve ücret hesaplamalarında kullanılır.

### Politika Arayüzleri ve Uygulamaları
- **FeePolicy & InterestPolicy**: Hesaba uygulanacak ücret ve faiz hesaplama stratejileri için arayüzler.
- **NoFeePolicy**: Hiçbir ücret uygulamaz.
- **FixedFeePolicy**: Sabit bir ücret uygular.
- **SimpleInterestPolicy**: Sabit oranlı faiz uygular.

### Paket Yapısı
- `interfaces`: Politika arayüzleri (`FeePolicy`, `InterestPolicy`)
- `accountSnap`: Hesap özetini tutan sınıf (`AccountSnapshot`)
- Ana dizin: Hesap, işlem, defter ve politika uygulamaları.

### Veri Tipleri
- Tüm parasal işlemler için hassasiyet ve doğruluk amacıyla `BigDecimal` kullanılmıştır.

## Akış Özeti
1. Hesap açılırken ücret ve faiz politikaları belirlenir.
2. Para yatırma/çekme işlemleri kaydedilir.
3. Ay sonunda `closeMonth` ile faiz ve ücretler hesaplanır, bakiyeye uygulanır ve ayın özeti (`MonthlyStatement`) oluşturulur.

## Güçlü Yanlar
- Esnek politika sistemi (farklı ücret/faiz stratejileri kolayca eklenebilir).
- Tüm parasal işlemler için güvenli tip (`BigDecimal`).
- Temiz ve modüler nesne yönelimli tasarım.

---

Daha fazla bilgi veya örnek kullanım için kodu inceleyebilirsiniz.
