package ru.firstquad.algorithm.sort;

/**
 * Created by dmitriy on 17/09/16.
 */
public interface Sort<T extends Comparable> {

    T[] sort(T[] input, Boolean desc);

    default T[] sort(T[] input) {
        return sort(input, false);
    }

    default void swap(T[] input, int i, int j) {
        T temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
