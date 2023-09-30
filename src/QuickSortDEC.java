import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickSortDEC {

    public static List<Integer> quickSort(List<Integer> list) {
        if (list.isEmpty()) {
            return list;
        } else {
            int pivot = list.get(0);
            List<Integer> sortedSmaller =
                    quickSort(list.stream().skip(1).filter(x -> x <= pivot).collect(Collectors.toList()));
            List<Integer> sortedGreater =
                    quickSort(list.stream().skip(1).filter(x -> x > pivot).collect(Collectors.toList()));

            return Stream.concat(Stream.concat(
                    sortedSmaller.stream(), Stream.of(pivot)), sortedGreater.stream()).collect(Collectors.toList());
        }
    }

    public static void main(String[] args) {
        List<Integer> unsortedList = List.of(5, 1, 9, 3, 7, 6);
        System.out.println("Unsorted List: " + unsortedList);
        long startTime = System.nanoTime();
        /*
         * In functional programming paradigms, it's generally recommended to avoid mutating data structures and
         * instead create new data structures with the desired changes.
         */
        List<Integer> sortedList = quickSort(unsortedList);
        long endTime = System.nanoTime();

        double executionTime = (endTime - startTime) / 1e6; // Convert to milliseconds

        System.out.println("Sorted List: " + sortedList);
        System.out.println("Execution Time: " + executionTime + " ms");
    }
}
