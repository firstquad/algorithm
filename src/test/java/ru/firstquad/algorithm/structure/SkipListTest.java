package ru.firstquad.algorithm.structure;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by DVFirstov 29.07.18
 */
public class SkipListTest {

    @Test
    public void add() {
        SkipList l = new SkipList();
        l.add(4);
        l.add(3);
        l.add(5);
        l.add(8);
        l.add(9);
        Assert.assertTrue(l.contains(8));
        Assert.assertTrue(l.contains(3));
    }
}