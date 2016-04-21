package eda.FIFO;

import eda.FIFO.model.Queue;

public class ArrayQueue<T> implements Queue<T> {

    private T[] array;
    private int size;

    public ArrayQueue(int maxSize) {
        this.array = (T[]) new Object[maxSize];
    }

    @Override
    public void add(T e) {
        if (size != array.length){
            this.array[size] = e;
            size++;
        }
    }

    @Override
    public T poll() {
        T elem = array[0];
        for (int i = 1; i < size; i++){
            array[i-1] = array[i];
        }
        size--;
        return elem;
    }

    @Override
    public T peek() {
        return array[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < size; i++){
            result += ("["+array[i]+"] ");
        }
        return result;
    }
}
