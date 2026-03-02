package java8.streams;

import java.util.*;
import java.util.stream.*;

public class StringStreamShowcase {

	public static void main(String[] args) {

		String input = "Programming123!!!";

		System.out.println("Original String: " + input);

		// Using chars() → IntStream → convert to Stream<String>
		String uniqueCharacters = input.chars()// Using chars() → IntStream
				.mapToObj(c -> String.valueOf((char) c))// convert to Stream<String>
				.distinct().collect(Collectors.joining());//works only on string
		System.out.println("Unique Characters: " + uniqueCharacters);

		// Filter only alphabets
		String onlyAlphabets = input.chars().filter(Character::isAlphabetic)// work on int not char
				.mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
		System.out.println("Only Alphabets: " + onlyAlphabets);

		// Filter only digits
		String onlyDigits = input.chars().filter(Character::isDigit).mapToObj(c -> String.valueOf((char) c))
				.collect(Collectors.joining());
		System.out.println("Only Digits: " + onlyDigits);

		// Sorted characters
		String sortedCharacters = input.chars().mapToObj(c -> String.valueOf((char) c)).sorted()
				.collect(Collectors.joining());
		System.out.println("Sorted Characters: " + sortedCharacters);

		// Using Collectors.joining with delimiter + prefix + suffix
		String formattedOutput = input.chars().filter(Character::isLetter).mapToObj(c -> String.valueOf((char) c))
				.distinct().collect(Collectors.joining(", ", "[", "]"));
		System.out.println("Formatted Output: " + formattedOutput);

		// Using split() + Arrays.stream()
		String uniqueUsingSplit = Arrays.stream(input.split("")).distinct().collect(Collectors.joining());
		System.out.println("Unique using split(): " + uniqueUsingSplit);

		// Uppercase Rebuilt
		String rebuilt = Arrays.stream(input.split("")).map(String::toUpperCase).collect(Collectors.joining());
		System.out.println("Uppercase Rebuilt: " + rebuilt);
	}
}
