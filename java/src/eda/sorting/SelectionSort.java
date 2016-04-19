package eda.sorting;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by JoseManuel on 19/04/2016.
 */
public class SelectionSort implements Sorting {
    public static <T extends Comparable<T>> void sort(T[] arr){
        int min;
        for(int i = 0;i<arr.length;i++){
            min = i;
            for(int j=i;j<arr.length;j++){
               if(arr[j].compareTo(arr[min])<0){
                   min = j;
               }
            }
            exchange(arr, min,i );
        }
    }
    public static <T extends Comparable<T>> void exchange(T[] arr,int  i,int j){
        T aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }

    public static void main(String[]args){
        boolean error=true;
        while(error) {
            try {
                error = false;
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Length of the array ?");
                int len = keyboard.nextInt();
                Integer[] arr = new Integer[len];
                for(int i =0 ; i<len;i++){
                    arr[i] = (int) (Math.random()*100);
                }
                printArray(arr);
                SelectionSort.sort(arr);
                printArray(arr);
            }catch(InputMismatchException e){
                System.out.println("For length it's only admitted a Integer");
                error=true;
            }
        }
    }
    private static<T extends Comparable<T>> void printArray(T[] arr){
        for(int i = 0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("\n");
    }
}

