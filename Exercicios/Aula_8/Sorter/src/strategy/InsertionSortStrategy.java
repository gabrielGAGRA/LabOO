package strategy;

import main.SortContext;

public class InsertionSortStrategy implements SortStrategy {
    // Insertion sort
    @Override
    public <T extends Comparable<T>> void sort(T[] array, int order) {
        for (int i = 1; i < array.length; i++) {
            T key = array[i];
            int j = i - 1;

            // usar um ternario pra nao repetir codigo com if
            while (j >= 0
                    && (order == SortContext.ASCENDENTE ? array[j].compareTo(key) > 0 : array[j].compareTo(key) < 0)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}