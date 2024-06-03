package yukwork.datastructure.nongenerics.mylist.mystack;

import yukwork.datastructure.nongenerics.mylist.MyIterable;
import yukwork.datastructure.nongenerics.mylist.MyIterator;
import yukwork.datastructure.nongenerics.mylist.MyList;
import yukwork.datastructure.nongenerics.mylist.myarraylist.MyArrayList;

public class MyStack implements MyIterable {

    private final MyList list;

    public MyStack() {
        list = new MyArrayList();
    }

    public void push(Object payload) {
        list.append(payload);
    }

    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }
        return list.get(list.size() - 1);
    }

    public Object pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }
        Object target = list.get(list.size() - 1);
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
    public MyIterator iterator() {
        return list.iterator();
    }

}
