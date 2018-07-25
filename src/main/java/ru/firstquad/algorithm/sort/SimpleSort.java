package ru.firstquad.algorithm.sort;

import static ru.firstquad.algorithm.util.AlgorithmUtils.swap;

/**
 * Created by Dima on 23.07.2018.
 */
public class SimpleSort {

    public static int[] bubbleSort(int[] in) {
        for (int i = 0; i < in.length - 1; i++) {
            for (int j = 0; j < in.length - i - 1; j++) {
                if (in[j] > in[j + 1]) {
                    int tmp = in[j + 1];
                    in[j + 1] = in[j];
                    in[j] = tmp;
                }
            }
        }
        return in;
    }

    public static int[] insertionSort(int[] in) {
        for (int i = 1; i < in.length; i++) {
            int value = in[i];
            int hole = i;
            while (hole > 0 && in[hole - 1] > value) {
                in[hole] = in[hole - 1];
                hole--;
            }
            in[hole] = value;
        }
        return in;
    }

    public static int[] selectionSort(int[] in) {
        for (int i = 0; i < in.length; i++) {
            int least = i;
            for (int j = i + 1; j < in.length; j++) {
                if (in[j] < in[least]) {
                    least = j;
                }
            }

            int tmp = in[i];
            in[i] = in[least];
            in[least] = tmp;
        }
        return in;
    }

    public static int[] shellSort(int[] input) {
        int size = input.length;
        int h = 1;
        while (h < size / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < size; i++) {
                for (int j = i; j >= h && input[j] < input[j - h]; j -= h) {
                    swap(input, j, j - 1);
                }
            }
            h = h / 3;
        }
        return input;
    }

    public static int[] countingSort(int[] in) {
        int[] tmp = new int[in.length];

        for (int n : in) {
            ++tmp[n];
        }

        int b = 0;
        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < tmp[i]; j++) {
                in[b] = i;
                b++;
            }
        }

        return in;
    }
}
