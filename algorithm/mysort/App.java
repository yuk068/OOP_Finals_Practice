package yukwork.algorithm.mysort;

import java.util.Arrays;
import java.util.Random;

public class App {

    private static final Random random = new Random();
    private static final Sorter sorter = new Sorter();
    private static int[] toSort;
    private static final int range = 40_000;
    private static final boolean print = false;

    public static void main(String[] args) {
        init();
        // Bubble sort
        sorter.setSorter(new BubbleSort());
        testSort(sorter, range, print);
        init();
        // Selection Sort
        sorter.setSorter(new SelectionSort());
        testSort(sorter, range, print);
        init();
        // Insertion sort
        sorter.setSorter(new InsertionSort());
        testSort(sorter, range, print);
        init();
        // Quick sort
        sorter.setSorter(new QuickSort());
        testSort(sorter, range, print);
        init();
        // Merge sort
        sorter.setSorter(new MergeSort());
        testSort(sorter, range, print);
    }

    public static void testSort(Sorter sorter, int range, boolean print) {
        long start = System.currentTimeMillis();
        sorter.sort(toSort);
        long end = System.currentTimeMillis();
        String algorithm = sorter.getSortType().getClass().getSimpleName();
        System.out.println(algorithm + ": " + (end - start) + "ms for " + range + " element(s)");
        if (print) {
            System.out.println(Arrays.toString(toSort));
        }
    }

    public static void init() {
        toSort = new int[range];

        for (int i = 0; i < range; i++) {
            int value;
            value = random.nextInt(range) + 1;
            toSort[i] = value;
        }
    }

}
