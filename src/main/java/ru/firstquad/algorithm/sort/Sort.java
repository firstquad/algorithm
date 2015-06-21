package ru.firstquad.algorithm.sort;

import ru.firstquad.algorithm.Algorithm;

/**
 * Created by Dima on 20.06.2015.
 */
public interface Sort<T> extends Algorithm {

    T[] sort(T[] input, Boolean desc);

}
