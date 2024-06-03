package yukwork.datastructure.generics.mymap.myhashmap;

import yukwork.datastructure.generics.mymap.MyMap;

import java.util.NoSuchElementException;

/*
 * Uses Open Addressing for handling Hash collision
 */
public class MyHashMap<E, V> implements MyMap<E, V> {

    private static final int DEFAULT_CAPACITY = 4;
    private static final float LOAD_FACTOR = 0.75f;
    private MyHashMapEntry[] table;
    private int size;

    public MyHashMap() {
        table = new MyHashMapEntry[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void put(E key, V value) {
        ensureCapacity();
        int bucket = getBucketIndex(key);
        if (table[bucket] == null) {
            table[bucket] = new MyHashMapEntry(key, value);
            size++;
        } else {
            table[bucket].setValue(value);
        }
    }

    @Override
    public Object get(E key) {
        int bucket = getBucketIndex(key);
        if (table[bucket] != null) {
            return table[bucket].getValue();
        } else throw new NoSuchElementException("Invalid key!");
    }

    @Override
    public void removeByKey(E key) {
        int originalBucket = getBucketIndex(key);
        int bucket = originalBucket;

        do {
            if (table[bucket] != null && table[bucket].getKey().equals(key)) {
                table[bucket] = null;
                size--;
                rehashFrom(bucket);
                return;
            }
            bucket = (bucket + 1) % table.length;
        } while (bucket != originalBucket);
    }

    @Override
    public void removeByValue(V value) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && table[i].getValue().equals(value)) {
                table[i] = null;
                size--;
                rehashFrom(i);
                return;
            }
        }
    }

    @Override
    public void setValueAt(E key, V value) {
        for (MyHashMapEntry entry : table) {
            if (entry != null && entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
    }

    @Override
    public boolean containsKey(E key) {
        for (MyHashMapEntry entry : table) {
            if (entry != null && entry.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (MyHashMapEntry entry : table) {
            if (entry != null && entry.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    private double capacityRatio() {
        return size / (double) table.length;
    }

    private int getBucketIndex(Object key) {
        int bucket = (Math.abs(key.hashCode()) % table.length);
        while (table[bucket] != null && !table[bucket].getKey().equals(key)) {
            bucket = (bucket + 1) % table.length;
        }
        return bucket;
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (capacityRatio() > LOAD_FACTOR) {
            MyHashMapEntry[] oldTable = table;
            table = new MyHashMapEntry[oldTable.length * 2];
            size = 0;
            for (MyHashMapEntry entry : oldTable) {
                if (entry != null) {
                    put((E) entry.getKey(), (V) entry.getValue());
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void rehashFrom(int startIndex) {
        int index = (startIndex + 1) % table.length;
        while (table[index] != null) {
            MyHashMapEntry entry = table[index];
            table[index] = null;
            size--;
            put((E) entry.getKey(), (V) entry.getValue());
            index = (index + 1) % table.length;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        int entries = 0;
        for (MyHashMapEntry myHashMapEntry : table) {
            if (myHashMapEntry != null) {
                if (entries != size - 1) {
                    sb.append("[").append(myHashMapEntry.getKey()).append(", ").append(myHashMapEntry.getValue()).append("]").append(", ");
                    entries++;
                } else
                    sb.append("[").append(myHashMapEntry.getKey()).append(", ").append(myHashMapEntry.getValue()).append("]");
            }
        }
        return sb.append("]").toString();
    }

    public String getMapStructure() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                sb.append(String.format("[bucket %d] -> (%s, %s)\n", i, table[i].getKey(), table[i].getValue()));
            }
        }
        return sb.toString();
    }

}
