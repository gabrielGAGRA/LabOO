package LabOO.Aulas.Aula_8.Sorter.src.main;

import strategy.SortStrategy;

public class SortContext {
    public static final int ASCENDENTE = 1;
    public static final int DESCENDENTE = 2;

    private SortStrategy strategy;

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public <T extends Comparable<T>> void sort(T[] array, int order) {
        strategy.sort(array, order);
    }
}
