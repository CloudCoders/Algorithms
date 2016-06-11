package dsa.sorting;

/**
 * Created by JoseManuel on 19/04/2016.
 */
public class InsertionSort<T extends Comparable<T>> implements Sorting<T> {
    public <T extends Comparable<T>> void sort(T[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        T aux;
        for (int i = 1; i < arr.length; i++) {
            aux = arr[i];
            int j;
            for (j = i - 1; j >= 0 && arr[j].compareTo(aux) > 0; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = aux;
        }
    }

}
