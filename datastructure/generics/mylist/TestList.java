package yukwork.datastructure.generics.mylist;

import yukwork.datastructure.generics.mylist.myarraylist.MyArrayList;
import yukwork.datastructure.generics.mylist.mydeque.MyDeque;
import yukwork.datastructure.generics.mylist.mydoublylinkedlist.MyDoublyLinkedList;
import yukwork.datastructure.generics.mylist.mylinkedlist.MyLinkedList;
import yukwork.datastructure.generics.mylist.mypriorityqueue.MyPriorityQueue;
import yukwork.datastructure.generics.mylist.myqueue.MyQueue;
import yukwork.datastructure.generics.mylist.mystack.MyStack;

import java.util.List;

public class TestList {

    public static void main(String[] args) {
        System.out.println("Test MyArrayList:");
        testList(new MyArrayList<>());
        System.out.println("Test MyLinkedList:");
        testList(new MyLinkedList<>());
        System.out.println("Test MyDoublyLinkedList:");
        testList(new MyDoublyLinkedList<>());
        testStack();
        testQueue();
        testDeque();
        testPriorityQueue();
    }

    public static void testPriorityQueue() {
        MyPriorityQueue<String> pq = new MyPriorityQueue<>();

        pq.enqueue("A", 3);
        pq.enqueue("B", 1);
        pq.enqueue("C", 2);
        pq.enqueue("D", 4);

        System.out.println("Priority queue after enqueuing: " + priorityQueueToString(pq));

        System.out.println("Peek: " + pq.peek());

        System.out.println("Dequeue: " + pq.dequeue());
        System.out.println("Priority queue after dequeuing: " + priorityQueueToString(pq));

        System.out.println("Peek: " + pq.peek());

        System.out.println("Is priority queue empty? " + pq.isEmpty());

        System.out.println("Priority queue size: " + pq.size() + "\n");
    }

    private static <T> String priorityQueueToString(MyPriorityQueue<T> pq) {
        StringBuilder sb = new StringBuilder("[");
        MyIterator<T> iterator = pq.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void testDeque() {
        MyDeque<String> deque = new MyDeque<>();
        deque.insertRear("A");
        deque.insertRear("B");
        deque.insertRear("C");
        System.out.println("After inserting at the rear: " + dequeToString(deque));

        deque.insertFront("1");
        deque.insertFront("2");
        deque.insertFront("3");
        System.out.println("After inserting at the front: " + dequeToString(deque));

        System.out.println("Removed from front: " + deque.removeFront());
        System.out.println("After removing from the front: " + dequeToString(deque));

        System.out.println("Removed from rear: " + deque.removeRear());
        System.out.println("After removing from the rear: " + dequeToString(deque));

        System.out.println("Peek front: " + deque.peekFront());
        System.out.println("Peek rear: " + deque.peekRear());

        System.out.println("Is deque empty? " + deque.isEmpty());

        System.out.println("Deque size: " + deque.size() + "\n");
    }

    private static <T> String dequeToString(MyDeque<T> deque) {
        StringBuilder sb = new StringBuilder("[");
        MyIterator<T> iterator = deque.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void testQueue() {
        MyQueue<String> queue = new MyQueue<>();

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        System.out.println("Front element: " + queue.peek());

        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());

        System.out.println("Is queue empty? " + queue.isEmpty());

        System.out.println("Dequeued element: " + queue.dequeue());

        System.out.println("Is queue empty? " + queue.isEmpty());

        try {
            System.out.println("Front element: " + queue.peek());
        } catch (IllegalStateException e) {
            System.out.println("Cannot peek from an empty queue");
        }

        try {
            System.out.println("Dequeued element: " + queue.dequeue());
        } catch (IllegalStateException e) {
            System.out.println("Cannot dequeue from an empty queue");
        }
        System.out.println();
    }

    public static void testStack() {
        MyStack<String> stack = new MyStack<>();

        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println("Top element: " + stack.peek());

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());

        System.out.println("Is stack empty? " + stack.isEmpty());

        System.out.println("Popped element: " + stack.pop());

        System.out.println("Is stack empty? " + stack.isEmpty());

        try {
            System.out.println("Top element: " + stack.peek());
        } catch (IllegalStateException e) {
            System.out.println("Cannot peek from an empty stack");
        }

        try {
            System.out.println("Popped element: " + stack.pop());
        } catch (IllegalStateException e) {
            System.out.println("Cannot pop from an empty stack");
        }
        System.out.println();
    }

    public static void testList(MyList<String> list) {
        list.append("A");
        list.append("B");
        list.append("C");

        list.insert("D", 1);

        list.insertAtStart("E");

        list.insertAtEnd("F");

        list.remove("B");

        list.remove(2);
        System.out.println(list);

        System.out.println("Element at index 1: " + list.get(1));

        list.set("G", 0);

        Object[] array = list.toArray();
        System.out.print("Array: ");
        for (Object obj : array) {
            System.out.print(obj + " ");
        }
        System.out.println();

        List<String> arrayList = list.toList();
        System.out.print("List: ");
        for (Object obj : arrayList) {
            System.out.print(obj + " ");
        }
        System.out.println();

        System.out.println("Is list empty? " + list.isEmpty() + "\n");
    }

}
