package ru.firstquad.algorithm.sort.impl;

import ru.firstquad.algorithm.sort.Sort;

/**
 * Created by dmitriy on 21/09/16.
 */
public class BubbleSort<T extends Comparable> implements Sort<T> {

    @Override
    public T[] sort(T[] input, Boolean desc) {
        for (int i = 0; i < input.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j].compareTo(input[j + 1]) > 0) {
                    swap(input, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
        return input;
    }
}
