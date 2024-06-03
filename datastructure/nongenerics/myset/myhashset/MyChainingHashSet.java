package yukwork.datastructure.nongenerics.myset.myhashset;

import yukwork.datastructure.nongenerics.myset.MyAbstractSet;
import yukwork.datastructure.nongenerics.myset.MyIterator;
import yukwork.datastructure.nongenerics.myset.MySet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyChainingHashSet extends MyAbstractSet {

    private static final int DEFAULT_CAPACITY = 4;
    private static final float LOAD_FACTOR = 0.75f;
    private LinkedList<Object>[] buckets;
    private int size;

    public MyChainingHashSet() {
        buckets = new LinkedList[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void add(Object o) {
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
    public void remove(Object o) {
        int index = getHashBucketIndex(o);
        if (buckets[index] != null) {
            if (buckets[index].remove(o)) size--;
        }
    }

    @Override
    public boolean contains(Object o) {
        int index = getHashBucketIndex(o);
        List<Object> bucket = buckets[index];
        return bucket != null && bucket.contains(o);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int idx = 0;
        for (List<Object> bucket : buckets) {
            if (bucket != null) {
                for (Object item : bucket) {
                    result[idx++] = item;
                }
            }
        }
        return result;
    }

    @Override
    public List<Object> toList() {
        List<Object> resultList = new ArrayList<>();
        for (List<Object> bucket : buckets) {
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
            List<Object>[] oldBuckets = buckets;
            buckets = new LinkedList[buckets.length * 2];
            size = 0;
            for (List<Object> bucket : oldBuckets) {
                if (bucket != null) {
                    for (Object item : bucket) {
                        add(item);
                    }
                }
            }
        }
    }

    @Override
    public MyIterator iterator() {
        return new MyHashSetIterator(toArray());
    }

    @Override
    protected MySet createSet() {
        return new MyChainingHashSet();
    }

}
