package yukwork.datastructure.nongenerics.mymap;

public interface MyMap {

    void put(Object key, Object value);

    Object get(Object key);

    void removeByKey(Object key);

    void removeByValue(Object value);

    void setValueAt(Object key, Object value);

    boolean containsKey(Object key);

    boolean containsValue(Object value);

    int size();

}
