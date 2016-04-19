package problems.problems2

class CarlosImp implements ExamMarks{
    /**
     * Return number of marks greater than a mark in marks array.
     *
     * @param h All mark's exam, h is ordered h[i] <= h[i+1]
     * @param mark a mark exam
     * @return number of marks greater than a one mark
     */
    int numberOfMarks(int[] h, int mark){
        return numberOfMarks(h, mark, 0, h.length-1);
    }
    
    int numberOfMarks(int[] h, int mark, int start, int end){
        if (start <= end) {
            int half = (start + end)/2;
            if (v[half] > mark) {
                int i = half -1;
                for (; i < ini; i--)
                    if (v[i] <= mark) break;
                return end + 1 - i +1;
            } else
                return numberOfMarks(h, mark, half+1, end);
        }
        return 0;
    }
    
    int numberOfMarks(int[] h, int mark, int start, int end){
        if (start <= end) {
            int half = (start + end)/2;
            if (v[half] > mark) {
                return 1 + numberOfMarks(h, mark, start, half-1) + numberOfMarks(h, mark, half+1, end);
            } else
                return numberOfMarks(h, mark, half+1, end);
        }
        return 0;
    }
}
