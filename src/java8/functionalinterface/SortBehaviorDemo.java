package java8.functionalinterface;
import java.util.*;

class Employee {
	int id;
	String name;
	double salary;

	Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public String toString() {
		return id + " " + name + " " + salary;
	}
}

public class SortBehaviorDemo {

	public static void main(String[] args) {

		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1, "A", 5000));
		list.add(new Employee(2, "B", 3000));
		list.add(new Employee(3, "C", 7000));

		// SORT BY SALARY USING ANONYMOUS CLASS
		Collections.sort(list, new Comparator<Employee>() {
			public int compare(Employee e1, Employee e2) {
				return Double.compare(e1.salary, e2.salary);
			}
		});
		System.out.println("Sorted by salary (anonymous): ");
		list.forEach(System.out::println);
		
		System.out.println("------------------------------");

		// SORT BY SALARY USING LAMBDA
		Collections.sort(list, (e1, e2) -> Double.compare(e2.salary, e1.salary));
		System.out.println("Sorted by salary (lambda): ");
		list.forEach(System.out::println);
	}
}
