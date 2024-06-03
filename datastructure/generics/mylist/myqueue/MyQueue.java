package yukwork.datastructure.generics.mylist.myqueue;

import yukwork.datastructure.generics.mylist.MyIterable;
import yukwork.datastructure.generics.mylist.MyIterator;
import yukwork.datastructure.generics.mylist.MyList;
import yukwork.datastructure.generics.mylist.mylinkedlist.MyLinkedList;

public class MyQueue<T> implements MyIterable<T> {

    private final MyList<T> list;

    public MyQueue() {
        list = new MyLinkedList<>();
    }

    public void enqueue(T payload) {
        list.insertAtEnd(payload);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        T front = list.get(0);
        list.remove(0);
        return front;
    }

    public T peek() {
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
    public MyIterator<T> iterator() {
        return list.iterator();
    }

}
