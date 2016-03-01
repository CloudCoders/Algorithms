package eda.linear;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by toni on 24/02/16.
 */
public class ArrayQeueTest {

    @Test
    public void testIsEmpty(){
        ArrayQeue<Integer> array = new ArrayQeue<>(10);
        assertTrue(array.isEmpty());
    }

    @Test
    public void testAdd(){
        ArrayQeue<Integer> array = new ArrayQeue<>(10);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        array.add(7);
        array.add(8);
        array.add(9);
        array.add(10);
        array.add(11);
        array.add(12);
        assertFalse(array.isEmpty());
        System.out.println(array.toString());
    }
}