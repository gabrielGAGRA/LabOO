package LabOO.Aulas.Aula_8.Sorter.src.strategy;

public interface SortStrategy {
    <T extends Comparable<T>> void sort(T[] array, int order);
}