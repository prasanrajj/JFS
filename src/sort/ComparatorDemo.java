package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//class Product {
//
//	int id;
//	String name;
//	double price;
//
//	Productt(int id, String name, double price) {
//		this.id = id;
//		this.name = name;
//		this.price = price;
//	}
//
//	public String toString() {
//		return id + " | " + name + " | " + price;
//	}
//}




class PriceComparator implements Comparator<Product> {
	@Override
	public int compare(Product a, Product b) {
		return Double.compare(a.price, b.price);
	}
}

class NameComparator implements Comparator<Product> {
	@Override
	public int compare(Product a, Product b) {
		return a.name.compareTo(b.name);
	}
}

class IdDescComparator implements Comparator<Product> {
	@Override
	public int compare(Product a, Product b) {
		return b.id - a.id;
	}
}

public class ComparatorDemo {
	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
		products.add(new Product(101, "Phone", 20000));
		products.add(new Product(104, "Keyboard", 1500));
		products.add(new Product(103, "Mouse", 500));
		products.add(new Product(102, "Laptop", 60000));
		System.out.println("Original:");
		System.out.println(products);

		// sort by price
		Collections.sort(products, new PriceComparator());
		System.out.println("\nSorted by price:");
		System.out.println(products);

		// sort by name
		Collections.sort(products, new NameComparator());
		System.out.println("\nSorted by name:");
		System.out.println(products);

		// sort by id descending
		Collections.sort(products, new IdDescComparator());
		System.out.println("\nSorted by id desc:");
		System.out.println(products);
	}
}
