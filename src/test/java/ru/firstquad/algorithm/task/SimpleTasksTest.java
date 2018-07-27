package ru.firstquad.algorithm.task;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.*;

public class SimpleTasksTest {
    private final int[] input = {5, 2, 4, 9, 7, 1, 3, 6, 2, 4, 9, 7};

    @Test
    public void testFindSum() {
        assertEquals(new ArrayList<>(asList(5, 4, 4, 2, 2, 1)), SimpleTasks.findSum(input, 6));
        assertEquals(new ArrayList<>(asList(5, 4, 4, 2, 2, 1)), SimpleTasks.findSum(input, 2));
    }

    @Test
    public void testGreatestDivisor() {
        assertEquals(1, SimpleTasks.greatestDivisor(1, 5));
        assertEquals(5, SimpleTasks.greatestDivisor(10, 5));
        assertEquals(0, SimpleTasks.greatestDivisor(0, 5));
    }

    @Test
    public void testSimpleNumbers() {
        assertEquals(new ArrayList<>(asList(19, 17, 13, 11, 7, 5, 3)), SimpleTasks.simpleNumbers(20));
        assertEquals(new ArrayList<>(singletonList(1)), SimpleTasks.simpleNumbers(1));
    }

    @Test
    public void testSumN() {
        assertEquals(15, SimpleTasks.sumN(50505, 0));
        assertEquals(3, SimpleTasks.sumN(10101, 0));
        assertEquals(1, SimpleTasks.sumN(1, 0));
        assertEquals(1, SimpleTasks.sumN(10, 0));
    }

    @Test
    public void testFact() {
        assertEquals(120, SimpleTasks.fact(5, 1));
        assertEquals(2, SimpleTasks.fact(2, 1));
    }

    @Test
    public void testPoli() {
        assertFalse(SimpleTasks.poli("teststest"));
        assertTrue(SimpleTasks.poli("teststset"));
    }

    @Test
    public void testCompressString() {
        assertEquals("a3b2cdf4", SimpleTasks.compressString("aaabbcdffff"));
        assertEquals("a3", SimpleTasks.compressString("aaa"));
        assertEquals("", SimpleTasks.compressString(""));
    }

    @Test
    public void testCountAnagramm() {
        System.out.println(SimpleTasks.countAnagramm(Arrays.asList("abc", "bca", "cba", "cdf", "dfc", "def")));
    }

    @Test
    public void testCacheSorted() {
        List<Integer> cache = new ArrayList<>();
        Arrays.asList(2, 4, 5, 2, 6, 7, 3, 2, 4, 5, 2, 6, 7, 3)
                .forEach(i -> SimpleTasks.cacheSorted(cache, i));
        assertEquals(Arrays.asList(7, 7, 6, 6, 5), cache);
    }
}
