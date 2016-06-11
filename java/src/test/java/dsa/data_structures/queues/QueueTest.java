package dsa.data_structures.queues;

import dsa.queue.QueueFactory;
import dsa.queue.model.Queue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class QueueTest {

    private String queueClassName;

    public QueueTest(String className){
        this.queueClassName = className;
    }

    @Test
    public void should_return_first_when_retrieving_first_element() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class queueClass = Class.forName(queueClassName);
        Constructor constructor = queueClass.getConstructor();
        Queue queue = (Queue) constructor.newInstance();
        queue.add("First");
        queue.add("Second");
        queue.add("Third");
        assertEquals(queue.element(),"First");
    }

    @Test
    public void should_return_second_when_removing_and_retrieving()throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException{
        Class queueClass = Class.forName(queueClassName);
        Constructor constructor = queueClass.getConstructor();
        Queue queue = (Queue) constructor.newInstance();
        queue.add("First");
        queue.add("Second");
        queue.add("Third");
        queue.remove();
        assertEquals(queue.element(),"Second");
    }

    @Test
    public void should_duplicate_array_length_correctly()throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException{
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
    public void shouls_return_second_when_peek()throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException{
        Class queueClass = Class.forName(queueClassName);
        Constructor constructor = queueClass.getConstructor();
        Queue queue = (Queue) constructor.newInstance();
        queue.add("First");
        queue.add("Second");
        queue.add("Third");
        queue.remove();
        assertEquals(queue.poll(),"Second");
    }

    public void shouls_return_third_when_peek()throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException{
        Class queueClass = Class.forName(queueClassName);
        Constructor constructor = queueClass.getConstructor();
        Queue queue = (Queue) constructor.newInstance();
        queue.add("First");
        queue.add("Second");
        queue.add("Third");
        queue.remove();
        queue.remove();
        assertEquals(queue.peek(),"Third");
    }

    @Parameterized.Parameters(name = "{index}: {0}")
    public static Collection data() {
        return new QueueFactory().create();
    }
}
