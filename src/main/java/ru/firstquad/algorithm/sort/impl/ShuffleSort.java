package ru.firstquad.algorithm.sort.impl;

import ru.firstquad.algorithm.sort.Sort;

import java.util.Random;

/**
 * Created by Dima on 19.07.2015.
 */
public class ShuffleSort<T extends Comparable> implements Sort<T> {

    @Override
    public T[] sort(T[] input, Boolean desc) {
        for (int i = 0; i < input.length; i++) {
            Random random = new Random();
            int r = random.nextInt(i + 1);
            swap(input, i, r);
        }
        return input;
    }
}
