package yukwork.datastructure.generics.myset.mylinkedhashset;

import yukwork.datastructure.generics.myset.MyAbstractSet;
import yukwork.datastructure.generics.myset.MyIterator;
import yukwork.datastructure.generics.myset.MySet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyLinkedHashSet<T> extends MyAbstractSet<T> {

    private static final int DEFAULT_CAPACITY = 4;
    private static final float LOAD_FACTOR = 0.75f;

    private LinkedList<T>[] buckets;
    private int size;
    private MyLinkedHashSetNode<T> head, tail;

    public MyLinkedHashSet() {
        buckets = new LinkedList[DEFAULT_CAPACITY];
        size = 0;
        head = null;
        tail = null;
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
            linkLast(o);
            size++;
        }
    }

    @Override
    public void remove(T o) {
        int index = getHashBucketIndex(o);
        if (buckets[index] != null) {
            if (buckets[index].remove(o)) {
                unlink(o);
                size--;
            }
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
        List<T> list = toList();
        return (T[]) list.toArray();
    }

    @Override
    public List<T> toList() {
        List<T> resultList = new ArrayList<>(size);
        MyLinkedHashSetNode<T> current = head;
        while (current != null) {
            resultList.add(current.getValue());
            current = current.getNext();
        }
        return resultList;
    }

    private int getHashBucketIndex(Object o) {
        return o == null ? 0 : Math.abs(o.hashCode()) % buckets.length;
    }

    private void ensureCapacity() {
        if (size >= buckets.length * LOAD_FACTOR) {
            LinkedList<T>[] oldBuckets = buckets;
            buckets = new LinkedList[buckets.length * 2];
            size = 0;
            head = tail = null;
            for (List<T> bucket : oldBuckets) {
                if (bucket != null) {
                    for (T item : bucket) {
                        add(item);
                    }
                }
            }
        }
    }

    private void linkLast(T o) {
        MyLinkedHashSetNode<T> newNode = new MyLinkedHashSetNode<>(o);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
    }

    private void unlink(T o) {
        MyLinkedHashSetNode<T> current = head;
        while (current != null) {
            if (current.getValue().equals(o)) {
                if (current.getPrev() != null) {
                    current.getPrev().setNext(current.getNext());
                } else {
                    head = current.getNext();
                }
                if (current.getNext() != null) {
                    current.getNext().setPrev(current.getPrev());
                } else {
                    tail = current.getPrev();
                }
                break;
            }
            current = current.getNext();
        }
    }

    @Override
    public MyIterator<T> iterator() {
        return new MyLinkedHashSetIterator<>(head);
    }

    @Override
    protected MySet<T> createNewSet() {
        return new MyLinkedHashSet<>();
    }

}
