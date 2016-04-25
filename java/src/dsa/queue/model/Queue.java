package dsa.queue.model;

/**
 * Created by JoseLlorens on 20/04/2016.
 */
public interface Queue<T> {

    void add(T x);

    T element();

    T peek();

    T poll();

    T remove();

    void removeAll();

    interface Factory{
        java.util.List<String> create();
    }
}
