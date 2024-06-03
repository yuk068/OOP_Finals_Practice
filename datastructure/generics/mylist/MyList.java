package yukwork.datastructure.generics.mylist;

import java.util.List;

public interface MyList<T> extends MyIterable<T> {

    int size();

    void append(T payload);

    void insert(T payload, int index);

    void insertAtStart(T payload);

    void insertAtEnd(T payload);

    void remove(T payload);

    void remove(int index);

    T get(int index);

    void set(T payload, int index);

    T[] toArray();

    List<T> toList();

    boolean isEmpty();

}
