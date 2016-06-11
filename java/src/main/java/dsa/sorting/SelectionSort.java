package dsa.sorting;

/**
 * Created by JoseManuel on 19/04/2016.
 */
public class SelectionSort<T extends Comparable<T>> implements Sorting<T> {
    public <T extends Comparable<T>> void sort(T[] arr) {
        int min;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[min]) < 0) {
                    min = j;
                }
            }
            exchange(arr, min, i);
        }
    }

    public <T> void exchange(T[] arr, int i, int j) {
        T aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }


}

