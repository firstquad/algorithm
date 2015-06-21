package ru.firstquad.algorithm.util;

import ru.firstquad.algorithm.Algorithm;

/**
 * Created by Dima on 20.06.2015.
 */
public class AlgorithmPrinter {

    public static void print(Algorithm algorithm) {
        long startTime = System.nanoTime();
        for (Object t : algorithm.start()) {
            System.out.print(t + " ");
        }
        long time = (System.nanoTime() - startTime) / 1000;
        System.out.println("\nTime elapsed: " + String.valueOf(time));
    }
}
