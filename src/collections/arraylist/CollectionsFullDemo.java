package collections.arraylist;
import java.util.*;
public class CollectionsFullDemo {
	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>(List.of(5, 2, 9, 1, 3));

		System.out.println("Original: " + list);

		// sort (ascending)
		Collections.sort(list);
		System.out.println("After sort: " + list);

		// reverse
		Collections.reverse(list);
		System.out.println("After reverse: " + list);

		// descending using comparator
		Collections.sort(list, Comparator.reverseOrder());
		System.out.println("Descending order: " + list);

		// max & min
		System.out.println("Max: " + Collections.max(list));
		System.out.println("Min: " + Collections.min(list));

		// shuffle (random order)
		Collections.shuffle(list);
		System.out.println("After shuffle: " + list);

		// swap elements
		Collections.swap(list, 0, list.size() - 1);
		System.out.println("After swap first & last: " + list);

		// replace all occurrences
		Collections.replaceAll(list, list.get(0), 100);
		System.out.println("After replaceAll: " + list);
	}
}
