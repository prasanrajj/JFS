package java8.streams;

import java.util.*;
import java.util.stream.*;

class Student implements Comparable<Student> {
    int id;
    String name;
    int marks;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Comparable → default sorting by marks
    @Override
    public int compareTo(Student s) {
        return this.marks - s.marks;
    }

    public String toString() {
        return id + " " + name + " " + marks;
    }
}

public class StreamAllInOne {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 5, 20, 20, 7, 9, 15);//retruns ArrayList
        System.out.println( Arrays.asList(10, 5, 20, 20, 7, 9, 15).getClass());

        // ---------- findFirst + Optional ----------
        Optional<Integer> first = numbers.stream().findFirst();
        System.out.println("First: " + first.orElse(-1));

        // ---------- second largest ----------
        int secondLargest = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(-1);
        System.out.println("Second Largest: " + secondLargest);

        // ---------- limit ----------
        System.out.println("Top 3 largest:");
        numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .forEach(System.out::println);

        // ---------- mapToInt + sum ----------
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum: " + sum);

        // ---------- max + getAsInt ----------
        OptionalInt max = numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
//                .getAsInt()
                ;     
        System.out.println("Max: " + max);

        // ---------- average ----------
        double avg = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
        System.out.println("Average: " + avg);

        // ---------- anyMatch / allMatch ----------
        System.out.println("Any > 18: " +
                numbers.stream().anyMatch(n -> n > 18));

        System.out.println("All > 3: " +
                numbers.stream().allMatch(n -> n > 3));

        // ---------- flatMap ----------
        List<List<Integer>> nested = List.of(
                List.of(1,2),
                List.of(3,4),
                List.of(5,6)
        );

        List<Integer> flat = nested.stream()
                .flatMap(List::stream)
                .toList();

        System.out.println("Flattened: " + flat);

        // ---------- Comparable sorting ----------
        List<Student> students = List.of(
                new Student(1,"Ram",70),
                new Student(2,"Sam",90),
                new Student(3,"Raj",80)
        );

        System.out.println("\nSorted by marks (Comparable):");
        students.stream().sorted().forEach(System.out::println);

        // ---------- Comparator sorting ----------
        System.out.println("\nSorted by name (Comparator):");
        students.stream()
                .sorted(Comparator.comparing(s -> s.name))
                .forEach(System.out::println);

        // ---------- Map Stream ----------
        Map<String,Integer> map = new HashMap<>();
        map.put("A",50);
        map.put("B",80);
        map.put("C",60);

        System.out.println("\nMap sorted by value:");
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(e -> System.out.println(e.getKey()+" "+e.getValue()));

        // ---------- Collectors.toSet ----------
        Set<Integer> set = numbers.stream()
                .collect(Collectors.toSet());
        System.out.println("Set: " + set.getClass());

        // ---------- Collectors.toMap ----------
        Map<String,Integer> newMap =
                students.stream()
                        .collect(Collectors.toMap(
                                s -> s.name,
                                s -> s.marks
                        ));

        System.out.println("Collected Map: " + newMap.getClass());

        // ---------- Parallel Stream ----------
        System.out.println("\nParallel processing:");
        numbers.parallelStream()
                .forEach(n -> System.out.println(Thread.currentThread().getName()+" "+n));
    }
}

