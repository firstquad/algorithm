package ru.firstquad.algorithm.util;

import ru.firstquad.algorithm.search.Search;
import ru.firstquad.algorithm.sort.Sort;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Created by dmitriy on 17/09/16.
 */
public class AlgorithmRunner {

    public static <T extends Comparable> T[] run(Sort<T> sort, T[] input, Boolean desc) {
        System.out.println(sort.getClass().getSimpleName() + " run.");
        long start = System.nanoTime();
        T[] result = sort.sort(input, desc);
        System.out.println("Result: " + Arrays.toString(result));
        System.out.println("Time elapsed: " + countElapsedTime(start) + " ms");
        return result;
    }

    public static <T extends Comparable> Integer run(Search<T> search, T[] input, T value) {
        System.out.println(search.getClass().getSimpleName() + " run.");
        long start = System.nanoTime();
        Integer result = search.search(input, value);
        System.out.println("Result: " + result);
        System.out.println("Time elapsed: " + countElapsedTime(start) + " ms");
        return result;
    }

    private static long countElapsedTime(long start) {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
    }

}
