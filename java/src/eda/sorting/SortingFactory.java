package eda.sorting;

import java.util.Arrays;
import java.util.List;

public class SortingFactory implements Sorting.Factory {

    @Override
    public List<Sorting> create() {
        return Arrays.asList(new InsertionSort(), new MergeSort(), new QuickSort(), new SelectionSort());
    }
}
