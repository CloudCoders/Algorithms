package dsa.map;

import dsa.map.model.Map;
import dsa.map.model.MapEntry;
import dsa.queue.QueueFactory;
import dsa.queue.model.Queue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by JoseLlorens on 25/04/2016.
 */

@RunWith(value = Parameterized.class)
public class MapTest {
    private String mapClassName;

    public MapTest(String className){
        this.mapClassName = className;
    }


    @Test
    public void should_return_mundo_when_get_world() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class mapClass = Class.forName(mapClassName);
        Constructor constructor = mapClass.getConstructor();
        Map<String,String> map = (Map) constructor.newInstance();
        map.put("Hello","Hola");
        map.put("World", "Mundo");
        map.put("First","Primero");
        map.put("Second","Segundo");
        map.put("Iorens","PutoAmo");
        assertEquals("Mundo",map.get("World"));
    }

    @Test
    public void should_return_true_when_containsKey_and_cointains_key() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class mapClass = Class.forName(mapClassName);
        Constructor constructor = mapClass.getConstructor();
        Map<String,String> map = (Map) constructor.newInstance();
        map.put("Hello","Hola");
        map.put("World", "Mundo");
        map.put("First","Primero");
        map.put("Second","Segundo");
        map.put("Iorens","PutoAmo");
        assertEquals(true,map.containsKey("First"));
    }

    @Test
    public void should_return_false_when_containsKey_and_dont_cointains_key() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class mapClass = Class.forName(mapClassName);
        Constructor constructor = mapClass.getConstructor();
        Map<String,String> map = (Map) constructor.newInstance();
        map.put("Hello","Hola");
        map.put("World", "Mundo");
        map.put("First","Primero");
        map.put("Second","Segundo");
        map.put("Iorens","PutoAmo");
        assertEquals(false,map.containsKey("Third"));
    }

    @Test
    public void should_return_true_when_containsValue_and_cointains_value() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class mapClass = Class.forName(mapClassName);
        Constructor constructor = mapClass.getConstructor();
        Map<String,String> map = (Map) constructor.newInstance();
        map.put("Hello","Hola");
        map.put("World", "Mundo");
        map.put("First","Primero");
        map.put("Second","Segundo");
        map.put("Iorens","PutoAmo");
        assertEquals(true,map.containsValue("Primero"));
    }

    @Test
    public void should_return_false_when_containsValue_and_dont_cointains_value() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class mapClass = Class.forName(mapClassName);
        Constructor constructor = mapClass.getConstructor();
        Map<String,String> map = (Map) constructor.newInstance();
        map.put("Hello","Hola");
        map.put("World", "Mundo");
        map.put("First","Primero");
        map.put("Second","Segundo");
        map.put("Iorens","PutoAmo");
        assertEquals(false,map.containsValue("Tercero"));
    }

    @Test
    public void should_return_set_of_entrys() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Set<MapEntry<String,String>> set = new HashSet<MapEntry<String,String>>();
        Class mapClass = Class.forName(mapClassName);
        Constructor constructor = mapClass.getConstructor();
        Map<String,String> map = (Map) constructor.newInstance();
        map.put("Hello","Hola");
        map.put("World", "Mundo");
        map.put("First","Primero");
        map.put("Second","Segundo");
        map.put("Iorens","PutoAmo");
        set.add(new MapEntry<String, String>("Hello","Hola"));
        set.add(new MapEntry<String, String>("World","Mundo"));
        set.add(new MapEntry<String, String>("First","Primero"));
        set.add(new MapEntry<String, String>("Second","Segundo"));
        set.add(new MapEntry<String, String>("Iorens","PutoAmo"));
        assertEquals(set,map.entrySet());

    }

    @Test
    public void should_return_true_when_equals_other_map() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class mapClass = Class.forName(mapClassName);
        Constructor constructor = mapClass.getConstructor();
        Map<String,String> map = (Map) constructor.newInstance();
        map.put("Hello","Hola");
        map.put("World", "Mundo");
        map.put("First","Primero");
        map.put("Second","Segundo");
        map.put("Iorens","PutoAmo");
        Map<String,String> otherMap = new HashTable<String,String>();
        otherMap.put("Hello","Hola");
        otherMap.put("World", "Mundo");
        otherMap.put("First","Primero");
        otherMap.put("Second","Segundo");
        otherMap.put("Iorens","PutoAmo");
        assertEquals(true,map.equals(otherMap));
    }

    @Test
    public void should_return_false_then_dont_equals_other_map() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class mapClass = Class.forName(mapClassName);
        Constructor constructor = mapClass.getConstructor();
        Map<String,String> map = (Map) constructor.newInstance();
        map.put("Hello","Hola");
        map.put("World", "Mundo");
        map.put("First","Primero");
        map.put("Second","Segundo");
        map.put("Iorens","PutoAmo");
        Map<String,String> otherMap = new HashTable<String,String>();
        otherMap.put("Hello","Hola");
        otherMap.put("World", "Mundo");
        otherMap.put("First","Primero");
        otherMap.put("Second","Segundo");
        assertEquals(false,map.equals(otherMap));
    }

    @Test
    public void should_return_hashCode_correctly() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        int reference = 0;
        Class mapClass = Class.forName(mapClassName);
        Constructor constructor = mapClass.getConstructor();
        Map<String,String> map = (Map) constructor.newInstance();
        map.put("Hello","Hola");
        map.put("World", "Mundo");
        map.put("First","Primero");
        map.put("Second","Segundo");
        map.put("Iorens","PutoAmo");
        reference +=new MapEntry<String,String>("Hello","Hola").hashCode();
        reference +=new MapEntry<String,String>("World","Mundo").hashCode();
        reference +=new MapEntry<String,String>("First","Primero").hashCode();
        reference +=new MapEntry<String,String>("Second","Segundo").hashCode();
        reference +=new MapEntry<String,String>("Iorens","PutoAmo").hashCode();
        assertEquals(reference,map.hashCode());
    }

    @Test
    public void should_return_false_when_map_not_empty() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class mapClass = Class.forName(mapClassName);
        Constructor constructor = mapClass.getConstructor();
        Map<String,String> map = (Map) constructor.newInstance();
        map.put("Hello","Hola");
        map.put("World", "Mundo");
        map.put("First","Primero");
        map.put("Second","Segundo");
        map.put("Iorens","PutoAmo");
        assertEquals(false,map.isEmpty());
    }

    @Test
    public void should_return_true_when_map_empty() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class mapClass = Class.forName(mapClassName);
        Constructor constructor = mapClass.getConstructor();
        Map<String,String> map = (Map) constructor.newInstance();
        assertEquals(true,map.isEmpty());

    }

    @Test
    public void should_return_true_when_keySet_works_correctly() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class mapClass = Class.forName(mapClassName);
        Constructor constructor = mapClass.getConstructor();
        Map<String,String> map = (Map) constructor.newInstance();
        map.put("Hello","Hola");
        map.put("World", "Mundo");
        map.put("First","Primero");
        map.put("Second","Segundo");
        map.put("Iorens","PutoAmo");
        Set<String> set = new HashSet<String>();
        set.add("Hello");
        set.add("World");
        set.add("First");
        set.add("Second");
        set.add("Iorens");
        assertEquals(true,set.equals(map.keySet()));
    }

    @Test
    public void should_return_false_when_keySet_works_correctly() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class mapClass = Class.forName(mapClassName);
        Constructor constructor = mapClass.getConstructor();
        Map<String,String> map = (Map) constructor.newInstance();
        map.put("Hello","Hola");
        map.put("World", "Mundo");
        map.put("First","Primero");
        map.put("Second","Segundo");
        map.put("Iorens","PutoAmo");
        Set<String> set = new HashSet<String>();
        set.add("Hello");
        set.add("World");
        set.add("First");
        set.add("Iorens");
        assertEquals(false,set.equals(map.keySet()));
    }

    @Test
    public void should_return_null_when_putting_a_new_key() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class mapClass = Class.forName(mapClassName);
        Constructor constructor = mapClass.getConstructor();
        Map<String,String> map = (Map) constructor.newInstance();
        assertEquals(null,map.put("Test","Test"));
    }

    @Test
    public void should_return_last_value_when_putting_no_new_key() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class mapClass = Class.forName(mapClassName);
        Constructor constructor = mapClass.getConstructor();
        Map<String,String> map = (Map) constructor.newInstance();
        map.put("Test","Test1");
        assertEquals("Test1",map.put("Test","Test2"));
        assertEquals("Test2",map.get("Test"));
    }

    @Test
    public void should_put_all_entrys_of_other_map_into_this_map() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class mapClass = Class.forName(mapClassName);
        Constructor constructor = mapClass.getConstructor();
        Map map = (Map) constructor.newInstance();
        Map otherMap = (Map) constructor.newInstance();
        map.put("Hello","Hola");
        map.put("World", "Mundo");
        map.put("First","Primero");
        otherMap.put("Second","Segundo");
        otherMap.put("Iorens","PutoAmo");
        Set<MapEntry<String,String>> mapSet= map.entrySet();
        Set<MapEntry<String,String>> otherMapSet = otherMap.entrySet();
        map.putAll(otherMap);
        mapSet.addAll(otherMapSet);
        assertEquals(mapSet,map.entrySet());
    }

    @Test
    public void should_remove_value_correctly() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class mapClass = Class.forName(mapClassName);
        Constructor constructor = mapClass.getConstructor();
        Map map = (Map) constructor.newInstance();
        map.put("Hello","Hola");
        map.put("World", "Mundo");
        map.put("First","Primero");
        map.put("Second","Segundo");
        map.put("Iorens","PutoAmo");
        assertEquals("Hola",map.get("Hello"));
        map.remove("Hello");
        assertEquals(null,map.get("Hello"));
    }

    @Test
    public void should_return_size_correctly() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Class mapClass = Class.forName(mapClassName);
        Constructor constructor = mapClass.getConstructor();
        Map map = (Map) constructor.newInstance();
        map.put("Hello","Hola");
        map.put("World", "Mundo");
        map.put("First","Primero");
        map.put("Second","Segundo");
        map.put("Iorens","PutoAmo");
        assertEquals(5,map.size());
        map.remove("Hello");
        map.remove("World");
        assertEquals(3,map.size());
    }

    @Test
    public void should_return_values_correctly() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class mapClass = Class.forName(mapClassName);
        Constructor constructor = mapClass.getConstructor();
        Map map = (Map) constructor.newInstance();
        map.put("Hello","Hola");
        map.put("World", "Mundo");
        map.put("First","Primero");
        map.put("Second","Segundo");
        map.put("Iorens","PutoAmo");
        Collection<String> values =map.values();
        for(String s : values) {
            assertEquals(true, map.containsValue(s) );
        }
        assertEquals(map.size(),values.size());
    }

    @Test
    public void should_do_rehashing_correctly() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class mapClass = Class.forName(mapClassName);
        Constructor constructor = mapClass.getConstructor();
        Map<Integer,Integer> map = (Map) constructor.newInstance();
        for(int i = 0; i<200 ; i++){
            map.put(i,i);
        }
        assertEquals(200,map.size());
        assertEquals((Integer)0,map.get(0));
        assertEquals((Integer)50,map.get(50));
        assertEquals((Integer)100,map.get(100));
        assertEquals((Integer)150,map.get(150));
        assertEquals((Integer)199,map.get(199));
    }





    @Parameterized.Parameters(name = "{index}: {0}")
    public static List<String> data() {
        return new MapFactory().create();
    }

}
