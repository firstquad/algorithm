package ru.firstquad.algorithm.search;

import ru.firstquad.algorithm.Algorithm;

/**
 * Created by Dima on 20.06.2015.
 */
public interface Search<T> extends Algorithm {

    T search(T[] input, T value);

}
