package eda.sorting;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ConradoMateu on 13/04/16.
 */
public class QuickSortTest {
    @Test
    public void test(){
        Integer[] v = new Integer[7];

        v[0] = 5;
        v[1] = 4;
        v[2] = 7;
        v[3] = 8;
        v[4] = 10;
        v[5] = 1;
        v[6] = 9;

        QuickSort.<Integer>quicksort(v);

        assertEquals(new Integer(1), v[0]);
    }



}