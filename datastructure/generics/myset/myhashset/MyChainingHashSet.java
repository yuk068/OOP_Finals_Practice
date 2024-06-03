package yukwork.datastructure.generics.myset.myhashset;

import yukwork.datastructure.generics.myset.MyAbstractSet;
import yukwork.datastructure.generics.myset.MyIterator;
import yukwork.datastructure.generics.myset.MySet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyChainingHashSet<T> extends MyAbstractSet<T> {

    private static final int DEFAULT_CAPACITY = 4;
    private static final float LOAD_FACTOR = 0.75f;
    private LinkedList<T>[] buckets;
    private int size;

    public MyChainingHashSet() {
        buckets = new LinkedList[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void add(T o) {
        if (o == null) return;
        ensureCapacity();
        int index = getHashBucketIndex(o);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        if (!contains(o)) {
            buckets[index].add(o);
            size++;
        }
    }

    @Override
    public void remove(T o) {
        int index = getHashBucketIndex(o);
        if (buckets[index] != null) {
            if (buckets[index].remove(o)) size--;
        }
    }

    @Override
    public boolean contains(T o) {
        int index = getHashBucketIndex(o);
        List<T> bucket = buckets[index];
        return bucket != null && bucket.contains(o);
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] toArray() {
        T[] result = (T[]) new Object[size];
        int idx = 0;
        for (List<T> bucket : buckets) {
            if (bucket != null) {
                for (T item : bucket) {
                    result[idx++] = item;
                }
            }
        }
        return result;
    }

    @Override
    public List<T> toList() {
        List<T> resultList = new ArrayList<>();
        for (List<T> bucket : buckets) {
            if (bucket != null) {
                resultList.addAll(bucket);
            }
        }
        return resultList;
    }

    private int getHashBucketIndex(Object o) {
        return o == null ? 0 : Math.abs(o.hashCode()) % buckets.length;
    }

    private void ensureCapacity() {
        if (size >= buckets.length * LOAD_FACTOR) {
            List<T>[] oldBuckets = buckets;
            buckets = new LinkedList[buckets.length * 2];
            size = 0;
            for (List<T> bucket : oldBuckets) {
                if (bucket != null) {
                    for (T item : bucket) {
                        add(item);
                    }
                }
            }
        }
    }

    @Override
    public MyIterator<T> iterator() {
        return new MyHashSetIterator<>(toArray());
    }

    @Override
    protected MySet<T> createNewSet() {
        return new MyChainingHashSet<>();
    }

}
