package yukwork.datastructure.generics.mymap;

public interface MyMap<E, V> {

    void put(E key, V value);

    Object get(E key);

    void removeByKey(E key);

    void removeByValue(V value);

    void setValueAt(E key, V value);

    boolean containsKey(E key);

    boolean containsValue(V value);

    int size();

    String getMapStructure();

}
