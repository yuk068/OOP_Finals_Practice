package yukwork.datastructure.generics.mymap.myhashmap;

public class MyHashMapEntry {

    private final Object key;
    private Object value;

    public MyHashMapEntry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}
