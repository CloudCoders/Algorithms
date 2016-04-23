package eda.data_structures.basic;

/**
 * Created by JoseLlorens on 20/04/2016.
 */
public class Node<T> {
    private T object;
    private Node<T> next;

    public Node(T x){
        object=x;
        next=null ;
    }

    public  Node(T x, Node n){
        this.object = x;
        this.next=n;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
