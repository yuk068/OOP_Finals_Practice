package yukwork.datastructure.nongenerics.mylist.myqueue;

import yukwork.datastructure.nongenerics.mylist.MyIterable;
import yukwork.datastructure.nongenerics.mylist.MyIterator;
import yukwork.datastructure.nongenerics.mylist.MyList;
import yukwork.datastructure.nongenerics.mylist.mylinkedlist.MyLinkedList;

public class MyQueue implements MyIterable {

    private final MyList list;

    public MyQueue() {
        list = new MyLinkedList();
    }

    public void enqueue(Object payload) {
        list.insertAtEnd(payload);
    }

    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        Object front = list.get(0);
        list.remove(0);
        return front;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        return list.get(0);
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
