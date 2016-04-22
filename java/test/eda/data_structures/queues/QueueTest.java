package eda.data_structures.queues;

import eda.data_structures.models.Queue;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by JoseLlorens on 23/04/2016.
 */
public class QueueTest {

    @Test
    public void shoul_return_jose(){
        Queue<String> queue = new ArrayQueue<String>();
        queue.add("Jose");
        queue.add("Llorens");
        queue.add("Ripolles");
        assertEquals(queue.element(),"Jose");
    }

    @Test
    public void shoul_return_llorens(){
        Queue<String> queue = new ArrayQueue<String>();
        queue.add("Jose");
        queue.add("Llorens");
        queue.add("Ripolles");
        queue.remove();
        assertEquals(queue.element(),"Llorens");
    }

    @Test
    public void should_duplicate_length_correctly(){
        Queue<String> queue = new ArrayQueue<String>(2);
        queue.add("Jose");
        queue.add("Llorens");
        queue.add("Ripolles");
        queue.remove();
        queue.remove();
        assertEquals(queue.element(),"Ripolles");

    }
}
