package ru.firstquad.algorithm.sort;

import static ru.firstquad.algorithm.util.AlgorithmUtils.shuffle;
import static ru.firstquad.algorithm.util.AlgorithmUtils.swap;

/**
 * Created by Dima on 17.08.2015.
 */
public class QuickSort {

    public static int[] sort(int[] input) {
        shuffle(input, true);
        sort(input, 0, input.length - 1);
        return input;
    }

    private static void sort(int[] input, int lo, int hi) {
        if (lo >= hi)
            return;
        int pivot = input[(lo + hi) / 2];
        int index = partition(input, lo, hi, pivot);
        sort(input, lo, index - 1);
        sort(input, index, hi);
    }

    private static int partition(int[] input, int lo, int hi, int pivot) {
        while (lo <= hi) {
            while (input[lo] < pivot) {
                lo++;
            }
            while (input[hi] > pivot) {
                hi--;
            }
            if (lo <= hi) {
                swap(input, lo, hi);
                lo++;
                hi--;
            }
        }
        return lo;
    }
}
