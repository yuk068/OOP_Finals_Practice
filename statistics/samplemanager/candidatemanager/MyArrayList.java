package yukwork.statistics.samplemanager.candidatemanager;

import java.util.NoSuchElementException;

public class MyArrayList extends MyAbstractList {

    private static final int DEFAULT_CAPACITY = 2;
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
    public void remove(int index) {
        checkBound(index, size);
        System.arraycopy(data, index + 1, data, index, size - index);
        size--;
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
    public MyIterator iterator() {
        return new MyArrayListIterator();
    }

    private void enlarge() {
        Object[] newData = new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    private class MyArrayListIterator implements MyIterator {

        private int currentPosition;

        public MyArrayListIterator() {
            currentPosition = 0;
        }

        @Override
        public boolean hasNext() {
            return currentPosition < size && data[currentPosition] != null;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                Object target = get(currentPosition);
                currentPosition++;
                return target;
            } else throw new NoSuchElementException("No such element!");
        }

        @Override
        public void remove() {
            if (hasNext()) {
                MyArrayList.this.remove(currentPosition);
                currentPosition--;
            } else throw new NoSuchElementException("No such element!");
        }

    }

}
