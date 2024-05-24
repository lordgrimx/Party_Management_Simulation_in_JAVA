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

## About the Project 

This project simulates a party scenario where a waiter, hired from a catering company, serves various food and drinks to eight guests. The project includes consumable items such as pastries, cake, and drinks, with each guest consuming these items in specific amounts.

### Features

- **Varieties of Food and Drinks:** 30 pastries, 15 slices of cake, and 30 glasses of drink
- **Tray Capacity:** Each tray can hold up to 5 items
- **Guest Consumption Limits:** Each guest can consume a maximum of 4 pastries, 4 drinks, and 2 slices of cake
- **Waiter:** Continuously monitors and refills the trays as needed
## Table of Contents

- [About the Project](#about-the-project)
- [Featuresr](#features)
- [Project Structure](#project-structure)
  - [Main Files](#main-files)
  - [Methods Used](#methods-used)
- [Code Explanation](#code-explanation)
  - [food_tray.java](#food_trayjava)
  - [waiter.java](#waiterjava)
- [Running the Project](#running-the-project)
- [Results](#results)
- [References](#references)
## Project Structure

### Main Files

- `food_tray.java`: Class representing the food trays.
- `waiter.java`: Class representing the waiter and the serving processes.

### Methods Used

- **Multithreading:** Each guest and the waiter run as separate threads.
- **Synchronization:** Lock mechanism is used to ensure data integrity during food and drink consumption.

## Code Explanation

### food_tray.java

This class manages the capacity and the current amount of each tray.

- **Variables:**
  - `capacity`: Total capacity of the tray
  - `quantity`: Current amount of food/drinks in the tray

- **Methods:**
  - `getCapacity()`: Returns the capacity of the tray.
  - `setCapacity(int capacity)`: Sets the capacity of the tray.
  - `getQuantity()`:  Returns the current amount in the tray.
  - `setQuantity(int quantity)`: Sets the current amount in the tray.

### waiter.java

This class manages the waiter and the food/drink serving processes.

- **Variables:**
  - `totalBorek`, `totalCake`, `totalDrink`: Initial total amounts of food/drinks.
  - `borekTray`, `cakeTray`, `drinkTray`: Objects representing the food and drink trays.
  - `borekEaten`, `cakeEaten`, `drinkEaten`: Arrays tracking the amount of food/drinks consumed by each guest.
- **Methods:**
  - `reFillTray()`: Refills the tray.
  - `ServeBorek()`, `ServeCake()`, `ServeDrink()`: Serves food/drink to a guest.
  - `checkServe()`: Checks and refills the trays as needed.
  - `main()`: Entry point of the program, starts the threads and manages the processes.
## Running the Project

To run the project, follow these steps:

1. Download the food_tray.java and waiter.java files and place them in the same directory.
2. Open a command line and navigate to the project directory.
3.Compile and run the files using the following commands:
   ```sh
   javac food_tray.java waiter.java
   java waiter
## Results

Upon running the code, it will be observed that each guest consumes food and drinks within the specified limits, and the waiter refills the trays as needed. The synchronization mechanism will ensure correct operation and data integrity.

## References

- [W3Schools Java Threads](https://www.w3schools.com/java/java_threads.asp)
- [Medium Blog](https://umitsamimi.medium.com/java-threads-980347735de1)
- [YouTube Tutorials](https://www.youtube.com/watch?v=JEJdQN0mcG4)
- [Dining Philosopher GitHub](https://github.com/rupakraj/dining-philosopher)
- [Dining Philosophers GUI GitHub](https://github.com/Ankit512/Dining-Philosophers-GUI)

