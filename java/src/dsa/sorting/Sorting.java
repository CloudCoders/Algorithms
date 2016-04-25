package dsa.sorting;

import java.util.List;

/**
 * Created by JoseManuel on 19/04/2016.
 */
public interface Sorting<T extends Comparable<T>> {
    public <T extends Comparable<T>> void sort(T[] arr);

    interface Factory {
        List<Sorting> create();
    }
}
