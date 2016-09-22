package ru.firstquad.algorithm.task;

import ru.firstquad.algorithm.search.impl.BinarySearch;

import java.util.stream.IntStream;

/**
 * Created by dmitriy on 19/09/16.
 */
public class FindZeroThree {

    public static void main(String[] args) {
        Integer[] in = IntStream.range(-1000, 1000).boxed().toArray(Integer[]::new);
        long start = System.currentTimeMillis();
        countNaive(in);
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        countLog(in);
        System.out.println(System.currentTimeMillis() - start);
    }

    private static void countNaive(Integer[] in) {
        int count = 0;
        for (int i = 0; i < in.length; i++) {
            for (int j = i + 1; j < in.length; j++) {
                for (int k = j + 1; k < in.length; k++) {
                    if (in[i] + in[j] + in[k] == 0)
                        count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void countLog(Integer[] in) {
        int count = 0;
        for (int i = 0; i < in.length; i++) {
            for (int j = i + 1; j < in.length; j++) {
                if (new BinarySearch<>().search(in, -in[i] - in[j]) > j)
                    count++;
            }
        }
        System.out.println(count);
    }
}
