package eda.data_structures.queues;

import eda.data_structures.basic.Node;
import eda.data_structures.models.Queue;

/**
 * Created by JoseLlorens on 23/04/2016.
 */
public class LLQueue<T> implements Queue<T> {
    Node<T> head;
    Node<T> tail;

    public LLQueue(){
        head=null;
        tail=null;
    }

    @Override
    public void add(T x) {
        Node<T> newNode = new Node(x,null);
        if(head==null){
            head = newNode;
        }
        if(tail!=null){
            tail.setNext(newNode);
        }
        tail=newNode;


    }

    @Override
    public T element() {
        return head.getObject();
    }

    @Override
    public T peek() {
        if(head!=null){
            return element();
        }else{
            return null;
        }
    }

    @Override
    public T poll() {
        if(head!=null) {
            return remove();
        }else{
            return null;
        }
    }

    @Override
    public T remove() {
        Node<T> res = head;
        head = head.getNext();
        return res.getObject();
    }

    @Override
    public void removeAll() {
        head=null;
        tail=null;
    }
}
