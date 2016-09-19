package ru.firstquad.algorithm.sort.impl;

import ru.firstquad.algorithm.sort.Sort;

/**
 * Created by Dima on 20.06.2015.
 */
public class InsertionSort<T extends Comparable> implements Sort<T> {

    /*
    * N^2
    * (N-1) + (N-2) .. ~ (N^2)/2
    * N exchanges
    * if the array is in ascending order, I.S. makes N-1 compares and 0 exchanges
    * best case ascending order
    * worst case descending order is ~ N^2 compares and N^2 exchanges
    * stable
    * */
    @Override
    public T[] sort(T[] input, Boolean decs) {
        for (int j = 1; j < input.length; j++) {
            T key = input[j];
            int i = j - 1;
            while (i >= 0 && (input[i].compareTo(key) < 0 ? decs : !decs)) {
                input[i + 1] = input[i];
                i = i - 1;
            }
            input[i + 1] = key;
        }
        return input;
    }

    public T[] sortSimple(T[] input, Boolean decs) {
        for (int i = 0; i < input.length; i++) {
            for (int j = i; j > 0; j--) {
                if (input[j].compareTo(input[j - 1]) > 0) {
                    swap(input, j, j - 1);
                }
            }
        }
        return input;
    }
}
