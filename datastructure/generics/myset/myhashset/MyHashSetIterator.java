package yukwork.datastructure.generics.myset.myhashset;

import yukwork.datastructure.generics.myset.MyIterator;

import java.util.NoSuchElementException;

public class MyHashSetIterator<T> implements MyIterator<T> {

    private final T[] currentData;
    private int currentPosition;

    public MyHashSetIterator(T[] data) {
        currentData = data;
        currentPosition = 0;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < currentData.length;
    }

    @Override
    public T next() {
        if (hasNext()) {
            return currentData[currentPosition++];
        } else throw new NoSuchElementException("No such element!");
    }

}
