package problems.problem2;

public class KevinImp implements ExamMarks{

    public int numberOfMarks(int[] marks, int mark){
        return numberOfMarks(marks,0,marks.length-1,mark);
    }

    public int numberOfMarks(int[]marks , int ini, int fin, int mark){
        if(ini == fin){
            if(marks[ini]>mark) return 1;
            else return 0;
        } else if(ini > fin){
            int mitad = (ini+fin)/2;
            if(marks[mitad] <= mark)
                return numberOfMarks(marks, mitad+1, fin, mark);
            else
                return numberOfMarks(marks, ini, mitad, mark) + numberOfMarks(marks, mitad+1, fin, mark);
        }
        return 0;
    }
}