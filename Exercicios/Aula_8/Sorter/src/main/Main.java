package main;

import java.util.Arrays;
import strategy.QuickSortStrategy;
import strategy.MergeSortStrategy;
import strategy.InsertionSortStrategy;

public class Main {

    public static void main(String[] args) {
        SortContext sorterContext = new SortContext();

        Integer[] intArray = { 34, 5, 3, 7, 2, 0, 6, 3, -10, 34, 5, 8 };
        sorterContext.setStrategy(new QuickSortStrategy());
        sorterContext.sort(intArray, SortContext.ASCENDENTE);
        System.out.println(Arrays.toString(intArray));

        String[] stringArray = { "a", "c", "d", "7", "2", "0", "6", "3", "-10", "34", "5", "8" };
        sorterContext.setStrategy(new MergeSortStrategy());
        sorterContext.sort(stringArray, SortContext.DESCENDENTE);
        System.out.println(Arrays.toString(stringArray));

        Double[] doubleArray = { 34.0, 5.0, 3.0, 7.0, 2.0, 0.0, 6.0, 3.0, -10.0, 34.0, 5.0, 8.0 };
        sorterContext.setStrategy(new InsertionSortStrategy());
        sorterContext.sort(doubleArray, SortContext.ASCENDENTE);
        System.out.println(Arrays.toString(doubleArray));
    }
}
