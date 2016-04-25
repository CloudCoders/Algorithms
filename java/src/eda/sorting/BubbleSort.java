package eda.sorting;

public class BubbleSort <T extends Comparable<T>> implements Sorting<T>{

    /**
     *  Compare pairs of adjacent elements and if they are disordered swap them
     *  until they are ordered. The execution time of the algorithm is O(n^2).
     * @param arr Array to order
     */
    public <T extends Comparable<T>> void sort(T[] arr) {
        T aux;
        for(int i=0; i<arr.length-1; i++)
            for(int j=0; j<arr.length-i-1; j++)
                if(arr[j+1].compareTo(arr[j]) < 0){
                    aux = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j]=aux;
                }
    }
}

