package ru.firstquad.algorithm.search.impl;

import ru.firstquad.algorithm.search.Search;

/**
 * Created by Dima on 21.06.2015.
 */
public class BinarySearch<T extends Comparable> implements Search<T> {

    @Override
    @SuppressWarnings("unchecked")
    public Integer search(T[] input, T value) {
        int low = 0;
        int high = input.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            T mVal = input[mid];
            if (mVal.compareTo(value) > 0)
                high = mid - 1;
            else if (mVal.compareTo(value) < 0)
                low = mid + 1;
            else {
                return mid;
            }
        }
        return -1;
    }

}
