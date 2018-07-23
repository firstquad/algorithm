package ru.firstquad.algorithm.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleTasks {

    public static List<Integer> findSum(int[] m, int sum) {
        Arrays.sort(m);
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < m.length; i++) {
            int a = m[i];
            int b = sum - a;
            int bIndex = Arrays.binarySearch(m, b);
            if (bIndex >= 0 && bIndex != i) {
                tmp.add(b);
            }
        }
        return tmp;
    }

    public static int greatestDivisor(int a, int b) {
        int min = a > b ? b : a;
        while (a % min != 0 || b % min != 0) {
            min--;
        }
        return min;
    }

    public static List<Integer> simpleNumbers(int n) {
        List<Integer> r = new ArrayList<>();
        while (n > 2) {
            int divisor = n - 1;
            int count = 0;
            while (count < 1 && divisor > 1) {
                if (n % divisor == 0) {
                    count++;
                }
                divisor--;
            }
            if (count == 0)
                r.add(n);
            n--;
        }
        return r;
    }

    public static int sumN(int n, int sum) {
        int digit = n % 10;
        if (n < 10)
            return sum + n;
        int r = Math.floorDiv(n, 10);
        return sumN(r, sum + digit);
    }

    public static boolean poli(String in) {
        if (in.length() < 2)
            return true;
        String s = in.substring(0, 1);
        String e = in.substring(in.length() - 1, in.length());
        if (!s.equalsIgnoreCase(e))
            return false;
        return poli(in.substring(1, in.length() - 1));
    }

    public static int fact(int n, int r) {
        if (n == 0)
            return r;
        return fact(n - 1, r * n);
    }
}
