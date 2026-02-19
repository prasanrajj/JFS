package java8.streams;

import java.util.*;
import java.util.stream.*;

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
		return id + "-" + name + "-" + salary;
	}
}

public class StreamFullPlayground {

	public static void main(String[] args) {

		List<Employee> employees = Arrays.asList(
				new Employee(1, "A", 5000), 
				new Employee(2, "B", 7000),
				new Employee(3, "C", 4000), 
				new Employee(4, "D", 7000), 
				new Employee(5, "E", 9000));

		// ---------- INTERMEDIATE OPERATIONS ----------
		Stream<Employee> pipeline = 
			   employees.stream()
						.filter(e -> e.salary > 4000) // Predicate
						.distinct() // remove duplicates
						.sorted(Comparator.comparingDouble(e -> e.salary)) // sort
						.skip(0)
						.limit(10)
						.peek(e -> System.out.println("Processing: " + e)) // debug
						.map(e -> new Employee(e.id, e.name, e.salary + 500)); // transform

		// ---------- TERMINAL OPERATIONS (USE ONLY ONE AT A TIME) ----------
		// 0) reduce
		Double totalSalary = pipeline.map(e -> e.salary).reduce(0.0, Double::sum);
		System.out.println(totalSalary);

		// 1) forEach
//		 pipeline.forEach(System.out::println);

		// 2) collect
//		 List<Employee> list = pipeline.collect(Collectors.toList());
		// System.out.println(list);

		// 3) toList (Java 16+)
//		 List<Employee> list2 = pipeline.toList();
		// System.out.println(list2);

		// 4) count
		// long count = pipeline.count();
		// System.out.println(count);

		// 5) min
		// Optional<Employee> min = pipeline.min(Comparator.comparingDouble(e ->
		// e.salary));
		// System.out.println(min);

		// 6) max
		// Optional<Employee> max = pipeline.max(Comparator.comparingDouble(e ->
		// e.salary));
		// System.out.println(max);

		// 7) anyMatch
		// boolean any = pipeline.anyMatch(e -> e.salary > 8000);
		// System.out.println(any);

		// 8) allMatch
		// boolean all = pipeline.allMatch(e -> e.salary > 3000);
		// System.out.println(all);

		// 9) findFirst
//		 Optional<Employee> first = pipeline.findFirst();
		// System.out.println(first);

	}
}
