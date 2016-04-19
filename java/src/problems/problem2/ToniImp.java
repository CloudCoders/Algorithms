package problems.problem2;

public class ToniImp implements ExamMarks {

    public int numberOfMarks(int[] h, int mark){

        int ini = 0;
        int fin = h.length-1;

        if (h.length > 0 && h[ini]>mark) return h.length;

        for (int i = (ini+fin)/2; i < fin; i = (ini+fin)/2){
            if (h[i] <= mark){
                if (h[i+1] > mark){
                    return h.length - (i+1);
                }else{
                    ini = i+1;
                }
            }else{
                fin = i;
            }
        }

        return 0;
    }
}
