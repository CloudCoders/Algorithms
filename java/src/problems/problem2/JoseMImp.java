package problems.problem2;

public class JoseMImp implements ExamMarks {

    /**
     * Return number of marks greater than a mark in marks array.
     *
     * @param h All mark's exam, h is ordered h[i] <= h[i+1]
     * @param mark a mark exam
     * @return number of marks greater than a one mark
     */
    public int numberOfMarks(int[] h, int mark){
        if(h.length== 0 || h[h.length-1] <= mark) return 0;
        else if(h[0] > mark) return h.length;
        else return numberOfMarks(h,mark,0,h.length-1);
    }

    private int numberOfMarks(int[] h, int mark, int left, int right){
        if(left < right){
            int c = (left+right)/2;
            if(h[c]<=mark && h[c+1]>mark) return h.length - c - 1;
            else if(h[c]>mark) return numberOfMarks(h,mark,left,c-1);
            else return numberOfMarks(h,mark,c+1,right);
        } else {
            return h.length - left - 1;
        }
    }
}