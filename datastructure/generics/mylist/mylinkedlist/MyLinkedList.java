package yukwork.datastructure.generics.mylist.mylinkedlist;

import yukwork.datastructure.generics.mylist.MyAbstractList;
import yukwork.datastructure.generics.mylist.MyIterator;

import java.util.LinkedList;
import java.util.List;

public class MyLinkedList<T> extends MyAbstractList<T> {

    private MyNode<T> head;
    private int size;

    public MyLinkedList() {
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void append(T payload) {
        if (size == 0) {
            head = new MyNode<>(payload);
        } else {
            getNodeByIndex(size - 1).setNext(new MyNode<>(payload));
        }
        size++;
    }

    @Override
    public void insert(T payload, int index) {
        checkBound(index, size + 1);
        if (index == 0) {
            head = new MyNode<>(payload, head);
        } else {
            MyNode<T> prevNode = getNodeByIndex(index - 1);
            prevNode.setNext(new MyNode<>(payload, prevNode.getNext()));
        }
        size++;
    }

    @Override
    public void insertAtStart(T payload) {
        insert(payload, 0);
    }

    @Override
    public void insertAtEnd(T payload) {
        insert(payload, size);
    }

    @Override
    public void remove(T payload) {
        for (int i = 0; i < size; i++) {
            if (get(i) == payload) {
                getNodeByIndex(i - 1).setNext(getNodeByIndex(i).getNext());
                i--;
                size--;
            }
        }
    }

    @Override
    public void remove(int index) {
        checkBound(index, size);
        if (index == 0) {
            head = head.getNext();
        } else {
            MyNode<T> prevNode = getNodeByIndex(index - 1);
            prevNode.setNext(prevNode.getNext().getNext());
        }
        size--;
    }

    @Override
    public T get(int index) {
        checkBound(index, size);
        return getNodeByIndex(index).getPayload();
    }

    @Override
    public void set(T payload, int index) {
        checkBound(index, size);
        getNodeByIndex(index).setPayload(payload);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] toArray() {
        T[] toArray = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            toArray[i] = get(i);
        }
        return toArray;
    }

    @Override
    public List<T> toList() {
        List<T> toList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            toList.add(get(i));
        }
        return toList;
    }

    private MyNode<T> getNodeByIndex(int index) {
        MyNode<T> target = head;
        for (int i = 0; i < index; i++) {
            target = target.getNext();
        }
        return target;
    }

    @Override
    public MyIterator<T> iterator() {
        return new MyLinkedListIterator<>(head);
    }

}
