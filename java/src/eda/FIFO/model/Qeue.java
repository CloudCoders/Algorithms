package eda.FIFO.model;

public interface Qeue<T> {
    void add(T e);
    T poll();
    T peek();
    boolean isEmpty();
    String toString();
}
