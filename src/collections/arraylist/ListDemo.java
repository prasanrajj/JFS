package collections.arraylist;

import java.util.ArrayList;

public class ListDemo {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<>();

		list.add("A");// 0
		list.add("B");// 1
		list.add("C");// 2
		list.add("D");// 3

		System.out.println("Before add(index): " + list);
		list.set(3, "d");// updates value at 3

		list.add(1, "X");
		// inserts at index 1 and copies values to adjacent index

		System.out.println("\n\n\n\nAfter add(index):  " + list);
	}
}
