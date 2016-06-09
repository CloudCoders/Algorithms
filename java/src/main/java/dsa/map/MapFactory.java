package dsa.map;

import dsa.map.model.Map;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by JoseLlorens on 25/04/2016.
 */
public class MapFactory implements Map.Factory{
    @Override
    public List<String> create() {
        return Arrays.asList("dsa.map.HashTable");
    }
}
