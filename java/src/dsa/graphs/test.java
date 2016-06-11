package dsa.graphs;

import dsa.graphs.model.Graph;
import dsa.graphs.model.PairVertexDistance;

import java.util.PriorityQueue;

/**
 * Created by JoseLlorens on 09/06/2016.
 */
public class test {
    public static void main(String[] args) {
        Graph<String> graph = new DirectedGraph<>();
        graph.add("Hola");
        graph.add("Mundo");
        graph.add("Jose");
        graph.add("LOL");
        graph.connect("Jose","Mundo",6);
        graph.connect("Jose","Hola",7);
        graph.connect("Mundo","LOL",8);
        graph.connect("Hola","LOL",1);
        graph.connect("LOL","Hola",1);

        System.out.println(graph.getDistance("Mundo","Hola"));
    }
}
