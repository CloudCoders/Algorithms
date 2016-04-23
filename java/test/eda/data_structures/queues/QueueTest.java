package eda.data_structures.queues;

import eda.data_structures.models.Queue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import problems.problem2.ExamMarksFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by JoseLlorens on 23/04/2016.
 */

@RunWith(value = Parameterized.class)
public class QueueTest {

    private String queueClassName;

    public QueueTest(String className){
        this.queueClassName = className;
    }

    @Test
    public void shoul_return_jose() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class queueClass = Class.forName(queueClassName);
        Constructor constructor = queueClass.getConstructor();
        Queue queue = (Queue) constructor.newInstance();
        queue.add("Jose");
        queue.add("Llorens");
        queue.add("Ripolles");
        assertEquals(queue.element(),"Jose");
    }

    @Test
    public void shoul_return_llorens()throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException{
        Class queueClass = Class.forName(queueClassName);
        Constructor constructor = queueClass.getConstructor();
        Queue queue = (Queue) constructor.newInstance();
        queue.add("Jose");
        queue.add("Llorens");
        queue.add("Ripolles");
        queue.remove();
        assertEquals(queue.element(),"Llorens");
    }

    @Test
    public void should_duplicate_length_correctly()throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException{
        Class queueClass = Class.forName(queueClassName);
        Constructor constructor = queueClass.getConstructor();
        Queue queue = (Queue) constructor.newInstance();
        for(int i = 0; i<=50;i++){
            queue.add(i);
        }
        queue.remove();
        queue.remove();
        assertEquals(queue.element(),2);
    }

    @Test
    public void should_return_null_when_peek_in_empty_queue()throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException{
        Class queueClass = Class.forName(queueClassName);
        Constructor constructor = queueClass.getConstructor();
        Queue queue = (Queue) constructor.newInstance();
        assertEquals(queue.peek(),null);
    }

    @Test
    public void should_return_null_when_poll_in_empty_queue()throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException{
        Class queueClass = Class.forName(queueClassName);
        Constructor constructor = queueClass.getConstructor();
        Queue queue = (Queue) constructor.newInstance();
        assertEquals(queue.poll(),null);
    }

    @Test
    public void shouls_return_llorens_when_peek()throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException{
        Class queueClass = Class.forName(queueClassName);
        Constructor constructor = queueClass.getConstructor();
        Queue queue = (Queue) constructor.newInstance();
        queue.add("Jose");
        queue.add("Llorens");
        queue.add("Ripolles");
        queue.remove();
        assertEquals(queue.poll(),"Llorens");
    }

    public void shouls_return_Ripolles_when_peek()throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException{
        Class queueClass = Class.forName(queueClassName);
        Constructor constructor = queueClass.getConstructor();
        Queue queue = (Queue) constructor.newInstance();
        queue.add("Jose");
        queue.add("Llorens");
        queue.add("Ripolles");
        queue.remove();
        queue.remove();
        assertEquals(queue.peek(),"Llorens");
    }

    @Parameterized.Parameters(name = "{index}: {0}")
    public static Collection data() {
        return new QueueFactory().create();
    }
}
