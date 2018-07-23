package ru.firstquad.algorithm.util;

import java.util.Random;

/**
 * Created by Dima on 19.07.2015.
 */
public class AlgorithmUtils {

    public static int[] shuffle(int[] input, Boolean desc) {
        for (int i = 0; i < input.length; i++) {
            Random random = new Random();
            int r = random.nextInt(i + 1);
            swap(input, i, r);
        }
        return input;
    }

    public static void swap(int[] input, int i, int j) {
        Integer temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
