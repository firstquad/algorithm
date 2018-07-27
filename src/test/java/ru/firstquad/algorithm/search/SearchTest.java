package ru.firstquad.algorithm.search;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class SearchTest {
    private final int[] input = {1, 2, 2, 3, 4, 4, 5, 6, 7, 7, 9, 9};

    @Test
    public void binarySearch() {
        assertTrue(BinarySearch.search(input, 5) > -1);
    }
}