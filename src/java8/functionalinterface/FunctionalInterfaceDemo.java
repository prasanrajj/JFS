package java8.functionalinterface;


@FunctionalInterface
interface Calculator {

 // ONLY abstract method (this makes it functional)
 int operate(int a, int b);

 // -------- default methods (allowed unlimited) --------
 default void info() {
     System.out.println("Calculator interface default method");
 }

 // -------- static methods (allowed unlimited) --------
 static void about() {
     System.out.println("Static method inside interface");
 }

}



public class FunctionalInterfaceDemo {

 public static void main(String[] args) {

     // Lambda works because only ONE abstract method exists
     Calculator add = (a, b) -> a + b;

     System.out.println("Result: " + add.operate(5, 3));

     // default methods
     add.info();

     // static methods
     Calculator.about();
 }
}

