package yukwork.datastructure.generics.myset.mytreeset;

import yukwork.datastructure.generics.myset.MyAbstractSet;
import yukwork.datastructure.generics.myset.MyIterator;
import yukwork.datastructure.generics.myset.MySet;

import java.util.ArrayList;
import java.util.List;

public class MyTreeSet<T extends Comparable<T>> extends MyAbstractSet<T> {

    private MyTreeNode<T> root;
    private int size;

    @Override
    public void add(T value) {
        if (value == null) throw new IllegalArgumentException("Value cannot be null");
        root = insert(root, value, null);
        size++;
        fixAfterInsertion(root);
    }

    private MyTreeNode<T> insert(MyTreeNode<T> node, T value, MyTreeNode<T> parent) {
        if (node == null) return new MyTreeNode<>(value, parent);

        int cmp = value.compareTo(node.getValue());
        if (cmp < 0) {
            node.setLeft(insert(node.getLeft(), value, node));
        } else if (cmp > 0) {
            node.setRight(insert(node.getRight(), value, node));
        }
        return node;
    }

    private void fixAfterInsertion(MyTreeNode<T> node) {
        while (node != null && node != root && node.getParent().isRed()) {
            if (node.getParent() == node.getGrandparent().getLeft()) {
                MyTreeNode<T> uncle = node.getUncle();
                if (uncle != null && uncle.isRed()) {
                    node.getParent().setBlack(true);
                    uncle.setBlack(true);
                    node.getGrandparent().setRed(true);
                    node = node.getGrandparent();
                } else {
                    if (node == node.getParent().getRight()) {
                        node = node.getParent();
                        rotateLeft(node);
                    }
                    node.getParent().setBlack(true);
                    node.getGrandparent().setRed(true);
                    rotateRight(node.getGrandparent());
                }
            } else {
                MyTreeNode<T> uncle = node.getUncle();
                if (uncle != null && uncle.isRed()) {
                    node.getParent().setBlack(true);
                    uncle.setBlack(true);
                    node.getGrandparent().setRed(true);
                    node = node.getGrandparent();
                } else {
                    if (node == node.getParent().getLeft()) {
                        node = node.getParent();
                        rotateRight(node);
                    }
                    node.getParent().setBlack(true);
                    node.getGrandparent().setRed(true);
                    rotateLeft(node.getGrandparent());
                }
            }
        }
        root.setBlack(true);
    }

    private void rotateLeft(MyTreeNode<T> node) {
        MyTreeNode<T> rightChild = node.getRight();
        node.setRight(rightChild.getLeft());
        if (rightChild.getLeft() != null) rightChild.getLeft().setParent(node);
        rightChild.setParent(node.getParent());
        if (node.getParent() == null) {
            root = rightChild;
        } else if (node == node.getParent().getLeft()) {
            node.getParent().setLeft(rightChild);
        } else {
            node.getParent().setRight(rightChild);
        }
        rightChild.setLeft(node);
        node.setParent(rightChild);
    }

    private void rotateRight(MyTreeNode<T> node) {
        MyTreeNode<T> leftChild = node.getLeft();
        node.setLeft(leftChild.getRight());
        if (leftChild.getRight() != null) leftChild.getRight().setParent(node);
        leftChild.setParent(node.getParent());
        if (node.getParent() == null) {
            root = leftChild;
        } else if (node == node.getParent().getRight()) {
            node.getParent().setRight(leftChild);
        } else {
            node.getParent().setLeft(leftChild);
        }
        leftChild.setRight(node);
        node.setParent(leftChild);
    }

    @Override
    public void remove(T value) {
        if (value == null) throw new IllegalArgumentException("Value cannot be null");
        MyTreeNode<T> node = search(root, value);
        if (node != null) {
            deleteNode(node);
            size--;
        }
    }

    private MyTreeNode<T> search(MyTreeNode<T> node, T value) {
        if (node == null || value.equals(node.getValue())) return node;
        int cmp = value.compareTo(node.getValue());
        if (cmp < 0) return search(node.getLeft(), value);
        else return search(node.getRight(), value);
    }

