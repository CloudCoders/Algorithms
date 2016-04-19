package eda.sorting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
/**
 * Created by JoseLlorens on 19/04/2016.
 */
public class InsertionSortTest {
    @Test
    public void test_random(){
        Integer[] h = new Integer[500];
        for(int i = 0; i<h.length;i++){
            h[i] = (int) Math.random()*100;
        }
        Integer[]res = Arrays.copyOf(h,h.length);
        Arrays.sort(res);
        assertArrayEquals(res,h);
    }
}
