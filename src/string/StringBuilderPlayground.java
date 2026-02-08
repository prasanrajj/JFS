package string;

public class StringBuilderPlayground {

    public static void main(String[] args) {

        String s = "Hello";
        s.concat(" World");
        System.out.println("String: " + s +"\n");

        StringBuilder sb = new StringBuilder("Hello");
        System.out.println("Initial length: " + sb.length());
        System.out.println("Initial capacity: " + sb.capacity());

        sb.append(" World");
        System.out.println("\nAfter append: " + sb);

        sb.insert(5, " Java");
        System.out.println("After insert: " + sb);

        sb.replace(0, 5, "Hi");
        System.out.println("After replace: " + sb);

        sb.delete(2, 7);
        System.out.println("After delete: " + sb);

        sb.reverse();
        System.out.println("After reverse: " + sb);

        System.out.println("\nFinal length: " + sb.length());
        System.out.println("Final capacity: " + sb.capacity());

        StringBuffer buffer = new StringBuffer("ThreadSafe");
        buffer.append(" String");
        System.out.println("\nStringBuffer: " + buffer);
    }
}
