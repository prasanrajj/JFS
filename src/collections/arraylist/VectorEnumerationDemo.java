package collections.arraylist;

import java.util.Vector;
import java.util.Enumeration;
import java.util.Iterator;

public class VectorEnumerationDemo {

    public static void main(String[] args) {

        // Creating Vector
        Vector<Integer> vector = new Vector<>();
        vector.add(10);
        vector.add(20);
        vector.add(30);
        vector.add(40);

        System.out.println("Original Vector: " + vector);

        // Traversing using Enumeration (legacy way)
        System.out.println("\nUsing Enumeration:");
        Enumeration<Integer> enumeration = vector.elements();

        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }

    }
}
