package eda.linear;

import eda.FIFO.ArrayQueue;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ArrayQueueTest {

    @Test
    public void testIsEmpty(){
        ArrayQueue<Integer> array = new ArrayQueue<>(10);
        assertTrue(array.isEmpty());
    }

    @Test
    public void testAdd(){
        ArrayQueue<Integer> array = new ArrayQueue<>(10);
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