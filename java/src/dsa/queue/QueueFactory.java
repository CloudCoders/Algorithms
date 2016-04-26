package dsa.queue;

import dsa.queue.model.Queue;

import java.util.Arrays;
import java.util.List;

/**
 * Created by JoseLlorens on 23/04/2016.
 */
public class QueueFactory implements Queue.Factory{
    @Override
    public List<String> create() {
        return Arrays.asList("dsa.queue.ArrayQueue","dsa.queue.LinkedListQueue");
    }
}
