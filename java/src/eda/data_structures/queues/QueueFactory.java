package eda.data_structures.queues;

import eda.data_structures.models.Queue;

import java.util.Arrays;
import java.util.List;

/**
 * Created by JoseLlorens on 23/04/2016.
 */
public class QueueFactory implements Queue.Factory{
    @Override
    public List<String> create() {
        return Arrays.asList("eda.data_structures.queues.ArrayQueue","eda.data_structures.queues.LLQueue");
    }
}
