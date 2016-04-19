package problems.problem2;

import java.util.Arrays;
import java.util.List;

public class JoseLlorensImp implements ExamMarks {
    public int numberOfMarks(int[] marks, int mark){
        return numberOfMarks(marks,0,marks.length-1,mark);
    }

    public int numberOfMarks(int[]marks , int i, int j, int mark){
        if(i>j) return 0 ;
        int half = (i+j)/2;
        if(marks[half]>mark){
            return (j-half+1)+numberOfMarks(marks,i,half-1,mark);
        }else{
            return numberOfMarks(marks,half+1,j,mark);
        }

    }
}
