package ru.firstquad.algorithm.sort;

/**
 * Created by Dima on 20.06.2015.
 */
public class InsertionSort implements Sort<Integer> {
    Integer[] input;
    Boolean desc;

    public InsertionSort(Integer[] input, Boolean desc) {
        this.input = input;
        this.desc = desc;
    }

    /*
    * N^2
    * (N-1) + (N-2) .. ~ (N^2)/2
    * N exchanges
    * if the array is in ascending order, I.S. makes N-1 compares and 0 exchanges
    * best case ascending order
    * worst case deascending orger ~ N^2 compares and N^2 exchanges
    * */
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
        return sort(input, desc);
    }
}
