package ru.firstquad.algorithm.dynamic;

/**
 * Created by DVFirstov
 */
public class FibonacciDP {


    public static Integer memoization(int n) {
        Integer[] m = new Integer[n];
        return memoization(n, m);
    }

    public static Integer memoization(int n, Integer[] m) {
        if (m[n] == null) {
            if (n <= 1) {
                m[n] = n;
            } else {
                m[n] = memoization(n - 1, m) + memoization(n - 2, m);
            }
        }
        return m[n];
    }
}
