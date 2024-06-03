package yukwork.datastructure.nongenerics.myset.myhashset;

import yukwork.datastructure.nongenerics.myset.MyAbstractSet;
import yukwork.datastructure.nongenerics.myset.MyIterator;
import yukwork.datastructure.nongenerics.myset.MySet;

import java.util.ArrayList;
import java.util.List;

public class MyOpenAddressingHashSet extends MyAbstractSet {

    private static final int DEFAULT_CAPACITY = 4;
    private static final float LOAD_FACTOR = 0.75f;
    private Object[] buckets;
    private int size;

    public MyOpenAddressingHashSet() {
        buckets = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void add(Object o) {
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
    public void remove(Object o) {
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
    public boolean contains(Object o) {
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

    @Override
    public Object[] toArray() {
        Object[] toArray = new Object[size];
        int arrayIndex = 0;
        for (Object bucket : buckets) {
            if (bucket != null) {
                toArray[arrayIndex++] = bucket;
            }
        }
        return toArray;
    }

    @Override
    public List<Object> toList() {
        List<Object> toList = new ArrayList<>();
        for (Object bucket : buckets) {
            if (bucket != null) {
                toList.add(bucket);
            }
        }
        return toList;
    }

    private int getHashBucketIndex(Object o) {
        return o == null ? 0 : Math.abs(o.hashCode()) % buckets.length;
    }

    private void ensureCapacity() {
        if (size >= buckets.length * LOAD_FACTOR) {
            Object[] oldBuckets = buckets;
            buckets = new Object[buckets.length * 2];
            size = 0;
            for (Object bucket : oldBuckets) {
                if (bucket != null) {
                    add(bucket);
                }
            }
        }
    }

    private void rehashFrom(int index) {
        index = (index + 1) % buckets.length;
        while (buckets[index] != null) {
            Object o = buckets[index];
            buckets[index] = null;
            size--;
            add(o);
            index = (index + 1) % buckets.length;
        }
    }

    @Override
    public MyIterator iterator() {
        return new MyHashSetIterator(toArray());
    }

    @Override
    protected MySet createSet() {
        return new MyOpenAddressingHashSet();
    }

}
