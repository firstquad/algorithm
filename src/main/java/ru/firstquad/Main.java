package ru.firstquad;

import ru.firstquad.algorithm.sort.InsertionSort;
import static ru.firstquad.algorithm.util.AlgorithmPrinter.*;

/**
 * Created by Dima on 20.06.2015.
 */
public class Main {

    public static void main(String[] args) {
        Integer[] input = {5, 2, 4, 9, 7, 1, 3, 6};
        print(new InsertionSort(input, true));
        print(new InsertionSort(input, false));


    }
}
