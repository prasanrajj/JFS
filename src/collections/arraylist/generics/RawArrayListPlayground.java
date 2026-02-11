package collections.arraylist.generics;

import java.util.ArrayList;

public class RawArrayListPlayground {

    public static void main(String[] args) {

        ArrayList list = new ArrayList();   // raw ArrayList

        list.add(10);        // Integer stored as Object
        list.add("Java");    // String stored as Object
        list.add(12.5);      // Double stored as Object

        for (Object obj : list) {

            if (obj instanceof Integer) {
            	// Correct casting (only if actual type matches)
                Integer i = (Integer) obj;
                System.out.println("Integer value: " + (i + 5));

            } else if (obj instanceof Double) {
            	// Correct casting (only if actual type matches)
                Double d = (Double) obj;
                System.out.println("Double value: " + (d + 2.5));

            } else if (obj instanceof String) {
            	// Correct casting (only if actual type matches)
                String s = (String) obj;
                System.out.println("String value: " + s.toUpperCase());
            }
        }

        
        // Wrong casting (uncomment to see runtime error)
         Double wrong = (Double) list.get(1);   // ClassCastException

        // Correct way: String to number
        String num = "123";
        int parsed = Integer.parseInt(num);
        System.out.println(parsed + 10);
    }
}

