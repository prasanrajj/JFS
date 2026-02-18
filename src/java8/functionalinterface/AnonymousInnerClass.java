package java8.functionalinterface;

@FunctionalInterface
interface Animal {
	void walk();
}

public class AnonymousInnerClass{
	public static void main(String[] args) {

		Animal dog = new Animal() {
			@Override
			public void walk() {
				System.out.println("Dog is walking");
			}
		};

		dog.walk();
		Animal dog1 = () -> System.out.println("Dog is walking");

		dog1.walk();

	}
}
