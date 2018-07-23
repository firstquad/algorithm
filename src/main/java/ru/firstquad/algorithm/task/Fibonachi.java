package ru.firstquad.algorithm.task;

public class Fibonachi {

    public static int fib(int i) {
        if (i <= 2)
            return 1;
        return fib(i - 1) + fib(i - 2);
    }


    public static int fibMemo(int i, int[] memo) {
        if (i <= 2)
            return 1;
        if (memo[i - 1] != 0) {
            return memo[i - 1];
        }
        int f = fibMemo(i - 1, memo) + fibMemo(i - 2, memo);
        memo[i - 1] = f;
        return f;
    }

    public static int fibIter(int i) {
        if (i <= 2)
            return 1;
        int res = 0;
        int a = 1;
        int b = 1;
        for (int j = 2; j < i; j++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }

}
