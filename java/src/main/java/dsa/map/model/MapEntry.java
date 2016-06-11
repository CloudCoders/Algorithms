package dsa.map.model;

/**
 * Created by JoseLlorens on 25/04/2016.
 */
public class MapEntry<K,V> {
    private K key;
    private V value;



    private MapEntry<K,V> nextEntry;

    public MapEntry(K key, V value){
        this.key = key;
        this.value = value;
        nextEntry = null;
    }

    public MapEntry(K key, V value, MapEntry<K,V> entry){
        this.key = key;
        this.value = value;
        nextEntry = entry;
    }

    public K getKey(){
        return this.key;
    }

    public V getValue(){
        return this.value;
    }

    public MapEntry<K, V> getNextEntry() {
        return nextEntry;
    }

    public void setNextEntry(MapEntry<K, V> nextEntry) {
        this.nextEntry = nextEntry;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }


    /*
    public boolean equals(MapEntry<K,V> other){
        return this.getKey().equals(other.getKey()) && this.getValue().equals(other.getValue());
    }*/

    public boolean equals(Object o){
        if(! (o instanceof MapEntry)){
            return false;
        }else{
            MapEntry aux = (MapEntry) o;
            return (aux.getValue().equals(this.getValue())&&aux.getKey().equals(this.getKey()));
        }
    }


    public String toString(){
        return ("Key: "+this.key+ "\tValue: "+this.value);
    }

    public int hashCode(){
        return this.getKey().hashCode()*2 + this.getValue().hashCode();
    }

}
