import java.util.ArrayList;
import java.util.List;

public class QuickSortIMP {

    public static void quickSort(List<Integer> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSort(list, low, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, high);
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
        List<Integer> list = new ArrayList<>(List.of(5, 1, 9, 3, 7, 6));
        int n = list.size();

        System.out.println("Unsorted List: " + list);
        long startTime = System.nanoTime();
        quickSort(list, 0, n - 1);
        long endTime = System.nanoTime();

        double executionTime = (endTime - startTime) / 1e6; // Convert to milliseconds

        System.out.println("Sorted List: " + list);
        System.out.println("Execution Time: " + executionTime + " ms");
    }
}
