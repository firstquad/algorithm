package ru.firstquad.algorithm.sort.impl;

import ru.firstquad.algorithm.sort.Sort;

/**
 * Created by Dima on 19.07.2015.
 */
public class ShellSort implements Sort<Integer> {

    /*
    * N ^ (3/2)
    * unstable
    * */
    @Override
    public Integer[] sort(Integer[] input, Boolean desc) {
        int size = input.length;
        int h = 1;
        while (h < size / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < size; i++) {
                for (int j = i; j >= h && input[j] < input[j - h]; j -= h) {
                    swap(input, j, j - 1);
                }
            }
            h = h / 3;
        }
        return input;
    }

}
