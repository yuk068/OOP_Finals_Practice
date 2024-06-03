package yukwork.datastructure.nongenerics.myset.myhashset;

import yukwork.datastructure.nongenerics.myset.MyIterator;

import java.util.NoSuchElementException;

public class MyHashSetIterator implements MyIterator {

    private final Object[] currentData;
    private int currentPosition;

    public MyHashSetIterator(Object[] data) {
        currentData = data;
        currentPosition = 0;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < currentData.length;
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return currentData[currentPosition++];
        } else throw new NoSuchElementException("No such element!");
    }

}
