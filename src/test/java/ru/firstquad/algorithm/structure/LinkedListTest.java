package ru.firstquad.algorithm.structure;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;
import static org.junit.Assert.assertEquals;

/**
 * Created by DVFirstov 27.07.18
 */
public class LinkedListTest {
    List<Integer> input = unmodifiableList(asList(3, 5, 6, 1, 9));

    @Test
    public void testAddLast() {
        LinkedList list = new LinkedList();
        input.forEach(list::addLast);
        int j = 0;
        for (Integer i : list) {
            assertEquals(input.get(j), i);
            j++;
        }
    }

    @Test
    public void testAddFirst() {
        LinkedList list = new LinkedList();
        input.forEach(list::addFirst);
        int j = input.size() - 1;
        for (Integer i : list) {
            assertEquals(input.get(j), i);
            j--;
        }
    }

    @Test
    public void testReversed() {
        LinkedList list = new LinkedList();
        input.forEach(list::addLast);
        int j = input.size() - 1;
        for (Integer i : list.getReversed()) {
            assertEquals(input.get(j), i);
            j--;
        }
    }
}