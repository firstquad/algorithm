package ru.firstquad.algorithm.task;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SymmetryLine {

    public static boolean isSymmetryLineExists(Point[] points) {
        Arrays.sort(points);
        float xs = (points[0].x + points[points.length - 1].x) / 2;
        List<Point> less = new ArrayList<>();
        List<Point> greater = new ArrayList<>();
        for (Point p : points) {
            if (xs == p.x)
                continue;
            if (xs > p.x) {
                less.add(p);
            } else {
                greater.add(p);
            }
        }

        if (less.size() != greater.size())
            return false;

        for (Point p : less) {
            if (!greater.contains(new Point((int) (2 * xs - p.x), p.y)))
                return false;
        }
        return true;
    }

    public static class Point implements Comparable<Point> {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point p) {
            return Integer.compare(x, p.x);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
