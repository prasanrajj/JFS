package collections.arraylist;

import java.util.*;

public class MapPractice {
	public static void main(String[] args) {
		// Map creation (Parent reference + child object)
		Map<Integer, User> map = new HashMap<>();
		// Adding records
		map.put(1, new User(1, "Prasanna"));
		map.put(2, new User(2, "Ravi"));
		map.put(3, new User(3, "Anu"));
		map.put(4, new User(4, "Kiran"));
		System.out.println("Full Map:");
		System.out.println(map);

		// Get value using key
		System.out.println("\nGet key 2:");
		System.out.println(map.get(2));

		// Check key existence
		System.out.println("\nCheck key 5 exists?");
		if (map.containsKey(5))
			System.out.println("Key exists");
		else
			System.out.println("Key NOT present");

		// entrySet() (Full records)
		System.out.println("\nEntry Set (Full record):");
		for (Map.Entry<Integer, User> entry : map.entrySet()) {
			System.out.println(entry); // prints key=value
		}

		// keySet() (Only keys)
		System.out.println("\nKey Set:");
		for (Integer key : map.keySet()) {
			System.out.println(key);
		}

		// values() (Only values)
		System.out.println("\nValues:");
		for (User user : map.values()) {
			System.out.println(user);
		}

		// Using Iterator
		System.out.println("\nIterator traversal:");
		Iterator<Map.Entry<Integer, User>> it = map.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry<Integer, User> e = it.next();
			System.out.println("Key: " + e.getKey() + " Value: " + e.getValue());
		}

		// Difference between get() and containsKey()
		System.out.println("\nNull check test:");

		map.put(10, null); // key exists but value null
		System.out.println("------------");

		System.out.println("map.get(10) = " + map.get(10));

		if (map.get(10) == null)
			System.out.println("get() says key missing OR value null");

		if (map.containsKey(10))
			System.out.println("containsKey() says key exists");

		// Remove entry safely using iterator
		System.out.println("\nRemoving entries with even keys:");

		Iterator<Map.Entry<Integer, User>> removeIt = map.entrySet().iterator();

		while (removeIt.hasNext()) {
			Map.Entry<Integer, User> e = removeIt.next();

			if (e.getKey() % 2 == 0) {
				removeIt.remove(); // safe removal
			}
		}

		System.out.println(map);
	}
}

class User {
	int id;
	String name;

	User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String toString() {
		return "User{id=" + id + ", name='" + name + "'}";
	}
}
