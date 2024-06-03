package yukwork.datastructure.nongenerics.mylist.mydoublylinkedlist;

import yukwork.datastructure.nongenerics.mylist.MyIterator;

import java.util.NoSuchElementException;

public class MyLinkedListIterator implements MyIterator {

    private MyNode currentNode;

    public MyLinkedListIterator(MyNode head) {
        currentNode = head;
    }

    @Override
    public boolean hasNext() {
        return currentNode != null;
    }

    @Override
    public Object next() {
        if (hasNext()) {
            Object target = currentNode.getPayload();
            currentNode = currentNode.getNext();
            return target;
        } else throw new
                NoSuchElementException("No such element!");
    }

}
