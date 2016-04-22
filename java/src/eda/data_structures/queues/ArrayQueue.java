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
        elements=0;
    }
    public ArrayQueue (int length){
        array = (T[]) new Object[length];
        head = 0;
        tail = 0;
        elements = 0;
    }

    @Override
    public void add(T x) {
        if(elements<array.length) {
            array[tail] = x;
            tail = inc(tail);
            elements++;
        }else{
            duplicateArray();
            add(x);
        }
    }

    @Override
    public T element() {
        return array[head];
    }



    @Override
    public T peek() {
        if(!isEmpty()){
            return element();
        }else{
            return null;
        }
    }

    @Override
    public T poll() {
        if(!isEmpty()){
            return remove();
        }else{
            return null;
        }
    }

    @Override
    public T remove() {
        T aux = array[head];
        head = inc(head);
        elements--;
        return aux;
    }

    private int inc(int i){
        return (i+1)%array.length;
    }

    private boolean isEmpty(){
        return this.elements==0;
    }

    //Mirar be si tail te que ser elements o elements-1
    private void duplicateArray(){
        T[] newArray = (T[]) new Object[array.length*2];
        for(int j=0;j<elements;j++){
            newArray[j] = array[head];
            head=inc(head);
        }
        array=newArray;
        head=0;
        tail=elements;
    }

}
