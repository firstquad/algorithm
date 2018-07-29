package ru.firstquad.algorithm.structure;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by DVFirstov 29.07.18
 */
public class TriesTest {

    @Test
    public void testAdd() {
        Tries t = new Tries();
        for (String s : Arrays.asList("test", "testing", "teta", "mock", "mockito", "executor")) {
            t.add(s);
        }
        assertEquals(1, t.childrenCount("e"));
        assertEquals(2, t.childrenCount("mo"));
        assertEquals(3, t.childrenCount("te"));
    }
}
