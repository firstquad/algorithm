package ru.firstquad.algorithm.sort.impl;

import ru.firstquad.algorithm.sort.Sort;

/**
 * Created by Dima on 17.08.2015.
 */
public class QuickSort implements Sort<Integer> {

    /*
    * N*lg(N) but faster than mergesort
    * need shuflle before start, otherwise if array is sorted coast = N^2
    * unstable
    * */
    @Override
    public Integer[] sort(Integer[] input, Boolean desc) {
        new ShuffleSort().sort(input, true);
        sort(input, 0, input.length - 1);
        return input;
    }

    private void sort(Integer[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private int partition(Integer[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (a[++i] < a[lo]) {
                if (i == hi)
                    break;
            }
            while (a[lo] < a[--j]) {
                if (j == lo)
                    break;
            }
            if (i >= j)
                break;
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }
}
