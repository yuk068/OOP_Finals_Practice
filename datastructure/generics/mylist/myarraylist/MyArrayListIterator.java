package yukwork.datastructure.generics.mylist.myarraylist;

import yukwork.datastructure.generics.mylist.MyIterator;

import java.util.NoSuchElementException;

public class MyArrayListIterator<T> implements MyIterator<T> {

    private final T[] data;
    private int currentPosition;

    public MyArrayListIterator(T[] data) {
        this.data = data;
        currentPosition = 0;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < data.length && data[currentPosition] != null;
    }

    @Override
    public T next() {
        if (hasNext()) {
            return data[currentPosition++];
        } else throw new
                NoSuchElementException("No such element!");
    }

}
