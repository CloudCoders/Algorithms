
package dsa.sorting;

/**
 * @author jose.llorens.ripolles@gmail.com
 */

public class MergeSort<T extends Comparable<T>> implements Sorting<T> {


    public <T extends Comparable<T>> void sort(T[] ar) {
        sort(ar, 0, ar.length - 1);
    }

    public <T extends Comparable<T>> void sort(T[] ar, int i, int f) {
        if (i < f) {
            int m = (i + f) / 2;
            sort(ar, i, m);
            sort(ar, m + 1, f);
            merge(ar, i, f, m);
        }
    }

    public <T extends Comparable<T>> void merge(T[] ar, int i, int f, int m) {
        if (i >= f) {
            return;
        }
        T[] aux = (T[]) new Comparable[f - i + 1];
        int k = 0, a = i, b = m + 1;
        while (a <= m && b <= f) {

            if (ar[a].compareTo(ar[b]) <= 0) {
                aux[k] = ar[a];
                k++;
                a++;
            } else {
                aux[k] = ar[b];
                k++;
                b++;
            }
        }
        while (a <= m) {
            aux[k] = ar[a];
            k++;
            a++;
        }
        while (b <= f) {
            aux[k] = ar[b];
            k++;
            b++;
        }
        for (k = 0; k < aux.length; k++) {
            ar[i] = aux[k];
            i++;

        }
    }

}
