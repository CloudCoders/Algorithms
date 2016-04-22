package eda.data_structures.models;

/**
 * Created by JoseLlorens on 20/04/2016.
 */
public interface Queue<T> {

    void add(T x);

    T element();


    T peek();

    T poll();

    T remove();
}