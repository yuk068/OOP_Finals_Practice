package yukwork.datastructure.generics.mylist.mypriorityqueue;

import yukwork.datastructure.generics.mylist.MyIterable;
import yukwork.datastructure.generics.mylist.MyIterator;
import yukwork.datastructure.generics.mylist.MyList;
import yukwork.datastructure.generics.mylist.myarraylist.MyArrayList;

public class MyPriorityQueue<T> implements MyIterable<T> {

    private final MyList<T> list;

    public MyPriorityQueue() {
        list = new MyArrayList<>();
    }

    private static class Element implements Comparable<Element> {
        Object payload;
        int priority;

        Element(Object payload, int priority) {
            this.payload = payload;
            this.priority = priority;
        }

        @Override
        public int compareTo(Element other) {
            return Integer.compare(this.priority, other.priority);
        }

        @Override
        public String toString() {
            return "(" + payload + ", " + priority + ")";
        }
    }

    @SuppressWarnings("unchecked")
    public void enqueue(Object payload, int priority) {
        Element newElement = new Element(payload, priority);
        int insertIndex = 0;
        while (insertIndex < list.size() && ((Element) list.get(insertIndex)).compareTo(newElement) < 0) {
            insertIndex++;
        }
        list.insert((T) newElement, insertIndex);
    }

    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty!");
        }
        Object target = list.get(0);
        list.remove(0);
        return target;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty!");
        }
        return ((Element) list.get(0)).payload;
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
