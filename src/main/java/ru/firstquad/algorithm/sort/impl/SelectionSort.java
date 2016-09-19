package ru.firstquad.algorithm.sort.impl;

import ru.firstquad.algorithm.sort.Sort;

/**
 * Created by Dima on 19.07.2015.
 */
public class SelectionSort implements Sort<Integer> {

    /*
    * N^2
    * is independing of order
    * unstable
    * */
    @Override
    public Integer[] sort(Integer[] input, Boolean desc) {
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] > input[j]) {
                    swap(input, i, j);
                }
            }
        }
        return input;
    }

}
