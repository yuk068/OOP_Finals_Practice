package yukwork.datastructure.generics.mylist.mystack;

import yukwork.datastructure.generics.mylist.MyIterable;
import yukwork.datastructure.generics.mylist.MyIterator;
import yukwork.datastructure.generics.mylist.MyList;
import yukwork.datastructure.generics.mylist.myarraylist.MyArrayList;

public class MyStack<T> implements MyIterable<T> {

    private final MyList<T> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    public void push(T payload) {
        list.append(payload);
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }
        return list.get(list.size() - 1);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }
        T target = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return target;
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
