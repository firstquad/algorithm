package ru.firstquad;

import ru.firstquad.algorithm.func.Recursive;
import ru.firstquad.algorithm.search.BinarySearch;
import ru.firstquad.algorithm.sort.InsertionSort;

import java.util.*;
import java.util.List;

import static ru.firstquad.algorithm.util.AlgorithmPrinter.*;

/**
 * Created by Dima on 20.06.2015.
 */
public class Main {

    public static void main(String[] args) {
//        Integer[] input = {5, 2, 4, 9, 7, 1, 3, 6};
        Integer[] input = {1, 5, 5, 7};
//        print(new InsertionSort(input, true));
//        print(new InsertionSort(input, false));
        print(new BinarySearch(input, 5));

//        List<String> dirs = Recursive.getDirs("D:/Work/java/projects/GIT/firstquad/algorithm/src/main/java/ru/firstquad/algorithm/func", new ArrayList<String>());
//        for (String s: dirs) {
//            System.out.println(s);
//        }
    }
}
