package ru.firstquad.algorithm.sort;

/**
 * Created by Dima on 20.06.2015.
 */
public class InsertionSort implements Sort<Integer> {
    Integer[] input;
    Boolean decs;

    public InsertionSort(Integer[] input, Boolean decs) {
        this.input = input;
        this.decs = decs;
    }

    public Integer[] sort(Integer[] input, Boolean decs) {
        for (int j = 1; j < input.length; j++) {
            int key = input[j];
            int i = j - 1;
            while (i >= 0 && (input[i] < key ? decs : !decs)) {
                input[i + 1] = input[i];
                i = i - 1;
            }
            input[i + 1] = key;
        }
        return input;
    }


    public Integer[] start() {
        return sort(input, decs);
    }
}
