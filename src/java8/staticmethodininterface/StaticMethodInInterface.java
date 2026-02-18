package java8.staticmethodininterface;

//================= INTERFACE DEFAULT vs STATIC PLAYGROUND =================

interface Payment {

 // ABSTRACT METHOD (must implement)
 void pay(int amount);

 // DEFAULT METHOD -> object behavior (can override)
 default void receipt() {
     System.out.println("Default receipt from Payment interface");
 }

 // STATIC METHOD -> utility logic (not inherited, cannot override)
 static boolean isValidAccount(String acc) {
     return acc != null && acc.length() == 10;
 }
}

public class StaticMethodInInterface {
 public static void main(String[] args) {
     System.out.println("\n---- STATIC METHOD DEMO ----");

     // static method called using interface name (no object)
     System.out.println("Valid account? " +
             Payment.isValidAccount("1234567890"));
 }
}

