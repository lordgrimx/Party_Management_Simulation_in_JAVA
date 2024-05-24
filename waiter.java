package homework;

import java.util.Arrays;


public class waiter extends Thread{
  // declare the totals foods
  private int totalBorek; 
  private int totalCake;
  private int totalDrink;
  // create instance from food_tray class for trays
  food_tray cakeTray;
  food_tray drinkTray;
  food_tray borekTray; 
  // create an array that shows up how many food each thread ate 
  private int[] borekEaten;
  private int[] cakeEaten;
  private int[] drinkEaten;
  // create a lock object for locking 
  private final Object lock = new Object();
  // create waiter constructor
  public waiter(int totalBorek, int totalCake, int totalDrink) {
    this.totalBorek = totalBorek;
    this.totalCake = totalCake;
    this.totalDrink = totalDrink;  
    this.cakeTray = new food_tray(5);
    this.drinkTray = new food_tray(5);
    this.borekTray = new food_tray(5);
    this.borekEaten = new int[8];
    this.cakeEaten = new int[8];
    this.drinkEaten = new int[8];
  }
  // when trays is empty, fill the trays
  private void reFillTray(food_tray food,String name) {
    food.quantity = food.capacity;
    System.out.println("Garson tepsiyi doldurdu: "+ food.quantity + " adet "+ name);
  }
  // Serve method 1, while a thread is eating a food, other should be wait for it, so I used locks
  public void ServeBorek(int guest_index) {
    if (borekEaten[guest_index] < 4 && totalBorek > 0) {
      Thread currentThread = Thread.currentThread();
      String threadName = currentThread.getName();
      synchronized (lock) {
        if (borekTray.quantity > 0) {
          borekTray.quantity--;
          borekEaten[guest_index]++;
          totalBorek--;
          System.out.println("The "+threadName+" ate a borek");
      }
    }
   }
  }
  // Serve method 2 same lock mechanism
  public void ServeCake(int guest_index){
    if (cakeEaten[guest_index] < 2 && totalCake > 0) {
      Thread currentThread = Thread.currentThread();
    String threadName = currentThread.getName();
    synchronized (lock) {
      if (cakeTray.quantity > 0) {
        cakeTray.quantity--;
        cakeEaten[guest_index]++;
        totalCake--;
        System.out.println("The "+threadName +" ate a cake");
      }
    }
    }
  }
  // Serve method 3 same lock mechanism
  public void ServeDrink(int guest_index) {
    if (drinkEaten[guest_index] < 4 && totalDrink > 0) {
      Thread currentThread = Thread.currentThread();
    String threadName = currentThread.getName();
       
    synchronized (lock) {
      if (drinkTray.quantity > 0) {
        drinkTray.quantity --;
        drinkEaten[guest_index]++;
        totalDrink--;
        System.out.println("The "+threadName+" drank a drink");
      }
    }
    }
  }

  public int getTotalBorek() {
    return totalBorek;
  }

  public void setTotalBorek(int totalBorek) {
    this.totalBorek = totalBorek;
  }

  public int getTotalCake() {
    return totalCake;
  }

  public void setTotalCake(int totalCake) {
    this.totalCake = totalCake;
  }

  public int getTotalDrink() {
    return totalDrink;
  }

  public void setTotalDrink(int totalDrink) {
    this.totalDrink = totalDrink;
  }
  // checking for trays and filling them if they are empty
  public void checkServe() {
      System.out.println(borekTray.quantity);
      System.out.println(cakeTray.quantity);
      System.out.println(drinkTray.quantity);
      try {
        if(borekTray.quantity <=1){
          reFillTray(borekTray, "borek");
          System.out.println("The borek left is: "+totalBorek); 
        }
        if(cakeTray.quantity <=1) {
          reFillTray(cakeTray, "Cake");
          System.out.println("The cake left is: "+totalCake);
        }
        if(drinkTray.quantity <=1) {
          reFillTray(drinkTray, "Drink");
          System.out.println("The drink left is: "+totalDrink);
        }
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    
  }

  
  
  public static void main(String[] args) throws InterruptedException {
    //initializing the waiter
    waiter waiter = new waiter(30, 15, 30);
    // creating guests list as threads, starting threads
    Guest[] guests = new Guest[8];
    for (int i=0;i<guests.length;i++) {
      guests[i] = new Guest(waiter,i);
      guests[i].start();
    }
    
    while (true) {
       // calls the checkServe for waiter to check trays 
      waiter.checkServe();
      System.out.println("Borek: " + waiter.getTotalBorek() + ", Cake: " + waiter.getTotalCake() + ", Drink: " + waiter.getTotalDrink());
      System.out.println("Borek eaten: " + Arrays.toString(waiter.borekEaten) + ", Cake eaten: " + Arrays.toString(waiter.cakeEaten) + ", Drink drunk: " + Arrays.toString(waiter.drinkEaten));
      // Break when all the foods are consumed
      if (waiter.getTotalBorek() <= 0 && waiter.getTotalCake() <= 0 && waiter.getTotalDrink() <= 0) {
        System.out.println("All foods are consumed");
        break;
    }
  }
    
    
  }
  
  
}
class Guest extends Thread {
  // waiter object to create guest
  private waiter waiter; 
  // to hold thread number
  private int Thread_num;
  // guest constructor 
  public Guest(waiter waiter, int Thread_num) {
      this.waiter = waiter;
      this.Thread_num = Thread_num;
  }

  // calling the necessary methods for the threads
  @Override
  public void run() {
      while(true) {
        waiter.ServeBorek(Thread_num);
        waiter.ServeCake(Thread_num);
        waiter.ServeDrink(Thread_num);
        // break all the foods are consumed
        if (waiter.getTotalBorek() <= 0 && waiter.getTotalCake() <= 0 && waiter.getTotalDrink() <= 0) {
          break;
      }

      // Check if any food item is still available
      if (waiter.getTotalBorek() <= 0 || waiter.getTotalCake() <= 0 || waiter.getTotalDrink() <= 0) {
          continue;
      }
    }   
  }
}