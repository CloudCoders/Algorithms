package eda.data_structures.queues;

import eda.data_structures.models.Queue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import problems.problem2.ExamMarksFactory;

import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by JoseLlorens on 23/04/2016.
 */

@RunWith(value = Parameterized.class)
public class QueueTest {

    private Queue queue;

    public QueueTest(Queue queue){
        this.queue = queue;
    }

    @Test
    public void shoul_return_jose(){
        queue.add("Jose");
        queue.add("Llorens");
        queue.add("Ripolles");
        assertEquals(queue.element(),"Jose");
        queue.removeAll();
    }

    @Test
    public void shoul_return_llorens(){
        queue.add("Jose");
        queue.add("Llorens");
        queue.add("Ripolles");
        queue.remove();
        assertEquals(queue.element(),"Llorens");
        queue.removeAll();
    }

    @Test
    public void should_duplicate_length_correctly(){
        for(int i = 0; i<=50;i++){
            queue.add(i);
        }
        queue.remove();
        queue.remove();
        assertEquals(queue.element(),2);
        queue.removeAll();
    }

    @Test
    public void should_return_null_when_peek_in_empty_queue(){
        assertEquals(queue.peek(),null);
        queue.removeAll();
    }

    @Test
    public void should_return_null_when_poll_in_empty_queue(){
        assertEquals(queue.poll(),null);
        queue.removeAll();
    }

    @Test
    public void shouls_return_llorens_when_peek(){
        queue.add("Jose");
        queue.add("Llorens");
        queue.add("Ripolles");
        queue.remove();
        assertEquals(queue.poll(),"Llorens");
        queue.removeAll();
    }

    public void shouls_return_Ripolles_when_peek(){
        queue.add("Jose");
        queue.add("Llorens");
        queue.add("Ripolles");
        queue.remove();
        queue.remove();
        assertEquals(queue.peek(),"Llorens");
        queue.removeAll();
    }

    @Parameterized.Parameters(name = "{index}: {0}")
    public static Collection data() {
        return new QueueFactory().create();
    }
}
