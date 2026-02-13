package collections.arraylist;

import java.util.*;

public class MapPlayground {

	public static void main(String[] args) {

		// =========================
		// LinkedHashMap
		System.out.println("\n---- LinkedHashMap (Insertion Order) ----");
		Map<String, Integer> linkedMap = new LinkedHashMap<>();
		linkedMap.put("Banana", 1);
		linkedMap.put("Apple", 2);
		linkedMap.put("Cat", 3);
		linkedMap.put("Apple", 5); // overwrite
		System.out.println(linkedMap);

		// =========================
		// TreeMap
		System.out.println("\n---- TreeMap (Sorted by key) ----");
		Map<Integer, String> treeMap = new TreeMap<>();
		treeMap.put(3, "C");
		treeMap.put(1, "A");
		treeMap.put(2, "B");
		System.out.println(treeMap +"\n");

		// =========================
		// HashMap
		System.out.println("---- HashMap ----");
		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("Math", 90);
		hashMap.put("Science", 80);
		hashMap.put("Math", 95); // overwrite
		hashMap.put(null, 50); // one null key
		hashMap.put("English", null);
		hashMap.put("Hindi", null);
		System.out.println(hashMap + "\n\n\n");

		// iterate
		for (Map.Entry<String, Integer> e : hashMap.entrySet()) {
			System.out.println(e.getKey() + " -> " + e.getValue());
		}

	}
}





class Student {
	String name;
	int marks;

	Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}

	public String toString() {
		return name + "(" + marks + ")";
	}
}