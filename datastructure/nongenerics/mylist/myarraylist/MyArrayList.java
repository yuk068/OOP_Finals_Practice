package yukwork.datastructure.nongenerics.mylist.myarraylist;

import yukwork.datastructure.nongenerics.mylist.MyAbstractList;
import yukwork.datastructure.nongenerics.mylist.MyIterator;

import java.util.Arrays;
import java.util.List;

public class MyArrayList extends MyAbstractList {

    private static final int DEFAULT_CAPACITY = 4;
    private Object[] data;
    private int size;

    public MyArrayList() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void append(Object payload) {
        if (size >= data.length) enlarge();
        data[size++] = payload;
    }

    @Override
    public void insert(Object payload, int index) {
        checkBound(index, size + 1);
        if (size >= data.length) enlarge();
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = payload;
        size++;
    }

    @Override
    public void insertAtStart(Object payload) {
        insert(payload, 0);
    }

    @Override
    public void insertAtEnd(Object payload) {
        append(payload);
    }

    @Override
    public void remove(Object payload) {
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
    public Object get(int index) {
        checkBound(index, size);
        return data[index];
    }

    @Override
    public void set(Object payload, int index) {
        checkBound(index, size);
        data[index] = payload;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(data, size);
    }

    @Override
    public List<Object> toList() {
        return Arrays.stream(data).limit(size).toList();
    }

    @Override
    public MyIterator iterator() {
        return new MyArrayListIterator(data);
    }

    private void enlarge() {
        Object[] enlargedData = new Object[data.length * 2];
        System.arraycopy(data, 0, enlargedData, 0, size);
        data = enlargedData;
    }

    private void correct() {
        for (int i = size; i < data.length; i++) {
            data[i] = null;
        }
    }

}
