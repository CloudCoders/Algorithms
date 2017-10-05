package eda.sorting;

/**
 * Created by ConradoMateu on 13/04/16.
 */
public class QuickSort {
    // Exchange 2 elements in an array


    private static <T extends Comparable<T>> void quicksort(T v[], int left, int right) {
        if(left<right){
            int indexP = partition(v,left,right);
            quicksort(v, left, indexP - 1);
            quicksort(v, indexP + 1, right );

        }

    }

    public static <T extends Comparable<T>> void quicksort(T v[]){

        quicksort(v,0,v.length-1);
    }
    private static <T> void exchange(T v[], int index1, int index2){
        T temp = v[index1];
        v[index1] = v[index2];
        v[index2] = v[index1];
    }

    private static <T extends Comparable<T>>
    int partition(T v[], int izq, int der ) {
        T pivot = median3(v,izq,der);
        int i=izq;
        int j=der-1;
        while (i<j) {
            while(pivot.compareTo(v[++i])>0);
            while(pivot.compareTo(v[--j])<0);
            exchange(v,i,j);
        }
        exchange(v,i,j);     // deshacer el ultimo cambio
        exchange(v,i,der-1); // restaurar el pivote
        return i;
    }

    private static <T extends Comparable<T>> T median3(T v[], int left, int right){

        int mid =(left+right)/2;
        if(v[mid].compareTo(v[left])<0){exchange(v,left,mid);}
        if(v[right].compareTo(v[left])<0){exchange(v,left,right);}
        if(v[right].compareTo(v[mid])<0){exchange(v,mid,right);}

        //hide pivot
        exchange(v,mid,right-1);
        return v[right-1];
    }

}
