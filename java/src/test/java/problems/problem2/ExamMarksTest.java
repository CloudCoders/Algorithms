package problems.problem2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class ExamMarksTest {

    private ExamMarks examMarksTest;

    public ExamMarksTest(ExamMarks examMarksTest) {
        this.examMarksTest = examMarksTest;
    }

    @Test
    public void
    should_return_zero_when_are_not_marks_greater_than_a_one_mark() {
        int[] h = new int[]{2, 3, 3, 4, 5, 6};

        assertEquals(0, examMarksTest.numberOfMarks(h, 7));
    }

    @Test
    public void
    should_return_the_number_of_marks_greater_than_a_mark() {
        int[] h = new int[]{2, 3, 3, 4, 5, 6};

        assertEquals(2, examMarksTest.numberOfMarks(h, 4));
    }

    @Test
    public void
    should_return_zero_when_the_length_of_array_is_zero() {
        int[] h = new int[]{};

        assertEquals(0, examMarksTest.numberOfMarks(h, 4));
    }

    @Test
    public void
    should_return_the_length_of_the_marks_array() {
        int[] h = new int[]{5, 6, 6, 6, 7, 8, 9};

        assertEquals(h.length, examMarksTest.numberOfMarks(h, 2));
    }

    @Parameterized.Parameters(name = "{index}: {0}")
    public static Collection data() {
        return new ExamMarksFactory().create();
    }

}