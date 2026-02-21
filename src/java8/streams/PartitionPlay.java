package java8.streams;

import java.util.*;
import java.util.stream.*;

public class PartitionPlay {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 3, 15, 8, 21, 4, null, 18);
        
        System.out.println("original: " + numbers + "\n\n");

        // Remove nulls first (otherwise comparison crashes)
        Map<Boolean, List<Integer>> result =
                numbers.stream()
                       .filter(Objects::nonNull)
                       .collect(Collectors.partitioningBy(n -> n > 10));
        System.out.println("Greater than 10 : " + result.get(true));
        System.out.println("Less or equal 10: " + result.get(false));


        // Example 2 — even / odd
        Map<Boolean, List<Integer>> evenOdd =
                numbers.stream()
                       .filter(Objects::nonNull)
                       .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("\nEven numbers: " + evenOdd.get(true));
        System.out.println("Odd numbers : " + evenOdd.get(false));


        // Example 3 — Strings partition
        List<String> names = List.of("Ram", "John", "Alex", "Sai", "Bob");
        Map<Boolean, List<String>> longNames =
                names.stream()
                     .collect(Collectors.partitioningBy(s -> s.length() > 3));
        System.out.println("\nLength > 3 : " + longNames.get(true));
        System.out.println("Length <= 3: " + longNames.get(false));
    }
}
