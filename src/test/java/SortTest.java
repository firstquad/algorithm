import org.junit.Test;
import ru.firstquad.algorithm.sort.MergeSort;
import ru.firstquad.algorithm.sort.QuickSort;
import ru.firstquad.algorithm.sort.RadixSort;
import ru.firstquad.algorithm.sort.SimpleSort;

import static org.junit.Assert.assertArrayEquals;

public class SortTest {
    private final int[] input = {5, 2, 4, 9, 7, 1, 3, 6, 2, 4, 9, 7};
    private final int[] expected = {1, 2, 2, 3, 4, 4, 5, 6, 7, 7, 9, 9};


    @Test
    public void testBubble() {
        assertArrayEquals(expected, SimpleSort.bubbleSort(input));
    }

    @Test
    public void testInsertionSort() {
        assertArrayEquals(expected, SimpleSort.insertionSort(input));
    }

    @Test
    public void testSelectionSort() {
        assertArrayEquals(expected, SimpleSort.selectionSort(input));
    }

    @Test
    public void testShellSort() {
        assertArrayEquals(expected, SimpleSort.shellSort(input));
    }

    @Test
    public void testCountingSort() {
        assertArrayEquals(expected, SimpleSort.countingSort(input));
    }

    @Test
    public void testMergeSort() {
        assertArrayEquals(expected, MergeSort.sort(input));
    }

    @Test
    public void testQuickSort() {
        assertArrayEquals(expected, QuickSort.sort(input));
    }

    @Test
    public void testRadixSort() {
        assertArrayEquals(expected, RadixSort.sort(input));
    }
}
