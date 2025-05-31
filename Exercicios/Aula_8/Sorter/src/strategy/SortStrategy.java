package strategy;

public interface SortStrategy {
    <T extends Comparable<T>> void sort(T[] array, int order);
}