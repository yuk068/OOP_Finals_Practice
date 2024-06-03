package yukwork.datastructure.generics.mylist.mydoublylinkedlist;

import yukwork.datastructure.generics.mylist.MyAbstractList;
import yukwork.datastructure.generics.mylist.MyIterator;

import java.util.LinkedList;
import java.util.List;

public class MyDoublyLinkedList<T> extends MyAbstractList<T> {

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyDoublyLinkedList() {
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void append(T payload) {
        MyNode newNode = new MyNode(payload);
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
        }
        tail = newNode;
        size++;
    }

    @Override
    public void insert(T payload, int index) {
        checkBound(index, size + 1);
        if (index == size) {
            append(payload);
            return;
        }
        MyNode newNode = new MyNode(payload);
        MyNode current = getNodeByIndex(index);
        MyNode prev = current.getPrev();
        newNode.setNext(current);
        newNode.setPrev(prev);
        if (prev != null) {
            prev.setNext(newNode);
        } else {
            head = newNode;
        }
        current.setPrev(newNode);
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
                remove(i);
                i--;
            }
        }
    }

    @Override
    public void remove(int index) {
        checkBound(index, size);
        MyNode current = getNodeByIndex(index);
        MyNode prev = current.getPrev();
        MyNode next = current.getNext();
        if (prev != null) {
            prev.setNext(next);
        } else {
            head = next;
        }
        if (next != null) {
            next.setPrev(prev);
        } else {
            tail = prev;
        }
        size--;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        checkBound(index, size);
        return (T) getNodeByIndex(index).getPayload();
    }

    @Override
    public void set(T payload, int index) {
        checkBound(index, size);
        getNodeByIndex(index).setPayload(payload);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] toArray() {
        T[] array = (T[]) new Object[size];
        MyNode current = head;
        int index = 0;
        while (current != null && index < size) {
            array[index++] = (T) current.getPayload();
            current = current.getNext();
        }
        return array;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> toList() {
        List<T> list = new LinkedList<>();
        MyNode current = head;
        while (current != null) {
            list.add((T) current.getPayload());
            current = current.getNext();
        }
        return list;
    }

    private MyNode getNodeByIndex(int index) {
        MyNode current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.getPrev();
            }
        }
        return current;
    }

    @Override
    public MyIterator<T> iterator() {
        return new MyLinkedListIterator<>(head);
    }

}