    private void deleteNode(MyTreeNode<T> node) {
        if (node == null) return;

        MyTreeNode<T> replacement;
        MyTreeNode<T> fixNode;
        boolean fixNodeOriginalColor = true;

        if (node.getLeft() == null) {
            fixNode = node.getRight();
            transplant(node, node.getRight());
        } else if (node.getRight() == null) {
            fixNode = node.getLeft();
            transplant(node, node.getLeft());
        } else {
            MyTreeNode<T> successor = minimum(node.getRight());
            fixNodeOriginalColor = successor.isBlack();
            fixNode = successor.getRight();

            if (successor.getParent() == node) {
                if (fixNode != null) fixNode.setParent(successor);
            } else {
                transplant(successor, successor.getRight());
                successor.setRight(node.getRight());
                successor.getRight().setParent(successor);
            }

            transplant(node, successor);
            successor.setLeft(node.getLeft());
            successor.getLeft().setParent(successor);
            successor.setBlack(node.isBlack());
        }

        if (fixNodeOriginalColor) {
            fixAfterDeletion(fixNode);
        }
    }

    private void transplant(MyTreeNode<T> u, MyTreeNode<T> v) {
        if (u.getParent() == null) {
            root = v;
        } else if (u == u.getParent().getLeft()) {
            u.getParent().setLeft(v);
        } else {
            u.getParent().setRight(v);
        }

        if (v != null) {
            v.setParent(u.getParent());
        }
    }

    private MyTreeNode<T> minimum(MyTreeNode<T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    private void fixAfterDeletion(MyTreeNode<T> x) {
        while (x != root && (x == null || x.isBlack())) {
            assert x != null;
            if (x == x.getParent().getLeft()) {
                MyTreeNode<T> w = x.getParent().getRight();
                if (w.isRed()) {
                    w.setBlack(true);
                    x.getParent().setRed(true);
                    rotateLeft(x.getParent());
                    w = x.getParent().getRight();
                }

                if ((w.getLeft() == null || w.getLeft().isBlack()) &&
                        (w.getRight() == null || w.getRight().isBlack())) {
                    w.setRed(true);
                    x = x.getParent();
                } else {
                    if (w.getRight() == null || w.getRight().isBlack()) {
                        if (w.getLeft() != null) w.getLeft().setBlack(true);
                        w.setRed(true);
                        rotateRight(w);
                        w = x.getParent().getRight();
                    }

                    w.setBlack(x.getParent().isBlack());
                    x.getParent().setBlack(true);
                    if (w.getRight() != null) w.getRight().setBlack(true);
                    rotateLeft(x.getParent());
                    x = root;
                }
            } else {
                MyTreeNode<T> w = x.getParent().getLeft();
                if (w.isRed()) {
                    w.setBlack(true);
                    x.getParent().setRed(true);
                    rotateRight(x.getParent());
                    w = x.getParent().getLeft();
                }

                if ((w.getLeft() == null || w.getLeft().isBlack()) &&
                        (w.getRight() == null || w.getRight().isBlack())) {
                    w.setRed(true);
                    x = x.getParent();
                } else {
                    if (w.getLeft() == null || w.getLeft().isBlack()) {
                        if (w.getRight() != null) w.getRight().setBlack(true);
                        w.setRed(true);
                        rotateLeft(w);
                        w = x.getParent().getLeft();
                    }

                    w.setBlack(x.getParent().isBlack());
                    x.getParent().setBlack(true);
                    if (w.getLeft() != null) w.getLeft().setBlack(true);
                    rotateRight(x.getParent());
                    x = root;
                }
            }
        }
        if (x != null) x.setBlack(true);
    }

    @Override
    public boolean contains(T value) {
        return search(root, value) != null;
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] toArray() {
        List<T> list = toList();
        return (T[]) list.toArray(new Comparable[size]);
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    protected MySet<T> createNewSet() {
        return new MyTreeSet<>();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public List<T> toList() {
        List<T> list = new ArrayList<>();
        inOrderTraversal(root, list);
        return list;
    }

    private void inOrderTraversal(MyTreeNode<T> node, List<T> list) {
        if (node != null) {
            inOrderTraversal(node.getLeft(), list);
            list.add(node.getValue());
            inOrderTraversal(node.getRight(), list);
        }
    }

    @Override
    public MyIterator<T> iterator() {
        return new MyTreeSetIterator<>(root);
    }

}
