package java8.streams;

import java.util.*;
import java.util.stream.*;

class Student {
	private int id;
	private String name;
	private String department;
	private int marks;
	public Student(int id, String name, String department, int marks) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.marks = marks;
	}
	public String getDepartment() {
		return department;
	}
	public int getMarks() {
		return marks;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return name + " (" + marks + ")";
	}
}

public class GroupingBy {
	public static void main(String[] args) {

		List<Student> students = List.of(new Student(1, "Arjun", "CSE", 80), new Student(2, "Divya", "CSE", 90),
				new Student(3, "Rahul", "ECE", 70), new Student(4, "Sneha", "MECH", 85),
				new Student(5, "Kiran", "MECH", 75));

		// Normal grouping (default = List)
		Map<String, List<Student>> grouped = students.stream().collect(Collectors.groupingBy(Student::getDepartment));
		System.out.println("Grouped Students:");
		grouped.forEach((dept, list) -> {
			System.out.println(dept + " -> " + list);
		});
		System.out.println("------------");

		// Counting students per department
		Map<String, Long> countPerDept = students.stream()
				.collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()));
		System.out.println("Count per Department:");
		System.out.println(countPerDept);
		System.out.println("------------");

		// Sum of marks per department
		Map<String, Integer> totalMarks = students.stream()
				.collect(Collectors.groupingBy(Student::getDepartment, Collectors.summingInt(Student::getMarks)));
		System.out.println("Total Marks per Department:");
		System.out.println(totalMarks);
		System.out.println("------------");

		// Average marks per department
		Map<String, Double> avgMarks = students.stream()
				.collect(Collectors.groupingBy(Student::getDepartment, Collectors.averagingDouble(Student::getMarks)));
		System.out.println("Average Marks per Department:");
		System.out.println(avgMarks);
	}
}
