package sort;

import java.util.*;

class Product implements Comparable<Product> {

	int id;
	String name;
	double price;

	Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	// Natural ordering: sort by price
	@Override
	public int compareTo(Product other) {

		System.out.println("Comparing " + this.name + " with " + other.name);

		// ascending price order (reversing param leads to reverse order)
		return Double.compare(this.price, other.price); // sort by price
//        return this.id - other.id; //Sort by ID
//        return this.name.compareTo(other.name); //Sort by Name

	}

	public String toString() {
		return id + " | " + name + " | " + price;
	}
}

public class ComparableDemo {
	public static void main(String[] args) {

		List<Product> products = new ArrayList<>();

		products.add(new Product(101, "Phone", 20000));
		products.add(new Product(102, "Laptop", 60000));
		products.add(new Product(103, "Mouse", 500));
		products.add(new Product(104, "Keyboard", 1500));

		System.out.println("Before sorting:");
		System.out.println(products + "\n");

		Collections.sort(products); // uses compareTo()

		System.out.println("\nAfter sorting (by price):");
		System.out.println(products);
	}
}
