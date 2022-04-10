package ru.firstquad.algorithm.task;

import java.util.*;

public class SimpleTasks {

    /**
     * {3, 4, 5, 7, 1, 2}, 5 -> {3, 2, 4, 1}
     */
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

    /**
     * 3, 9 -> 3
     */
    public static int greatestDivisor(int a, int b) {
        int min = a > b ? b : a;
        if (min == 0)
            return min;
        while (a % min != 0 || b % min != 0) {
            min--;
        }
        return min;
    }

    /**
     * 8 -> {7, 5, 3, 1}
     */
    public static List<Integer> simpleNumbers(int n) {
        List<Integer> r = new ArrayList<>();
        if (n == 1) {
            r.add(n);
            return r;
        }
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
        r.add(1);
        return r;
    }

    /**
     * 1001002 -> 4
     */
    public static int sumN(int n, int sum) {
        int digit = n % 10;
        if (n < 10)
            return sum + n;
        int r = Math.floorDiv(n, 10);
        return sumN(r, sum + digit);
    }

    /**
     * abcba -> true
     */
    public static boolean poli(String in) {
        if (in.length() < 2)
            return true;
        String s = in.substring(0, 1);
        String e = in.substring(in.length() - 1);
        if (!s.equalsIgnoreCase(e))
            return false;
        return poli(in.substring(1, in.length() - 1));
    }

    /**
     * abcba -> true
     */
    public static boolean poliIter(String in) {
        if (in.length() < 2)
            return true;
        char[] c = in.toCharArray();
        while (c.length > 1) {
            char a = c[0];
            char b = c[c.length - 1];
            if (a != b) {
                return false;
            }
            char[] tmp = new char[c.length - 2];
            System.arraycopy(c, 1, tmp, 0, tmp.length);
            c = tmp;
        }
        return true;
    }

    /**
     * 5 -> 120
     */
    public static int fact(int n, int r) {
        if (n == 0)
            return r;
        return fact(n - 1, r * n);
    }

    public static int factIter(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    /**
     * aaabbcdffff -> a3b2cdf4
     */
    public static String compressString(String s) {
        if (s.isEmpty())
            return s;
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int tmp = 1;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                tmp++;
            } else {
                sb.append(chars[i]);
                if (tmp > 1) {
                    sb.append(tmp);
                }
                tmp = 1;
            }
        }
        sb.append(chars[chars.length - 1]);
        if (tmp > 1) {
            sb.append(tmp);
        }
        return sb.toString();
    }

    /**
     * "abc", "bca", "cbf" -> {"abc", {"abc", "bca"}}, {"cbf", {"cbf"}}
     */
    public static Map<String, List<String>> countAnagramm(List<String> in) {
        Map<String, List<String>> out = new HashMap<>();
        for (String s : in) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (out.containsKey(key)) {
                out.get(key).add(s);
            } else {
                List<String> strings = new ArrayList<>();
                strings.add(s);
                out.put(key, strings);
            }
        }
        return out;
    }

    /**
     * {2, 4, 5, 2, 6, 7, 3, 2, 4, 5, 2, 6, 7, 3} -> {7, 7, 6, 6, 5}
     */
    public static List<Integer> cacheSorted(List<Integer> cache, int i) {
        cache.add(i);
        cache.sort(Comparator.reverseOrder());
        while (cache.size() > 5) {
            cache.remove(cache.size() - 1);
        }
        return cache;
    }
}
