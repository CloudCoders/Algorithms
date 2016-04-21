package eda.FIFO.model;

public interface Queue<T> {
    void add(T e);
    T poll();
    T peek();
    boolean isEmpty();
    String toString();
}
