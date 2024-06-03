package yukwork.datastructure.generics.myset.myhashset;

import yukwork.datastructure.generics.myset.MyAbstractSet;
import yukwork.datastructure.generics.myset.MyIterator;
import yukwork.datastructure.generics.myset.MySet;

import java.util.ArrayList;
import java.util.List;

public class MyOpenAddressingHashSet<T> extends MyAbstractSet<T> {

    private static final int DEFAULT_CAPACITY = 4;
    private static final float LOAD_FACTOR = 0.75f;
    private Object[] buckets;
    private int size;

    public MyOpenAddressingHashSet() {
        buckets = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void add(T o) {
        if (o == null) return;
        ensureCapacity();
        int index = getHashBucketIndex(o);
        while (buckets[index] != null) {
            if (buckets[index].equals(o)) {
                return;
            }
            index = (index + 1) % buckets.length;
        }
        buckets[index] = o;
        size++;
    }

    @Override
    public void remove(T o) {
        int index = getHashBucketIndex(o);
        while (buckets[index] != null) {
            if (buckets[index].equals(o)) {
                buckets[index] = null;
                size--;
                rehashFrom(index);
                return;
            }
            index = (index + 1) % buckets.length;
        }
    }

    @Override
    public boolean contains(T o) {
        int index = getHashBucketIndex(o);
        while (buckets[index] != null) {
            if (buckets[index].equals(o)) {
                return true;
            }
            index = (index + 1) % buckets.length;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] toArray() {
        T[] toArray = (T[]) new Object[size];
        int arrayIndex = 0;
        for (Object bucket : buckets) {
            if (bucket != null) {
                toArray[arrayIndex++] = (T) bucket;
            }
        }
        return toArray;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> toList() {
        List<T> toList = new ArrayList<>();
        for (Object bucket : buckets) {
            if (bucket != null) {
                toList.add((T) bucket);
            }
        }
        return toList;
    }

    private int getHashBucketIndex(Object o) {
        return o == null ? 0 : Math.abs(o.hashCode()) % buckets.length;
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (size >= buckets.length * LOAD_FACTOR) {
            Object[] oldBuckets = buckets;
            buckets = new Object[buckets.length * 2];
            size = 0;
            for (Object bucket : oldBuckets) {
                if (bucket != null) {
                    add((T) bucket);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void rehashFrom(int index) {
        index = (index + 1) % buckets.length;
        while (buckets[index] != null) {
            Object o = buckets[index];
            buckets[index] = null;
            size--;
            add((T) o);
            index = (index + 1) % buckets.length;
        }
    }

    @Override
    public MyIterator<T> iterator() {
        return new MyHashSetIterator<>(toArray());
    }

    @Override
    protected MySet<T> createNewSet() {
        return new MyOpenAddressingHashSet<>();
    }

}
