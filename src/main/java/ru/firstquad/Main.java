package ru.firstquad;

import ru.firstquad.algorithm.sort.impl.InsertionSort;

import java.util.stream.IntStream;

import static ru.firstquad.algorithm.util.AlgorithmRunner.run;

/**
 * Created by Dima on 20.06.2015.
 */
public class Main {

    public static void main(String[] args) {
        Integer[] input = {5, 2, 4, 9, 7, 1, 3, 6, 2, 4, 9, 7};
        Integer[] in = IntStream.range(-10000, 10000).boxed().toArray(Integer[]::new);
        String[] inString = {"1", "2", "3", "4", "5"};

        run(new InsertionSort<>(), inString, true);
    }
}
