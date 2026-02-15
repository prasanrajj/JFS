package Blocks;

class Parent {

	// Static block
	static {
		System.out.println("Parent static block");
	}

	// Instance block
	{
		System.out.println("Parent instance block");
	}

	// Constructor
	Parent() {
		System.out.println("Parent constructor");
	}
}

class Child extends Parent {

	// Static block
	static {
		System.out.println("Child static block\n");
	}

	// Instance block
	{
		System.out.println("Child instance block");
	}

	// Constructor
	Child() {
		System.out.println("Child constructor");
	}
}

public class BlockExecutionPlayground {
	public static void main(String[] args) {

		System.out.println("Program started\n");
		System.out.println("\n------------------->Creating 1 object\n");

		Child obj1 = new Child();

		System.out.println("\n------------------->Creating 2 object\n");

		Child obj2 = new Child();
	}
}
