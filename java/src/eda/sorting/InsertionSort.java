package eda.sorting;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by JoseManuel on 19/04/2016.
 */
public class InsertionSort<T extends Comparable<T>> implements Sorting<T> {
    public static <T extends Comparable<T>> void sort(T[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        T aux;
        for(int i = 1;i<arr.length;i++){
            aux=arr[i];
            int j;
            for(j = i-1;j>=0 && arr[j].compareTo(aux)>0;j--){
                arr[j+1]=arr[j];
            }
            arr[j+1]=aux;
        }
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
                InsertionSort.sort(arr);
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
