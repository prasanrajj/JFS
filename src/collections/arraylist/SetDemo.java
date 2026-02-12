package collections.arraylist;

import java.util.*;

public class SetDemo {

	public static void main(String[] args) {
		System.out.println("SET is UNIQUE\n");
		// HashSet
		Set<String> hashSet = new HashSet<>();
		hashSet.add("Banana");
		hashSet.add("Apple");
		hashSet.add("Banana"); // Duplicate
		hashSet.add(null);
		hashSet.add(null); // Second null ignored
		System.out.println("HashSet: " + hashSet);
		System.out.println("order not preserved\n");

		// LinkedHashSet
		Set<String> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add("Banana");
		linkedHashSet.add("Apple");
		linkedHashSet.add("Banana");
		linkedHashSet.add(null);
		linkedHashSet.add(null);
		System.out.println("LinkedHashSet: " + linkedHashSet);
		System.out.println("order preserved\n");

		// TreeSet
		Set<String> treeSet = new TreeSet<>();
		treeSet.add("Banana");
		treeSet.add("Apple");
		treeSet.add("Cat");
		// treeSet.add(null); // ❌ NullPointerException
		System.out.println("TreeSet: " + treeSet);
		System.out.println("sorted ascendingly or aplhabetically\n");
	}
}
