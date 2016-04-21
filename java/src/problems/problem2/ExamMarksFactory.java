package problems.problem2;

import java.util.Arrays;
import java.util.List;

public class ExamMarksFactory implements ExamMarks.Factory {

    @Override
    public List<ExamMarks> create() {
        return Arrays.asList(new ToniImp(), new JoseLlorensImp(), new CarlosImp());
    }
}
