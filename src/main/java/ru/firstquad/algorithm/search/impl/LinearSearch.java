package ru.firstquad.algorithm.search.impl;

import ru.firstquad.algorithm.search.Search;

/**
 * Created by Dima on 21.06.2015.
 */
public class LinearSearch<T extends Comparable> implements Search<T> {

    @Override
    public Integer search(T[] input, T value) {
        for (int i = 0; i < input.length; i++) {
            if (input[i].equals(value))
                return i;
        }
        return -1;
    }

}
