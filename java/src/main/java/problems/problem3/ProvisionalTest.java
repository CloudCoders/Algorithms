package problems.problem3;

/**
 * Created by JoseLlorens on 11/06/2016.
 */
public class ProvisionalTest {
    public static void main(String[] args){
        JoseLlorensImp<String> graph = new JoseLlorensImp<>();
        graph.add("Root");
        graph.add("One");
        graph.add("Two");
        graph.add("Three");
        graph.add("Four");
        graph.connect("Root","One");
        graph.connect("Root","Three");
        graph.connect("One","Two");
        graph.connect("Three","Four");
        System.out.println("Must return TRUE and return: "+graph.checkProblem3());
        graph.connect("One","Root");
        System.out.println("Must return FALSE and return: "+graph.checkProblem3());

    }
}
