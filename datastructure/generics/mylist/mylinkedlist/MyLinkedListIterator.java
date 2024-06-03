package yukwork.datastructure.generics.mylist.mylinkedlist;

import yukwork.datastructure.generics.mylist.MyIterator;

import java.util.NoSuchElementException;

public class MyLinkedListIterator<T> implements MyIterator<T> {

    private MyNode currentNode;

    public MyLinkedListIterator(MyNode head) {
        currentNode = head;
    }

    @Override
    public boolean hasNext() {
        return currentNode != null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T next() {
        if (hasNext()) {
            Object target = currentNode.getPayload();
            currentNode = currentNode.getNext();
            return (T) target;
        } else throw new
                NoSuchElementException("No such element!");
    }

}
