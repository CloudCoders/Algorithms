package eda.sorting;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by JoseManuel on 19/04/2016.
 */
public class QuickSort<T extends Comparable<T>> implements Sorting<T> {

    public <T extends Comparable<T>> void sort(T[]arr){
        sort(arr,0,arr.length-1);
    }

    public <T extends Comparable<T>> void sort (T[]arr,int i, int j){
        if(i>=j){
            return;
        }
        int initiali = i;
        int initialj =j;
        int half = (j+i)/2;
        T pivot = arr[i];

        while(i<=j){

            while(arr[i].compareTo(pivot)<0){
                i++;
            }
            while(arr[j].compareTo(pivot)>0){
                j--;
            }

            if(i<=j) {
                exchange(arr, i, j);
                i++;
                j--;
            }

        }
        sort(arr,initiali,j);
        sort(arr,i,initialj);
    }
    public static <T extends Comparable<T>> void exchange (T[]arr,int i, int j){
        T aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }




}
