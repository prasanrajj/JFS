package java8.optional;

import java.util.Optional;

public class OptionalPlayground {

	static class User {
		private String name;
		private int age;

		public User(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}
	}

	public static void main(String[] args) {
		// Basic NullPointerException
		System.out.println("NullPointer Example:");
		String str = null;
		// Uncomment below to see NPE
		// System.out.println(str.length());
		System.out.println("--------------------------------");

		// Optional.of() (Never pass null)
		System.out.println("Optional.of():");
		Optional<String> opt1 = Optional.of("java");
		System.out.println(opt1.get());
		// Uncomment below to see exception
		// Optional<String> optError = Optional.of(null);
		System.out.println("--------------------------------");

		// Optional.ofNullable()
		System.out.println("Optional.ofNullable():");
		Optional<String> opt2 = Optional.ofNullable(null);
		System.out.println(opt2.isPresent()); // false
		System.out.println(opt2);
		System.out.println("--------------------------------");

		// orElse()
		System.out.println("orElse():");
		String value = opt2.orElse("Default Value");
		System.out.println(value);
		System.out.println("--------------------------------");

		// orElseThrow()
		System.out.println("orElseThrow():");
		try {
			String val = opt2.orElseThrow(() -> new RuntimeException("Value not found"));
			System.out.println(val);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("--------------------------------");

		// User with null name
		System.out.println("User Example:");
		User user = new User(null, 10);

		// This is safe:
		String name = user.getName();
		System.out.println(name); // null
		// This would cause NPE:
		// System.out.println(user.getName().length());

		// Safe way using Optional:
		Optional<String> safeName = Optional.ofNullable(user.getName());
		System.out.println(safeName.map(String::length).orElse(0));
	}
}
