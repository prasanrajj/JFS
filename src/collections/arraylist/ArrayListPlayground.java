package collections.arraylist;

import java.util.ArrayList;

public class ArrayListPlayground {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        System.out.println("Initial size: " + list.size());

        list.add("Java");
        list.add("Spring");
        list.add("Boot");
        list.add(null);
        list.add("Java");

        System.out.println("\nList elements: " + list);
        System.out.println("Size after adding elements: " + list.size());

        list.remove("Spring");
        System.out.println("\nAfter removing element: " + list);

        System.out.println("Element at index 1: " + list.get(1));

        list.set(1, "Hibernate");
        System.out.println("\nAfter update: " + list);

        System.out.println("Contains 'Java'? " + list.contains("Java"));
    }
}

