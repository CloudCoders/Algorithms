package problems.problem2;

import java.util.List;

public interface ExamMarks {
    /**
     * Return number of marks greater than a mark in marks array.
     *
     * @param h All mark's exam, h is ordered h[i] <= h[i+1]
     * @param mark a mark exam
     * @return number of marks greater than a one mark
     */
    int numberOfMarks(int[] h, int mark);

    interface Factory {
        List<ExamMarks> create();
    }
}
