package yukwork.datastructure.generics.myset.mytreeset;

import yukwork.datastructure.generics.myset.MyIterator;

import java.util.NoSuchElementException;
import java.util.Stack;

public class MyTreeSetIterator<T extends Comparable<T>> implements MyIterator<T> {

    private final Stack<MyTreeNode<T>> stack = new Stack<>();

    public MyTreeSetIterator(MyTreeNode<T> root) {
        pushLeft(root);
    }

    private void pushLeft(MyTreeNode<T> node) {
        while (node != null) {
            stack.push(node);
            node = node.getLeft();
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public T next() {
        if (!hasNext()) throw new NoSuchElementException();
        MyTreeNode<T> node = stack.pop();
        T result = node.getValue();
        if (node.getRight() != null) {
            pushLeft(node.getRight());
        }
        return result;
    }

}
