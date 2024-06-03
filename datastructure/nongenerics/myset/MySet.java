package yukwork.datastructure.nongenerics.myset;

import java.util.List;

public interface MySet extends MyIterable {

    void add(Object o);

    void remove(Object o);

    boolean contains(Object o);

    int size();

    void clear();

    boolean isEmpty();

    MySet union(MySet another);

    MySet intersection(MySet another);

    MySet difference(MySet another);

    Object[] toArray();

    List<Object> toList();

}
