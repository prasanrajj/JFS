package collections.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorPlayground {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");

		System.out.println("Original List: " + list);

		// -------- Iterator (one direction, safe remove) --------
		Iterator<String> it = list.iterator();

		while (it.hasNext()) {
			String value = it.next();
			System.out.println("Iterator next(): " + value);

			if (value.equals("B")) {
				it.remove(); // safe removal
			}
		}

		System.out.println("After Iterator remove: " + list);

		// -------- ListIterator (both directions) --------
		ListIterator<String> lit = list.listIterator();

		System.out.println("\nForward traversal:");
		while (lit.hasNext()) {
			System.out.println(lit.next());
		}

		System.out.println("\nBackward traversal:");
		while (lit.hasPrevious()) {
			System.out.println(lit.previous());
		}
		
		//lit.previous();   // ❌ throws NoSuchElementException


		// -------- Modification using ListIterator --------
		lit = list.listIterator();
		while (lit.hasNext()) {
			if (lit.next().equals("C")) {
				lit.set("X"); // replace element
			}
		}

		System.out.println("\nAfter ListIterator set(): " + list);
	}
}
