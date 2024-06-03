package yukwork.datastructure.nongenerics.mylist.mydeque;

import yukwork.datastructure.nongenerics.mylist.MyIterable;
import yukwork.datastructure.nongenerics.mylist.MyIterator;
import yukwork.datastructure.nongenerics.mylist.MyList;
import yukwork.datastructure.nongenerics.mylist.mydoublylinkedlist.MyDoublyLinkedList;

public class MyDeque implements MyIterable {

    private final MyList list;

    public MyDeque() {
        list = new MyDoublyLinkedList();
    }

    public void insertFront(Object payload) {
        list.insertAtStart(payload);
    }

    public void insertRear(Object payload) {
        list.insertAtEnd(payload);
    }

    public Object removeFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty!");
        }
        Object target = list.get(0);
        list.remove(0);
        return target;
    }

    public Object removeRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty!");
        }
        Object target = list.get(size() - 1);
        list.remove(size() - 1);
        return target;
    }

    public Object peekFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.get(0);
    }

    public Object peekRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    @Override
    public MyIterator iterator() {
        return list.iterator();
    }

}
