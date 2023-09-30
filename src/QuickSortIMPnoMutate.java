import java.util.ArrayList;
import java.util.List;

public class QuickSortIMPnoMutate {

    public static List<Integer> quickSort(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        } else {
            int pivot = list.get(0);
            List<Integer> smaller = new ArrayList<>();
            List<Integer> greater = new ArrayList<>();

            for (int i = 1; i < list.size(); i++) {
                int current = list.get(i);
                if (current <= pivot) {
                    smaller.add(current);
                } else {
                    greater.add(current);
                }
            }

            List<Integer> sortedSmaller = quickSort(smaller);
            List<Integer> sortedGreater = quickSort(greater);

            List<Integer> sortedList = new ArrayList<>();
            sortedList.addAll(sortedSmaller);
            sortedList.add(pivot);
            sortedList.addAll(sortedGreater);

            return sortedList;
        }
    }

    public static int partition(List<Integer> list, int low, int high) {
        int pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list.get(j) <= pivot) {
                i++;

                int temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        int temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);

        return i + 1;
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
