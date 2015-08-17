package ru.firstquad.algorithm.sort;

import java.util.Random;

/**
 * Created by Dima on 19.07.2015.
 */
public class ShuffleSort implements Sort<Integer> {
    Integer[] input;
    Boolean decs;

    public ShuffleSort() {
    }

    public ShuffleSort(Integer[] input, Boolean decs) {
        this.input = input;
        this.decs = decs;
    }

    @Override
    public Integer[] sort(Integer[] input, Boolean desc) {
        for (int i = 0; i < input.length; i++) {
            Random random = new Random();
            int r = random.nextInt(i + 1);
            swap(input, i, r);
        }
        return input;
    }

    @Override
    public Integer[] start() {
        return sort(input, decs);
    }
}
