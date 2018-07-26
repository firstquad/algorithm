package ru.firstquad.algorithm.task;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by DVFirstov 26.07.18
 */
public class PaintBrushTest {

    @Test
    public void brush() {
        int[][] m = new int[10][10];
        m[3][3] = 1;
        m[3][4] = 1;
        m[4][4] = 1;
        m[4][5] = 1;
        m[5][5] = 1;
        print(m);
        int[][] expected = new int[m.length][m.length];
        for (int i = 0; i < m.length; i++) {
            System.arraycopy(m[i], 0, expected[i], 0, m.length);
        }
        expected[3][3] = 2;
        expected[3][4] = 2;
        expected[4][4] = 2;
        expected[4][5] = 2;
        expected[5][5] = 2;

        PaintBrush.brush(m, 5, 5, 2);

        for (int i = 0; i < m.length; i++) {
            assertArrayEquals(expected[i], m[i]);
        }
        print(m);
    }

    private void print(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}