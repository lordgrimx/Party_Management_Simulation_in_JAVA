# Party Management Simulation

## Proje Hakkında | [English](#about-the-project) | [Turkish](#proje-hakkında)

Bu proje, bir catering şirketinden kiralanan bir garsonun sekiz misafire çeşitli yiyecek ve içecek servis ettiği bir parti senaryosunu simüle eder. Projede börek, pasta ve içecek gibi tüketilebilir maddeler yer almakta olup, her bir misafir belirli miktarlarda bu maddelerden tüketmektedir.

### Özellikler

- **Yiyecek ve İçecek Çeşitleri:** 30 börek, 15 dilim pasta ve 30 bardak içecek
- **Tepsi Kapasitesi:** Her tepside 5 adet ürün
- **Misafir Tüketim Sınırları:** Her misafir maksimum 4 börek, 4 içecek ve 2 dilim pasta tüketebilir
- **Garson:** Tepsilerdeki yiyecek ve içecek miktarını sürekli kontrol eder ve tepsileri gerekli olduğunda doldurur
## İçindekiler

- [Proje Hakkında](#proje-hakkında)
- [Özellikler](#özellikler)
- [Proje Yapısı](#proje-yapısı)
  - [Ana Dosyalar](#ana-dosyalar)
  - [Kullanılan Yöntemler](#kullanılan-yöntemler)
- [Kod Açıklamaları](#kod-açıklamaları)
  - [food_tray.java](#food_trayjava)
  - [waiter.java](#waiterjava)
- [Çalıştırma](#çalıştırma)
- [Sonuçlar](#sonuçlar)
- [Referanslar](#referanslar)
## Proje Yapısı

### Ana Dosyalar

- `food_tray.java`: Yiyecek tepsilerini temsil eden sınıf.
- `waiter.java`: Garsonu ve servis süreçlerini temsil eden sınıf.

### Kullanılan Yöntemler

- **Çoklu İş Parçacığı (Multithreading):** Her misafir ve garson ayrı iş parçacıkları olarak çalışır.
- **Senkronizasyon (Synchronization):** Yiyecek ve içecek tüketiminde veri bütünlüğünü sağlamak için kilit mekanizması kullanılır.

## Kod Açıklamaları

### food_tray.java

Bu sınıf, her bir tepsinin kapasitesini ve mevcut miktarını yönetir.

- **Değişkenler:**
  - `capacity`: Tepsinin toplam kapasitesi
  - `quantity`: Tepsideki mevcut yiyecek/içecek miktarı

- **Yöntemler:**
  - `getCapacity()`: Tepsinin kapasitesini döndürür.
  - `setCapacity(int capacity)`: Tepsinin kapasitesini ayarlar.
  - `getQuantity()`: Tepsideki mevcut miktarı döndürür.
  - `setQuantity(int quantity)`: Tepsideki mevcut miktarı ayarlar.

### waiter.java

Bu sınıf, garsonu ve onun yiyecek/içecek servis etme işlemlerini yönetir.

- **Değişkenler:**
  - `totalBorek`, `totalCake`, `totalDrink`: Garsonun başlangıçtaki toplam yiyecek/içecek miktarları.
  - `borekTray`, `cakeTray`, `drinkTray`: Yiyecek ve içecek tepsilerini temsil eden nesneler.
  - `borekEaten`, `cakeEaten`, `drinkEaten`: Her bir misafirin tükettiği yiyecek/içecek miktarlarını takip eden diziler.

- **Yöntemler:**
  - `reFillTray()`: Tepsiyi doldurur.
  - `ServeBorek()`, `ServeCake()`, `ServeDrink()`: Misafire yiyecek/içecek servis eder.
  - `checkServe()`: Tepsileri kontrol eder ve gerektiğinde doldurur.
  - `main()`: Programın başlangıç noktası, iş parçacıklarını başlatır ve işlemleri yönetir.

## Çalıştırma

Projeyi çalıştırmak için aşağıdaki adımları izleyin:

1. `food_tray.java` ve `waiter.java` dosyalarını indirip aynı klasöre koyun.
2. Komut satırını açın ve proje klasörüne gidin.
3. Aşağıdaki komutları kullanarak dosyaları derleyin ve çalıştırın:
   ```sh
   javac food_tray.java waiter.java
   java waiter
## Sonuçlar

Kodun çalıştırılması sonucunda, her misafirin belirlenen sınırlar içinde yiyecek ve içecek tükettiği ve garsonun tepsileri gerektiğinde doldurduğu gözlemlenecektir. Senkronizasyon mekanizmasının doğru çalıştığı ve veri bütünlüğünün sağlandığı görülecektir.

## Referanslar

- [W3Schools Java Threads](https://www.w3schools.com/java/java_threads.asp)
- [Medium Blog](https://umitsamimi.medium.com/java-threads-980347735de1)
- [YouTube Tutorials](https://www.youtube.com/watch?v=JEJdQN0mcG4)
- [Dining Philosopher GitHub](https://github.com/rupakraj/dining-philosopher)
- [Dining Philosophers GUI GitHub](https://github.com/Ankit512/Dining-Philosophers-GUI)
