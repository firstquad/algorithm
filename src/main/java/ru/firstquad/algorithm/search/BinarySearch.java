package ru.firstquad.algorithm.search;

/**
 * Created by Dima on 21.06.2015.
 */
public class BinarySearch implements Search<Integer> {
    Integer[] input;
    Integer value;

    public BinarySearch(Integer[] input, Integer value) {
        this.input = input;
        this.value = value;
    }

    public Integer search(Integer[] input, Integer value) {
        int low = 0;
        int high = input.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int mVal = input[mid];
            if (mVal > value)
                high = mid - 1;
            else if (mVal < value)
                low = mid + 1;
            else {
                return mid;
            }
        }
        return null;
    }


    public Integer[] start() {
        return new Integer[]{search(input, value)};
    }
}
