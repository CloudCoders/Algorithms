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

        while (ini<fin) {
            mitad=(ini+fin)/2;
            if(h[mitad]<=mark){
                if(mitad%2==0){ini=mitad+2;}else{ini=mitad+1;}
            }else {
                fin=mitad;
            }

        }
        return h.length-ini;
    }


}
