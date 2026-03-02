package java8.streams;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class MethodReferencePlayground {

    //STATIC METHOD
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    //INSTANCE METHOD (for demonstration)
    public String addPrefix(String name) {
        return "Mr/Ms " + name;
    }

    //Constructor example class
    static class Student {
        String name;

        public Student(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student: " + name;
        }
    }

    public static void main(String[] args) {

        //STATIC METHOD REFERENCE
        System.out.println("Static Method Reference (Prime Numbers):");

        List<Integer> numbers = List.of(2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream()
               .filter(MethodReferencePlayground::isPrime)
               .forEach(System.out::println);
        System.out.println("---------------------------------");

        //INSTANCE METHOD (Specific Object)
        System.out.println("Instance Method Reference (Specific Object):");
        MethodReferencePlayground obj = new MethodReferencePlayground();
        List<String> names = List.of("Arjun", "Divya", "Rahul");
        names.stream()
             .map(obj::addPrefix)
             .forEach(System.out::println);
        System.out.println("---------------------------------");

        //ARBITRARY OBJECT METHOD REFERENCE
        System.out.println("Arbitrary Object Method Reference:");
        names.stream()
             .map(String::toUpperCase)// .map(name -> name.toUpperCase())
             .forEach(System.out::println);
        System.out.println("---------------------------------");

        //CONSTRUCTOR METHOD REFERENCE
        System.out.println("Constructor Method Reference:");
        List<Student> students =
                names.stream()
                     .map(Student::new)
                     .collect(Collectors.toList());
        students.forEach(System.out::println);
    }
}
