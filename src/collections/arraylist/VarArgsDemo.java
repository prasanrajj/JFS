package collections.arraylist;

public class VarArgsDemo {
    public static void main(String[] args) {
        show(1);
        show(10);
        show(1,2,3,4,5);
    }
    
    //usage of var args
    static void show(int... nums) {
        for(int n : nums)
            System.out.print(n + " ");
        System.out.println();
    }
    
    //method overloading leading to redundancy
    static void show(int value1) {
    	System.out.println(value1);
    }
    static void show(int value1, int value2) {
    	System.out.println(value1);
    }
    static void show(int value1, int value2, int value3) {
    	System.out.println(value1);
    }
}


