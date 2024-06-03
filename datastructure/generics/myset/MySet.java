package yukwork.datastructure.generics.myset;

import java.util.List;

public interface MySet<T> extends MyIterable<T> {

    void add(T o);

    void remove(T o);

    boolean contains(T o);

    int size();

    T[] toArray();

    void clear();

    boolean isEmpty();

    List<T> toList();

    MySet<T> union(MySet<T> another);

    MySet<T> intersection(MySet<T> another);

    MySet<T> difference(MySet<T> another);

}
