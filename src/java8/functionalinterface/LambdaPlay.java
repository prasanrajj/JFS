package java8.functionalinterface;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface Greeting {
	void sayHello(String name);
}

@FunctionalInterface
interface Add {
	int sum(int a, int b);
}

public class LambdaPlay {
	public static void main(String[] args) {

		Greeting g = (name) -> System.out.println("Hello " + name+ "\n");
		g.sayHello("Prasanna");

		Add add = (a, b) -> a + b;
		System.out.println(add.sum(5, 7) + "\n");

		List<Integer> nums = Arrays.asList(5, 2, 9, 1, 3);
		nums.forEach(n -> System.out.println(n));
		
		 nums.sort((a, b) -> a - b); //COMPARATOR COMPARE LOGIC HERE
	}

}
