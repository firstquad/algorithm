package ru.firstquad.algorithm.search;

/**
 * Created by Dima on 20.06.2015.
 */
public interface Search<T extends Comparable> {

    Integer search(T[] input, T value);

}
