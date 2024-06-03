package yukwork.datastructure.nongenerics.mylist;

import java.util.List;

public interface MyList extends MyIterable {

    int size();

    void append(Object payload);

    void insert(Object payload, int index);

    void insertAtStart(Object payload);

    void insertAtEnd(Object payload);

    void remove(Object payload);

    void remove(int index);

    Object get(int index);

    void set(Object payload, int index);

    Object[] toArray();

    List<Object> toList();

    boolean isEmpty();

}
