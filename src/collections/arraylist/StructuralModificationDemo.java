package collections.arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class StructuralModificationDemo {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);

		ArrayList<Integer> list2 = new ArrayList<>(list);
		System.out.println("need to remove 20, 30");
		System.out.println("=====================================");
		System.out.println("Original list  : " + list);

		// Removing using normal for loop (skipping problem)
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == 20 || list.get(i) == 30) {
				list.remove(i);
			}
		}

		System.out.println("After for-loop removal : " + list);

		// Removing using Iterator (safe removal)
		Iterator<Integer> it = list2.iterator();

		while (it.hasNext()) {
			Integer value = it.next();
			if (value == 20 || value == 30) {
				it.remove();
			}
		}

		System.out.println("After Iterator removal : " + list2);
	}
}
