package dsa.graphs.model;

import dsa.queue.ArrayQueue;
import dsa.queue.model.Queue;

import java.util.List;

/**
 * Created by JoseLlorens on 19/05/2016.
 */
public interface Graph <E> {

    //Adding a new vetex into the graph
    public boolean add(E e);

    //Conect two vertex with and edge. If not indicated weight will be set to 1
    public boolean connect (E origin, E destination);
    public boolean connect (E origin, E destination, double weight);

    public List<E> getInwardEdges(E vertex);

    public List<E> getOutwardEdges(E vertex);

    public List<E> getConnectedVertices(E vertex);

    public int size();

    public double getDistance(E origin, E dest);
    public List<E> getPathBetween(E origin,E dest);

}
