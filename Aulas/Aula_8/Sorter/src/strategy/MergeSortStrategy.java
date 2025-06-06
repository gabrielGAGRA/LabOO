package LabOO.Aulas.Aula_8.Sorter.src.strategy;

import main.SortContext;

public class MergeSortStrategy implements SortStrategy {

    @Override
    public <T extends Comparable<T>> void sort(T[] array, int order) {
        if (array == null || array.length <= 1) {
            return;
        }
        mergeSort(array, 0, array.length - 1, order);
    }

    private <T extends Comparable<T>> void mergeSort(T[] array, int left, int right, int order) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(array, left, middle, order);
            mergeSort(array, middle + 1, right, order);
            merge(array, left, middle, right, order);
        }
    }

    private <T extends Comparable<T>> void merge(T[] array, int left, int middle, int right, int order) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        T[] L = (T[]) new Comparable[n1];
        T[] R = (T[]) new Comparable[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = array[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[middle + 1 + j];

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            boolean condition;
            if (order == SortContext.ASCENDENTE) {
                condition = L[i].compareTo(R[j]) <= 0;
            } else {
                condition = L[i].compareTo(R[j]) >= 0;
            }

            if (condition) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }
}