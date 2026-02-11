package collections.arraylist.generics;

import java.util.ArrayList;

public class Generics{
public static void main(String[] args) {
	ArrayList list = new ArrayList();
	list.add("Java");
	Object obj = list.get(0);
	String s = (String) obj;   // you must cast explicitly
	System.out.println(s);
	

	ArrayList<String> list1 = new ArrayList<>();
	list1.add("Java");
	//no type casting herer in generics <>
	String s1 = list1.get(0);    // compiler guarantees type
	System.out.println(s1);
}
}

