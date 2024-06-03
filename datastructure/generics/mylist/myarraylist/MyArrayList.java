package yukwork.datastructure.generics.mylist.myarraylist;

import yukwork.datastructure.generics.mylist.MyAbstractList;
import yukwork.datastructure.generics.mylist.MyIterator;

import java.util.Arrays;
import java.util.List;

public class MyArrayList<T> extends MyAbstractList<T> {

    private static final int DEFAULT_CAPACITY = 4;
    private T[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        data = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void append(T payload) {
        if (size >= data.length) enlarge();
        data[size++] = payload;
    }

    @Override
    public void insert(T payload, int index) {
        checkBound(index, size + 1);
        if (size >= data.length) enlarge();
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = payload;
        size++;
    }

    @Override
    public void insertAtStart(T payload) {
        insert(payload, 0);
    }

    @Override
    public void insertAtEnd(T payload) {
        append(payload);
    }

    @Override
    public void remove(T payload) {
        for (int i = 0; i < size; i++) {
            if (get(i) == payload) {
                remove(i);
                i--;
            }
        }
    }

    @Override
    public void remove(int index) {
        checkBound(index, size);
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        correct();
    }

    @Override
    public T get(int index) {
        checkBound(index, size);
        return data[index];
    }

    @Override
    public void set(T payload, int index) {
        checkBound(index, size);
        data[index] = payload;
    }

    @Override
    public T[] toArray() {
        return Arrays.copyOf(data, size);
    }

    @Override
    public List<T> toList() {
        return Arrays.stream(data).limit(size).toList();
    }

    @Override
    public MyIterator<T> iterator() {
        return new MyArrayListIterator<>(data);
    }

    @SuppressWarnings("unchecked")
    private void enlarge() {
        T[] enlargedData = (T[]) new Object[data.length * 2];
        System.arraycopy(data, 0, enlargedData, 0, size);
        data = enlargedData;
    }

    private void correct() {
        for (int i = size; i < data.length; i++) {
            data[i] = null;
        }
    }

}
