package eda.model;

/**
 * Created by toni on 24/02/16.
 */
public interface Qeue<T> {
    void add(T e);
    T poll();
    T peek();
    boolean isEmpty();
    String toString();
}
