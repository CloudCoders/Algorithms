package dsa.graphs;

import dsa.graphs.model.Graph;
import dsa.graphs.model.PairVertexDistance;
import dsa.map.HashTable;

import java.util.*;

/**
 * Created by JoseLlorens on 09/06/2016.
 */
public class DirectedGraph<E> implements Graph<E> {

    //List to keep all our vertex
    List<E> vertices = new ArrayList<>(100);


    //A map to keep each vertex linked to their adjacents
    Map vertexAdjacents = (Map) new Hashtable<E,PairVertexDistance<E>>();






    @Override
    public boolean add(E e) {
        if(!vertices.contains(e)){
            vertices.add(e);
            return true;
        }
        return false;
    }

    @Override
    public boolean connect(E origin, E destination) {
        if(!vertices.contains(origin)|| !vertices.contains(destination)){
            return false;
        }

        return connect(origin,destination,1);
    }

    @Override
    public boolean connect(E origin, E destination, double weight) {
        if(!vertexAdjacents.containsKey(origin)){
            PairVertexDistance<E> pair = new PairVertexDistance<E>(destination,weight);
            List<PairVertexDistance<E>> list = new ArrayList<PairVertexDistance<E>>();
            list.add(pair);
            vertexAdjacents.put(origin,list);
            return true;
        }else{
            PairVertexDistance<E> pair = new PairVertexDistance<E>(destination, weight);
            List<PairVertexDistance<E>> list = (List<PairVertexDistance<E>>) vertexAdjacents.get(origin);
            boolean exitLoop = false;
            for (int i = 0; !exitLoop && i < list.size(); i++) {
                if (list.get(i).getVertex().equals(destination)) {
                    list.remove(i);
                    exitLoop = true;
                }
            }
            list.add(pair);
            vertexAdjacents.put(origin, list);
            return true;
        }

    }

    @Override
    public List<E> getInwardEdges(E vertex) {
        List<E> ret = new ArrayList<>();
        for(E actualVertex : vertices){
            List<PairVertexDistance<E>> adjacents = (List<PairVertexDistance<E>>) vertexAdjacents.get(actualVertex);
            for(PairVertexDistance<E> pairVertexDistance : adjacents){
                if(pairVertexDistance.getVertex().equals(vertex)){
                    ret.add(actualVertex);
                }
            }
        }
        return ret;
    }

    @Override
    public List<E> getOutwardEdges(E vertex) {
        List<PairVertexDistance<E>> pairs = (List<PairVertexDistance<E>>) vertexAdjacents.get(vertex);
        List<E> vertices = new ArrayList<>();
        for(PairVertexDistance<E> pair : pairs){
            vertices.add(pair.getVertex());
        }
        return vertices;
    }

    @Override
    public List<E> getConnectedVertices(E origin) {


        List<E> connectedVertices = new ArrayList<>();

        //Create a map vertex-boolean to keep track of vertices we've already visited (So to avoid duplicities)
        Map<E,Boolean> visited = new Hashtable<>();

        //Insert all vertex and init their value to false;
        for(E vertex : vertices){
            visited.put(vertex,false);
        }



        getConnectedVertices(origin,connectedVertices,visited);


        return connectedVertices;
    }

    private List<E> getConnectedVertices(E vertex,List<E> connectedVertices,Map<E,Boolean> visited){
        //Set the vertex as visited
        visited.put(vertex,true);

        //Add the vertex to the list of connectedVertices
        connectedVertices.add(vertex);


        if(vertexAdjacents.containsKey(vertex)) {
            List<PairVertexDistance<E>> adjacents = (List<PairVertexDistance<E>>) vertexAdjacents.get(vertex);

            for (int i = 0; i < adjacents.size(); i++) {
                if (!visited.get(adjacents.get(i).getVertex())) {
                    getConnectedVertices(adjacents.get(i).getVertex(), connectedVertices, visited);
                }
            }
        }




        return connectedVertices;
    }

    @Override
    public int size() {
        return vertices.size();
    }


    @Override
    public double getDistance(E origin, E dest) {
        Map<E,E> minPath = new Hashtable<>() ;
        Map<E,Double> distance = new Hashtable<>() ;
        dijkstra(origin, minPath,distance);
        if(distance.containsKey(dest)){
            return distance.get(dest);
        }
        return Double.MAX_VALUE;
    }

    @Override
    public List<E> getPathBetween(E origin, E dest) {

        List<E> path = new ArrayList<>();

        Map<E,E> minPath = new Hashtable<>() ;
        Map<E,Double> distance = new Hashtable<>() ;
        dijkstra(origin, minPath,distance);
        if(!minPath.containsKey(dest)){
            return null;
        }

        E actualVertex = dest;
        while(minPath.get(actualVertex).equals(actualVertex)){
            path.add(actualVertex);
            actualVertex=minPath.get(actualVertex);
        }
        path.add(actualVertex);
        return path;
    }

    private void dijkstra(E origin, Map<E, E> minPath, Map<E, Double> distance) {

        Map<E,Boolean> visited =  new Hashtable<>();
        PriorityQueue<PairVertexDistance<E>> priorityQueue = new PriorityQueue<>();

        for(E vertex : vertices){
            minPath.put(vertex,vertex);
            distance.put(vertex,Double.MAX_VALUE);
            visited.put(vertex,false);
        }

        minPath.put(origin,origin);
        distance.put(origin,0.0);

        priorityQueue.add(new PairVertexDistance<E>(origin,0));

        while(!priorityQueue.isEmpty()){
            E vertex = priorityQueue.remove().getVertex();

            if(!visited.get(vertex)){
                visited.put(vertex,true);
                if(vertexAdjacents.containsKey(vertex)) {
                    List<PairVertexDistance<E>> adjacents = (List<PairVertexDistance<E>>) vertexAdjacents.get(vertex);
                    for (int i = 0; i < adjacents.size(); i++) {
                        E destination = adjacents.get(i).getVertex();
                        double distanceToDest = adjacents.get(i).getDistance();
                        if (distance.get(destination) > (distance.get(vertex) + distanceToDest)) {
                            distance.put(destination, (distance.get(vertex) + distanceToDest));
                            minPath.put(destination, origin);
                            priorityQueue.add(new PairVertexDistance<E>(destination, distance.get(destination)));
                        }
                    }
                }
            }
        }
    }

    public String toString(){
        String res="";
        for(E vertex : vertices){
            if(vertexAdjacents.containsKey(vertex)) {
                res += vertex + ":  ";
                List<PairVertexDistance<E>> list = (List<PairVertexDistance<E>>) vertexAdjacents.get(vertex);
                for (int i = 0; i < list.size(); i++) {
                    res += "[" + list.get(i).getVertex() + "," + list.get(i).getDistance() + "] -> ";
                }
                res += "\n";
            }
        }
        return res;
    }
}
