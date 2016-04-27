package problems.problem2;

/**
 * Created by PedroDavidLP on 27/4/16.
 */
public class PedroImp implements ExamMarks {
    @Override
    public int numberOfMarks(int[] h, int mark) {
        int ini=0;
        int fin=h.length-1;
        int mitad;
        while (ini<fin){
            mitad=(ini+fin)/2;
            if (mark>h[mitad] && mark < h[mitad + 1]){
                return h.length-mitad;
            } else if(mark>h[mitad]){
                if(mitad % 2 ==0){
                    ini=mitad+2;
                }else {
                    ini=mitad+1;
                }
            } else if (mark < h[mitad]){
                fin = mitad;
            } else {
                return h.length-1-mitad;
            }
        }
        return  h.length-ini;
    }


}
