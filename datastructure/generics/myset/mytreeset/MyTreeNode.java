package yukwork.datastructure.generics.myset.mytreeset;

public class MyTreeNode<T> {

    private T value;
    private MyTreeNode<T> left, right;
    private MyTreeNode<T> parent;
    private boolean color;

    public MyTreeNode(T value, MyTreeNode<T> parent) {
        this.value = value;
        this.parent = parent;
        this.color = true;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public MyTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(MyTreeNode<T> left) {
        this.left = left;
    }

    public MyTreeNode<T> getRight() {
        return right;
    }

    public void setRight(MyTreeNode<T> right) {
        this.right = right;
    }

    public MyTreeNode<T> getParent() {
        return parent;
    }

    public void setParent(MyTreeNode<T> parent) {
        this.parent = parent;
    }

    public boolean isRed() {
        return color;
    }

    public void setRed(boolean color) {
        this.color = color;
    }

    public boolean isBlack() {
        return !color;
    }

    public void setBlack(boolean color) {
        this.color = !color;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public boolean isRoot() {
        return parent == null;
    }

    public boolean hasLeftChild() {
        return left != null;
    }

    public boolean hasRightChild() {
        return right != null;
    }

    public boolean isLeftChild() {
        return parent != null && parent.getLeft() == this;
    }

    public boolean isRightChild() {
        return parent != null && parent.getRight() == this;
    }

    public MyTreeNode<T> getSibling() {
        if (isLeftChild()) {
            return parent.getRight();
        } else if (isRightChild()) {
            return parent.getLeft();
        }
        return null;
    }

    public MyTreeNode<T> getUncle() {
        if (parent == null || parent.getParent() == null) {
            return null;
        }
        return parent.getSibling();
    }

    public MyTreeNode<T> getGrandparent() {
        if (parent == null) {
            return null;
        }
        return parent.getParent();
    }

}
