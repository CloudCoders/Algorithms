/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

import java.util.Scanner;
import Sorting.Mergesort;

/**
 *
 * @author JoseLlorens
 */
public class MergeTest {
    public static void main(String [] args){
        Scanner kb = new Scanner(System.in);
        System.out.println("indica la talla del vector: ");
        int t = kb.nextInt();
        int [] ar = new int [t];
        for(int i =0 ; i< t; i++){
            ar[i] = 100 * (int) Math.random();
        }
        Libraries1.Utilities.printArray(ar);
        Sorting.Mergesort(ar);
        Libraries1.Utilities.printArray(ar);
    }
    
}
