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
            incTail();
            elements++;
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
        incHead();
        elements--;
        return aux;
    }

    private void incHead(){
         head = (head+1)%array.length;
    }

    private void incTail(){
        tail = (tail+1)%array.length;
    }
    private boolean isEmpty(){
        return this.elements==0;
    }


    //not well implemented, fix it after exam
    private void duplicateArray(){
        T[] newArray = (T[]) new Object[array.length*2];
        for(int i = 0;i<array.length;i++){
            newArray[i]=array[i];
        }
    }

}
