package yukwork.datastructure.generics.mymap.myhashmap;

public class MyHashMapEntry<E, V> {

    private final E key;
    private V value;

    public MyHashMapEntry(E key, V value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

}
