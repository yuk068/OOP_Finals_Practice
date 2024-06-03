package yukwork.statistics.samplemanager.candidatemanager;

import java.util.NoSuchElementException;

public class MyLinkedList extends MyAbstractList {

    private MyLinkedListNode head;
    private int size;

    public MyLinkedList() {
        size = 0;
    }

    @Override
    public int size() {
        return size;
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
    public void remove(int index) {
        checkBound(index, size);
        if (index == 0) {
            head = head.getNext();
        } else {
            getNodeByIndex(index - 1).setNext(getNodeByIndex(index).getNext());
        }
        size--;
    }

    @Override
    public void append(Object payload) {
        getNodeByIndex(size).setNext(new MyLinkedListNode(payload));
        size++;
    }

    @Override
    public void insert(Object payload, int index) {
        checkBound(index, size + 1);
        if (index == 0) {
            MyLinkedListNode newHead = new MyLinkedListNode(payload);
            newHead.setNext(head);
            head = newHead;
        } else {
            MyLinkedListNode prevNode = getNodeByIndex(index);
            MyLinkedListNode newNode = new MyLinkedListNode(payload, prevNode.getNext());
            prevNode.setNext(newNode);
        }
        size++;
    }

    @Override
    public MyIterator iterator() {
        return new MyLinkedListIterator();
    }

    private MyLinkedListNode getNodeByIndex(int index) {
        MyLinkedListNode target = head;
        for (int i = 0; i < index; i++) {
            target = target.getNext();
        }
        return target;
    }

    private class MyLinkedListIterator implements MyIterator {

        private int currentPosition;

        public MyLinkedListIterator() {
            currentPosition = 0;
        }

        @Override
        public boolean hasNext() {
            return currentPosition < size && getNodeByIndex(currentPosition) != null;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                Object target = get(currentPosition);
                currentPosition++;
                return target;
            } else throw new NoSuchElementException("No such element!");
        }

        @Override
        public void remove() {
            if (hasNext()) {
                MyLinkedList.this.remove(currentPosition);
                currentPosition--;
            } else throw new NoSuchElementException("No such element!");
        }

    }

}
