package ru.firstquad.algorithm.task;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonachiTest {

    @Test
    public void testFib() {
        assertEquals(5, Fibonachi.fib(5));
        assertEquals(13, Fibonachi.fib(7));
        assertEquals(55, Fibonachi.fib(10));
    }

    @Test
    public void testFibMemo() {
        assertEquals(5, Fibonachi.fibMemo(5, new int[5]));
        assertEquals(13, Fibonachi.fibMemo(7, new int[7]));
        assertEquals(55, Fibonachi.fibMemo(10, new int[10]));
    }

    @Test
    public void testFibIter() {
        assertEquals(5, Fibonachi.fibIter(5));
        assertEquals(13, Fibonachi.fibIter(7));
        assertEquals(55, Fibonachi.fibIter(10));
    }


}
