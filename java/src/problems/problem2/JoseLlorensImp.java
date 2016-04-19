package problems.problem2;

public class JoseLlorensImp implements ExamMarks {

    public int numberOfMarks(int[] marks, int mark) {
        return numberOfMarks(marks, 0, marks.length - 1, mark);
    }

<<<<<<< HEAD
    public int numberOfMarks(int[]marks , int i, int j, int mark){
        if(i>j) return 0 ;
        int half = (i+j)/2;
        if(marks[half]>mark){
            return (j-half+1)+numberOfMarks(marks,i,half-1,mark);
        }else{
            return numberOfMarks(marks,half+1,j,mark);
=======
    private int numberOfMarks(int[] marks, int i, int j, int mark) {
        if (i > j) return 0;
        int half = (i + j) / 2;

        if (marks[half] > mark) {
            return (j - half + 1) + numberOfMarks(marks, i, half - 1, mark);
        } else {
            return numberOfMarks(marks, half + 1, j, mark);
>>>>>>> f35b2eb1f41f0a24228f6579a3da94d8b2525025
        }

    }

}
