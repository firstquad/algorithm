import org.junit.Test;
import ru.firstquad.algorithm.sort.MergeSort;

import static ru.firstquad.algorithm.util.AlgorithmPrinter.print;

/**
 * Created by Dima on 17.08.2015.
 */
public class MergeSortTest {

    @Test
    public void testSort() {
        Integer[] input = new Integer[]{5, 9, 4, 1, 8, 6, 8, 0, 3, 6, 4};
        print(new MergeSort(input, true));
    }
}
