package eda.sorting;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ConradoMateu on 13/04/16.
 */
public class QuickSortTest {
    @Test
    public void test(){
        int[] v = new int[7];
        v[0] = 5;
        v[1] = 4;
        v[2] = 7;
        v[3] = 8;
        v[4] = 10;
        v[5] = 1;
        v[6] = 9;

        QuickSort ne = new QuickSort<Integer>();


        QuickSort<Integer>(v);
        assertEquals(1, v[0]);
    }



}