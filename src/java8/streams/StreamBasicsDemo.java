package java8.streams;

import java.util.*;

public class StreamBasicsDemo {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        //Stream creation
        System.out.println("Original List: " + numbers);

        //Intermediate operations (nothing runs yet)
        var stream = numbers.stream()//a default method from collections class
                .filter(n -> {
                    System.out.println("Filtering:------>  " + n);
                    return n > 20;
                })
                .map(n -> {
                    System.out.println("Mapping:=====================> " + n);
                    return n * 2;
                });
        Stream

        System.out.println("No terminal operation yet → nothing executed");

        //Terminal operation (execution starts here)
        System.out.println("\nExecuting stream:");
        List<Integer> result = stream.toList();
        System.out.println("Result: " + result);

        //Trying to reuse stream
        System.out.println("\nTrying to reuse stream:");
        try {
            stream.forEach(System.out::println);
        } catch (IllegalStateException e) {
            System.out.println("Stream already consumed!");
        }

        //Original list unchanged
        System.out.println("\nOriginal List after stream: " + numbers);
    }
}

