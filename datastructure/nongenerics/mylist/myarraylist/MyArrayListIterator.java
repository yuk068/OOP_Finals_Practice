package yukwork.datastructure.nongenerics.mylist.myarraylist;

import yukwork.datastructure.nongenerics.mylist.MyIterator;

import java.util.NoSuchElementException;

public class MyArrayListIterator implements MyIterator {

    private final Object[] data;
    private int currentPosition;

    public MyArrayListIterator(Object[] data) {
        this.data = data;
        currentPosition = 0;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < data.length && data[currentPosition] != null;
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return data[currentPosition++];
        } else throw new
                NoSuchElementException("No such element!");
    }
}
