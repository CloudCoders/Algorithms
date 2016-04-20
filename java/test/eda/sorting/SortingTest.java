package eda.sorting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class SortingTest {

    private Sorting sortingTest;

    public SortingTest(Sorting sortingTest) {
        this.sortingTest = sortingTest;
    }

    @Test
    public void test_random(){
        Integer[] h = new Integer[50000];
        for(int i = 0; i<h.length;i++){
            h[i] = (int) Math.random()*100;
        }
        Integer[]res = Arrays.copyOf(h,h.length);
        Arrays.sort(res);
        assertArrayEquals(res,h);
    }

    @Test
    public void test_sorted_ascending_array(){
        Integer[] h = new Integer[50000];
        for(int i=0;i<h.length;i++){
            h[i]=i;
        }
        Integer[]res = Arrays.copyOf(h,h.length);
        Arrays.sort(res);
        assertArrayEquals(res,h);
    }
    @Test
    public void test_sorted_descending_array(){
        Integer[] h = new Integer[50000];
        for(int i=h.length-1;i>=0;i--){
            h[i]=i;
        }
        Integer[]res = Arrays.copyOf(h,h.length);
        Arrays.sort(res);
        assertArrayEquals(res,h);
    }
    @Test
    public void all_equals_array(){
        Integer[] h = new Integer[50000];
        for(int i =0;i<h.length;i++){
            h[i] = 0;
        }
    }
    @Test
    public void test_mostly_sorted_ascending_array(){
        Integer[] h = new Integer[50000];
        for(int i=0;i<h.length;i++){
            h[i]=i + (int) Math.random()*10;
        }
        Integer[]res = Arrays.copyOf(h,h.length);
        Arrays.sort(res);
        assertArrayEquals(res,h);
    }
    @Test
    public void test_mostly_sorted_descending_array(){
        Integer[] h = new Integer[50000];
        for(int i=h.length-1;i>=0;i--){
            h[i]=i-(int)Math.random()*10;
        }
        Integer[]res = Arrays.copyOf(h,h.length);
        Arrays.sort(res);
        assertArrayEquals(res,h);
    }

    @Parameterized.Parameters(name = "{index}: {0}")
    public static Collection data() {
        return new SortingFactory().create();
    }

}