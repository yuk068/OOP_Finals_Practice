package yukwork.datastructure.generics.mylist.mydeque;

import yukwork.datastructure.generics.mylist.MyIterable;
import yukwork.datastructure.generics.mylist.MyIterator;
import yukwork.datastructure.generics.mylist.MyList;
import yukwork.datastructure.generics.mylist.mydoublylinkedlist.MyDoublyLinkedList;

public class MyDeque<T> implements MyIterable<T> {

    private final MyList<T> list;

    public MyDeque() {
        list = new MyDoublyLinkedList<>();
    }

    public void insertFront(T payload) {
        list.insertAtStart(payload);
    }

    public void insertRear(T payload) {
        list.insertAtEnd(payload);
    }

    public T removeFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty!");
        }
        T target = list.get(0);
        list.remove(0);
        return target;
    }

    public T removeRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty!");
        }
        T target = list.get(size() - 1);
        list.remove(size() - 1);
        return target;
    }

    public T peekFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.get(0);
    }

    public T peekRear() {
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
    public MyIterator<T> iterator() {
        return list.iterator();
    }

}
