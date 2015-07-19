package ru.firstquad.algorithm.sort;

/**
 * Created by Dima on 19.07.2015.
 */
public class SelectionSort implements Sort<Integer> {
    Integer[] input;
    Boolean decs;

    public SelectionSort(Integer[] input, Boolean decs) {
        this.input = input;
        this.decs = decs;
    }

    /*
    * N^2
    * is independing of order
    * */
    public Integer[] sort(Integer[] input, Boolean desc) {
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] > input[j]) {
                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }
        }
        return input;
    }

    public Integer[] start() {
        return sort(input, decs);
    }
}
