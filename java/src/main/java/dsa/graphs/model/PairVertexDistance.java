package dsa.graphs.model;

import java.util.Collection;

/**
 * Created by JoseLlorens on 09/06/2016.
 */
public class PairVertexDistance <E> implements Comparable<PairVertexDistance<E>> {
    private E vertex;
    private double distance;

    public PairVertexDistance(E vertex, double distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    public E getVertex() {
        return vertex;
    }

    public void setVertex(E vertex) {
        this.vertex = vertex;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String toString(){
        String res="["+this.getVertex()+","+this.getDistance()+"] -> ";
        return res;
    }


    @Override
    public int compareTo(PairVertexDistance<E> o) {
        if(this.getDistance()<o.getDistance()){
            return -1;
        }else{
            if(this.getDistance()>o.getDistance()){
                return 1;
            }else{
                return 0;
            }
        }
    }
}
