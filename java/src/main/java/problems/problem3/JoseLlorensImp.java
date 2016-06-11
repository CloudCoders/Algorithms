package problems.problem3;

import dsa.graphs.DirectedGraph;
import dsa.graphs.model.PairVertexDistance;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by JoseLlorens on 11/06/2016.
 */
public class JoseLlorensImp<E> extends DirectedGraph<E> {

    public boolean checkProblem3(){

        int numberOfVertex = vertices.size(), counter = 0;

        Map<E,Integer> inwardsGrade = new Hashtable<E,Integer>();
        for(E vertex : vertices){
            inwardsGrade.put(vertex,0);
        }

        for(E vertex : vertices){
            if(vertexAdjacents.containsKey(vertex)){
                List<PairVertexDistance<E>> adjacents = (List<PairVertexDistance<E>>) vertexAdjacents.get(vertex);
                for(PairVertexDistance adjacent : adjacents){
                    int inwardGrade = inwardsGrade.get(adjacent.getVertex());
                    inwardGrade++;
                    inwardsGrade.put((E)adjacent.getVertex(),inwardGrade);
                    counter++;
                    if(inwardGrade>1){
                        return false;
                    }
                }
            }
        }
        return counter == numberOfVertex-1;
    }
}
