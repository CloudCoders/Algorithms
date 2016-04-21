package eda.data_structures.queues;

import eda.data_structures.models.Queue;

/**
 * Created by JoseLlorens on 20/04/2016.
 */
public class ArrayQueue<T> implements Queue<T>{

    T[] array ;
    int head;
    int tail;
    int elements;
    final int PREDEFYNIED_INITIAL_LENGTH = 50;

    public ArrayQueue (){
        array = (T[]) new Object[PREDEFYNIED_INITIAL_LENGTH];
        head = 0;
        tail = 0;
    }
    public ArrayQueue (int length){
        array = (T[]) new Object[length];
        head = 0;
        tail = 0;
    }

    @Override
    public void add(T x) {
        array[tail]=x;
        tail ++;
    }

    @Override
    public T element() {
        return null;
    }

    @Override
    public boolean offer(T x) {
        return true;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public T poll() {
        return null;
    }

    @Override
    public T remove() {
        return null;
    }
}
