package LabOO.Aulas.Aula_8.Sorter.src.strategy;

import main.SortContext;

public class QuickSortStrategy implements SortStrategy {
    // Quicksort
    @Override
    public <T extends Comparable<T>> void sort(T[] array, int order) {
        quickSort(array, 0, array.length - 1, order);
    }

    private <T extends Comparable<T>> void quickSort(T[] array, int i, int j, int order) {
        if (i < j) {
            int pivotIndex = partition(array, i, j, order);
            quickSort(array, i, pivotIndex - 1, order);
            quickSort(array, pivotIndex + 1, j, order);
        }
    }

    private <T extends Comparable<T>> int partition(T[] array, int start, int end, int order) {
        T pivot = array[end];
        int balancePoint = start;

        for (int idx = start; idx < end; idx++) {
            boolean troca;
            if (order == SortContext.ASCENDENTE) {
                troca = array[idx].compareTo(pivot) <= 0;
            } else {
                troca = array[idx].compareTo(pivot) >= 0;
            }

            if (troca) {
                T tmp = array[idx];
                array[idx] = array[balancePoint];
                array[balancePoint] = tmp;
                balancePoint++;
            }
        }

        T tmp = array[end];
        array[end] = array[balancePoint];
        array[balancePoint] = tmp;

        return balancePoint;
    }
}
