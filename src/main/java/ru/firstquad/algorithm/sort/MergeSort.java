package ru.firstquad.algorithm.sort;

/**
 * Created by Dima on 19.07.2015.
 */
public class MergeSort implements Sort<Integer> {
    Integer[] input;
    Boolean decs;

    public MergeSort(Integer[] input, Boolean decs) {
        this.input = input;
        this.decs = decs;
    }

    /*
    * N*log(N)
    * for hige input
    * c(N) = C(N/2) + C(N/2) + N
    *        first    second   merge
    *        half     half
    * */
    @Override
    public Integer[] sort(Integer[] input, Boolean desc) {
        Integer[] aux = new Integer[input.length];
        sort(input, aux, 0, input.length - 1);
        return input;
    }

    @Override
    public Integer[] start() {
        return sort(input, decs);
    }

    private void sort(Integer[] a, Integer[] aux, int lo, int hi) {
        if (hi <= lo)
            return;
        //optimize for tiny arrays
        int CUTOFF = 7;
        if (hi <= lo + CUTOFF - 1)
            new InsertionSort().sort(a, false);
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public void merge(Integer[] a, Integer[] aux, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, hi);
        //copy
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }
        //merge
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (aux[j] < aux[i])
                a[k] = aux[j++];
            else
                a[k] = aux[i++];

        }
        assert isSorted(a, lo, hi);
    }

    private boolean isSorted(Integer[] a, int lo, int hi) {
        for (int i = lo; i < hi - 1; i++) {
            if (a[i] > a[i + 1])
                return false;
        }
        return true;
    }
}
