package problems.problem2;

public class CarlosImp implements ExamMarks{

    /**
     * Return number of marks greater than a mark in marks array.
     *
     * @param h All mark's exam, h is ordered h[i] <= h[i+1]
     * @param mark a mark exam
     * @return number of marks greater than a one mark
     */
    public int numberOfMarks(int[] h, int mark){
        return numberOfMarks(h, mark, 0, h.length-1);
    }
    
    public int numberOfMarks(int[] h, int mark, int start, int end){
        if (start <= end) {
            int half = (start + end)/2;
            if (h[half] > mark) {
                int i = half -1;
                while (i > start && h[i] > mark)
                    i--;
                return end - i + 2;
            } else
                return numberOfMarks(h, mark, half+1, end);
        }
        return 0;
    }
}
