package collections.arraylist;

import java.util.*;

public class ListCreationDemo {

	public static void main(String[] args) {

		// Normal ArrayList (fully mutable)
		List<Integer> list1 = new ArrayList<>();
		list1.add(10);
		list1.add(20);
		list1.add(30);
		list1.add(40); // ✔ allowed

		System.out.println("Mutable ArrayList: " + list1);

		// Immutable
		List<Integer> list2 = List.of(10, 20, 30);
		System.out.println("List.of: " + list2);
		// list2.add(40); ❌ UnsupportedOperationException

		
		// Arrays.asList() — Fixed size (not fully immutable)
		List<Integer> list3 = Arrays.asList(10, 20, 30);
		System.out.println("Arrays.asList: " + list3);
		// list3.add(40); ❌ UnsupportedOperationException
		// list3.remove(0); ❌ UnsupportedOperationException
		list3.set(1, 99); // ✔ allowed (replace only)
		System.out.println("After set(): " + list3);

		// Make mutable copy from fixed/immutable list
		List<Integer> list4 = new ArrayList<>(List.of(1, 2, 3));
		list4.add(4); // ✔ now allowed

		System.out.println("Mutable copy: " + list4);
	}
}
