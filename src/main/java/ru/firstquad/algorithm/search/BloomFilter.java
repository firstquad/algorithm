package ru.firstquad.algorithm.search;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;

/**
 * Created by DVFirstov 29.07.18
 */
public class BloomFilter {
    private static final MessageDigest digestFunction;

    static {
        try {
            digestFunction = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private BitSet bitSet;
    private int countHashes;
    private int bitSetSize;

    public BloomFilter(double c, int n, int countHashes) {
        this.bitSetSize = (int) Math.ceil(c * n);
        this.countHashes = countHashes;
        this.bitSet = new BitSet(bitSetSize);
    }

    public void add(String value) {
        int[] hashes = hash(value.getBytes(), countHashes);
        for (int h : hashes) {
            bitSet.set(Math.abs(h % bitSetSize), true);
        }
    }

    public boolean contains(String value) {
        int[] hashes = hash(value.getBytes(), countHashes);
        for (int h : hashes) {
            if (!bitSet.get(Math.abs(h % bitSetSize))) {
                return false;
            }
        }
        return true;
    }

    private int[] hash(byte[] value, int k) {
        int[] result = new int[k];
        byte[] digest = digestFunction.digest(value);
        for (int i = 0; i < k; i++) {
            int h = 0;
            for (byte b : digest) {
                h |= b;
            }
            result[i] = h;
        }
        return result;
    }

    private class Bit {
        private int[] bits;

        public void set(int index) {
            bits[Math.floorDiv(index, 32)] |= 1 << (index % 32);
        }

        public boolean test(int index) {
            return 1 == ((bits[Math.floorDiv(index, 32)] >>> (index % 32)) & 1);
        }
    }

    public static void testalsdfj() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("tes{t");
            }

        }
    }
}
