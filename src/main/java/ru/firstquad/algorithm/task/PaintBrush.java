package ru.firstquad.algorithm.task;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by DVFirstov 26.07.18
 */
public class PaintBrush {

    public static void brush(int[][] m, int x, int y, int color) {
        if (x < 0 || x > m.length - 1
                || y < 0 || y > m[0].length - 1)
            return;

        Deque<Pixel> neighs = new ArrayDeque<>();
        neighs.push(new Pixel(x, y, m[x][y]));

        while (!neighs.isEmpty()) {
            Pixel p = neighs.poll();
            if (p == null)
                continue;
            for (int i = p.x - 1; i <= p.x + 1; i++) {
                for (int j = p.y - 1; j <= p.y + 1; j++) {
                    if (p.x == i && p.y == j
                            || i < 0 || i > m.length - 1
                            || j < 0 || j > m[0].length - 1) {
                        continue;
                    }
                    if (p.color == m[i][j]) {
                        neighs.push(new Pixel(i, j, p.color));
                    }
                }
            }
            m[p.x][p.y] = color;
        }
    }

    public static class Pixel {
        int x;
        int y;
        int color;

        public Pixel(int x, int y, int color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}
