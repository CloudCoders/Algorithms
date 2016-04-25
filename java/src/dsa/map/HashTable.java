package dsa.map;

import dsa.map.model.Map;
import dsa.map.model.MapEntry;

import java.util.*;

/**
 * Created by JoseLlorens on 25/04/2016.
 */
public class HashTable<K,V> implements Map<K,V> {

    MapEntry<K,V>[] mainArray;
    Double MAX_LOAD_FACTOR= 0.75;
    double loadFactor;
    int size;

    public HashTable(){
        size = 0;
        loadFactor=0;
        mainArray = new MapEntry[97];
    }


    @Override
    public void clear() {
        for(int i = 0; i<mainArray.length;i++){
            mainArray[i]=null;
        }
    }

    @Override
    public boolean containsKey(K key) {
        for(int i = 0; i<mainArray.length;i++){
            MapEntry<K,V> entry = mainArray[i];
            while (entry!=null){
                if(entry.getKey().equals(key)){
                    return true;
                }
                entry = entry.getNextEntry();
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for(int i = 0;i<mainArray.length;i++){
            MapEntry<K,V> entry = mainArray[i];
            while(entry!=null){
                if(entry.getValue().equals(value)) {
                    return true;
                }
                entry=entry.getNextEntry();
            }
        }
        return false;
    }

    @Override
    public Set<MapEntry<K, V>> entrySet() {
        Set<MapEntry<K,V>> set = new HashSet<MapEntry<K, V>>();
        for(int i = 0; i< mainArray.length;i++){
            MapEntry<K,V> entry = mainArray [i];
            while(entry != null){
                set.add(entry);
                entry=entry.getNextEntry();
            }
        }
        return set;
    }

    @Override
    public boolean equals(Map other) {

        return other.entrySet().equals(this.entrySet());
    }

    @Override
    public V get(K key) {
        int index = hashIndex(key);
        MapEntry<K,V> entry = mainArray[index];
        while(entry!=null){
            if(entry.getKey().equals(key)){
                return  entry.getValue();
            }
            entry = entry.getNextEntry();
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int hashCode(){
        int hasCode = 0;
        Set<MapEntry<K,V>> set = this.entrySet();
        for(MapEntry<K,V> entry : set){
            hasCode+=entry.hashCode();
        }
        return hasCode;
    }


    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<K>();
        for(int i =0 ; i<mainArray.length;i++){
            MapEntry<K,V> entry = mainArray[i];
            while(entry != null){
                set.add(entry.getKey());
                entry = entry.getNextEntry();
            }
        }
        return set;
    }

    @Override
    public V put(K key, V value) {
        int index = hashIndex(key);
        MapEntry<K, V> entry = mainArray[index];
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                V ret = entry.getValue();
                entry.setValue(value);
                return ret;
            }
            entry = entry.getNextEntry();
        }

        MapEntry<K,V> newEntry = new MapEntry<K,V>(key,value,entry);
        mainArray[index] = newEntry;
        size++;
        loadFactor = size/(double) mainArray.length;
        if(loadFactor>MAX_LOAD_FACTOR){
            rehashing();
        }

        return null;

    }



    @Override
    public void putAll(Map<K,V> m) {
        Set<MapEntry<K,V>> entrySet = m.entrySet();
        for(Iterator<MapEntry<K,V>> it = entrySet.iterator();it.hasNext();){
             MapEntry<K,V> aux = it.next();
            this.put(aux.getKey(),aux.getValue());
        }

    }

    @Override
    public V remove(K key) {
        int index = hashIndex(key);
        MapEntry<K,V> entry = mainArray[index];
        MapEntry<K,V>ant = null;
        if(entry == null){
            return  null;
        }
        if(entry.getKey().equals(key)){
            mainArray[index] = entry.getNextEntry();
            size --;
            return entry.getValue();
        }
        ant=entry;
        entry = entry.getNextEntry();
        while(entry!=null){
            if(entry.getKey().equals(key)){
                ant.setNextEntry(entry.getNextEntry());
                size--;
                return entry.getValue();
            }
        }
        return null;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Collection<V> values() {
        Collection<V> valueList = new ArrayList<V>();
        for(int i = 0 ; i<mainArray.length;i++){
            MapEntry<K,V> entry = mainArray[i];
            while(entry!=null){
                valueList.add(entry.getValue());
                entry=entry.getNextEntry();
            }
        }

        return valueList;
    }


    private int nextPrimeNumber(int x){
        for(int i=x+1;true;i++){
            if(isPrime(i)){
                return i;
            }
        }
    }

    private boolean isPrime(int x) {
        for(int i = 2; i*i <= x; i++){
            if(x%i == 0){
                return false;
            }
        }
        return true;
    }

    private int hashIndex(K key){
        int hashIndex = key.hashCode();
        hashIndex = hashIndex%mainArray.length;
        if(hashIndex < 0){
            hashIndex += this.mainArray.length;
        }
        return hashIndex;
    }

    private void rehashing() {
        MapEntry<K,V>[] newArray = new MapEntry[nextPrimeNumber(mainArray.length)];
        MapEntry<K,V>[] oldArray = mainArray;
        mainArray = newArray;
        for(int i = 0; i<oldArray.length;i++){
            MapEntry<K,V> entry = oldArray[i];
            while(entry!=null){
                put(entry.getKey(),entry.getValue());
                entry=entry.getNextEntry();
            }
        }

    }
}
