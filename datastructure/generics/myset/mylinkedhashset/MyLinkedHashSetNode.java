package yukwork.datastructure.generics.myset.mylinkedhashset;

public class MyLinkedHashSetNode<T> {

    private final T value;
    private MyLinkedHashSetNode<T> prev, next;

    public MyLinkedHashSetNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public MyLinkedHashSetNode<T> getPrev() {
        return prev;
    }

    public MyLinkedHashSetNode<T> getNext() {
        return next;
    }

    public void setPrev(MyLinkedHashSetNode<T> prev) {
        this.prev = prev;
    }

    public void setNext(MyLinkedHashSetNode<T> next) {
        this.next = next;
    }

}

