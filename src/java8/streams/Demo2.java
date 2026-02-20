package java8.streams;

import java.util.*;
import java.util.stream.*;

public class Demo2 {
	public static void main(String[] args) {
		
		List<Integer> list = List.of(); // EMPTY LIST
		
		//MEANING FULL
	    //Java can safely return primitive.
		int sum = list.stream().mapToInt(i -> i).sum();

		long count = list.stream().count();

		System.out.println("sum = " + sum);
		System.out.println("count = " + count);

		

		//NO MEANING
		//Java cannot invent a fake number.So it returns a container saying:“No answer exists”
		OptionalInt max = list
							.stream()
							.mapToInt(i -> i)
							.max();
//							.orElse(0);

		OptionalInt min = list
								.stream()
								.mapToInt(i -> i)
								.min();
//								.orElse(0);
		
		

		OptionalDouble avg = list
								.stream()
								.mapToInt(i -> i)
								.average();
//								.orElse(0.0);
		

		System.out.println("max present? " + max.isPresent());
		System.out.println("min present? " + min.isPresent());
		System.out.println("avg present? " + avg.isPresent());
	}
}
