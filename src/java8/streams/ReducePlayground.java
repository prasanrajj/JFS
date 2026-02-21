package java8.streams;
import java.util.*;
import java.util.stream.*;
public class ReducePlayground {
    public static void main(String[] args) {
        List<Integer> nums = List.of(2, 4, 6, 8);
        // 1) SUM with identity
        int sum = nums.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("Sum = " + sum);

        // 2) SUM without identity → Optional
        Optional<Integer> optionalSum =
                nums.stream()
                    .reduce((a, b) -> a + b);
        System.out.println("Optional Sum = " + optionalSum.orElse(0));


        // 3) MINIMUM (identity matters!)
        int minWrong = nums.stream()
                .reduce(0, Integer::min); // WRONG identity
        int minCorrect = nums.stream()
                .reduce(Integer.MAX_VALUE, Integer::min);
        System.out.println("Min (wrong identity)  = " + minWrong);
        System.out.println("Min (correct identity)= " + minCorrect);


        // 4) MULTIPLICATION (identity = 1)
        int product = nums.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println("Product = " + product);


        // 5) STRING CONCATENATION
        List<String> words = List.of("Java", "Streams", "Are", "Powerful");
        String sentence = words.stream()
                .reduce("", (a, b) -> a + " " + b);
        System.out.println("Sentence:" + sentence);


        // 6) PARALLEL REDUCE (combiner)
        int parallelSum = nums.parallelStream()
                .reduce(0,
                        (a, b) -> a + b,
                        (x, y) -> x + y);
        System.out.println("Parallel Sum = " + parallelSum);


        // 7) EMPTY STREAM behavior
        List<Integer> empty = List.of();
        int emptySum = empty.stream().reduce(0, Integer::sum);
        Optional<Integer> emptyOptional = empty.stream().reduce(Integer::sum);
        System.out.println("Empty sum = " + emptySum);
        System.out.println("Empty optional present? " + emptyOptional.isPresent());
    }
}
