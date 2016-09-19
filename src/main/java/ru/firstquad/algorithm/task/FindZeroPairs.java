package ru.firstquad.algorithm.task;

import ru.firstquad.algorithm.search.impl.BinarySearch;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by dmitriy on 17/09/16.
 */
public class FindZeroPairs {

    public static void main(String[] args) {
        Integer[] in = IntStream.range(-10000, 10000).boxed().toArray(Integer[]::new);
        long start = System.currentTimeMillis();
        countQuadratic(in);
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        countBinary(in);
        System.out.println(System.currentTimeMillis() - start);

    }

    private static void countQuadratic(Integer[] in) {
        int count = 0;
        for (int i = 0; i < in.length; i++) {
            for (int j = i + 1; j < in.length; j++) {
                if (in[i] + in[j] == 0)
                    count++;
            }
        }
        System.out.println(count);
    }

    private static void countBinary(Integer[] in) {
        Arrays.sort(in);
        int count = 0;
        for (int i = 0; i < in.length; i++) {
            if (new BinarySearch().search(in, -in[i]).compareTo(i) > 0)
                count++;
        }
        System.out.println(count);
    }


}
