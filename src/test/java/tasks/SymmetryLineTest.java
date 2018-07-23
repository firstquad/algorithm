package tasks;

import org.junit.Assert;
import org.junit.Test;
import ru.firstquad.algorithm.task.SymmetryLine;

import static org.junit.Assert.assertTrue;

public class SymmetryLineTest {

    @Test
    public void testSymmetryLineTrue() {
        SymmetryLine.Point[] points = new SymmetryLine.Point[]{
                new SymmetryLine.Point(-1, 1),
                new SymmetryLine.Point(-1, -1),
                new SymmetryLine.Point(1, 2),
                new SymmetryLine.Point(2, 2),
                new SymmetryLine.Point(2, -1),
                new SymmetryLine.Point(0, -1),
                new SymmetryLine.Point(0, 2),
                new SymmetryLine.Point(3, -1),
                new SymmetryLine.Point(3, 1)};

        assertTrue(SymmetryLine.isSymmetryLineExists(points));
    }

    @Test
    public void testSymmetryLineFalse() {
        SymmetryLine.Point[] points = new SymmetryLine.Point[]{
                new SymmetryLine.Point(-1, 1),
                new SymmetryLine.Point(1, 2),
                new SymmetryLine.Point(2, 2),
                new SymmetryLine.Point(2, -1),
                new SymmetryLine.Point(0, -1),
                new SymmetryLine.Point(0, 2),
                new SymmetryLine.Point(3, -1),
                new SymmetryLine.Point(3, 1)};

        Assert.assertFalse(SymmetryLine.isSymmetryLineExists(points));
    }
}
