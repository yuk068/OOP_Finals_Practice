package yukwork.datastructure.nongenerics.mylist.mylinkedlist;

import yukwork.datastructure.nongenerics.mylist.MyAbstractList;
import yukwork.datastructure.nongenerics.mylist.MyIterator;

import java.util.LinkedList;
import java.util.List;

public class MyLinkedList extends MyAbstractList {

    private MyNode head;
    private int size;

    public MyLinkedList() {
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void append(Object payload) {
        if (size == 0) {
            head = new MyNode(payload);
        } else {
            getNodeByIndex(size - 1).setNext(new MyNode(payload));
        }
        size++;
    }

    @Override
    public void insert(Object payload, int index) {
        checkBound(index, size + 1);
        if (index == 0) {
            head = new MyNode(payload, head);
        } else {
            MyNode prevNode = getNodeByIndex(index - 1);
            prevNode.setNext(new MyNode(payload, prevNode.getNext()));
        }
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
            MyNode prevNode = getNodeByIndex(index - 1);
            prevNode.setNext(prevNode.getNext().getNext());
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
        Object[] toArray = new Object[size];
        for (int i = 0; i < size; i++) {
            toArray[i] = get(i);
        }
        return toArray;
    }

    @Override
    public List<Object> toList() {
        List<Object> toList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            toList.add(get(i));
        }
        return toList;
    }

    private MyNode getNodeByIndex(int index) {
        MyNode target = head;
        for (int i = 0; i < index; i++) {
            target = target.getNext();
        }
        return target;
    }

    @Override
    public MyIterator iterator() {
        return new MyLinkedListIterator(head);
    }

}
