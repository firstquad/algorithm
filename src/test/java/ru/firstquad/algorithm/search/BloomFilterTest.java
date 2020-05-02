package ru.firstquad.algorithm.search;

import org.junit.Test;

/**
 * Created by DVFirstov 29.07.18
 */
public class BloomFilterTest {

    @Test
    public void add() {
        BloomFilter bf = new BloomFilter(100.0, 100, 100);
        bf.add("abc");
        bf.add("bc");
        bf.add("ac");
        System.out.println(bf.contains("DWDW"));
    }

    @Test
    public void test2() throws Exception {
        BloomFilter b = new BloomFilter(100.0, 100, 100);
        b.add("13");

    }
}