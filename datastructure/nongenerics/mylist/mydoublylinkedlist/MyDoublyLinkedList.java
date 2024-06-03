package yukwork.datastructure.nongenerics.mylist.mydoublylinkedlist;

import yukwork.datastructure.nongenerics.mylist.MyAbstractList;
import yukwork.datastructure.nongenerics.mylist.MyIterator;

import java.util.LinkedList;
import java.util.List;

public class MyDoublyLinkedList extends MyAbstractList {

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
    public void append(Object payload) {
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
    public void insert(Object payload, int index) {
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
    public void insertAtStart(Object payload) {
        insert(payload, 0);
    }

    @Override
    public void insertAtEnd(Object payload) {
        insert(payload, size);
    }

    @Override
    public void remove(Object payload) {
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

    @Override
    public Object get(int index) {
        checkBound(index, size);
        return getNodeByIndex(index).getPayload();
    }

    @Override
    public void set(Object payload, int index) {
        checkBound(index, size);
        getNodeByIndex(index).setPayload(payload);
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        MyNode current = head;
        int index = 0;
        while (current != null && index < size) {
            array[index++] = current.getPayload();
            current = current.getNext();
        }
        return array;
    }

    @Override
    public List<Object> toList() {
        List<Object> list = new LinkedList<>();
        MyNode current = head;
        while (current != null) {
            list.add(current.getPayload());
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
    public MyIterator iterator() {
        return new MyLinkedListIterator(head);
    }

}
