package yukwork.datastructure.generics.myset.mylinkedhashset;

import yukwork.datastructure.generics.myset.MyIterator;

public class MyLinkedHashSetIterator<T> implements MyIterator<T> {

    private MyLinkedHashSetNode<T> current;

    MyLinkedHashSetIterator(MyLinkedHashSetNode<T> head) {
        this.current = head;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        T value = current.getValue();
        current = current.getNext();
        return value;
    }

}
