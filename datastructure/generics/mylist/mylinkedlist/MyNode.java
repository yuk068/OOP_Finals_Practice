package yukwork.datastructure.generics.mylist.mylinkedlist;

public class MyNode<T> {

    private T payload;
    private MyNode<T> next;

    public MyNode(T payload) {
        this.payload = payload;
    }

    public MyNode(T payload, MyNode<T> next) {
        this.payload = payload;
        this.next = next;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public MyNode<T> getNext() {
        return next;
    }

    public void setNext(MyNode<T> next) {
        this.next = next;
    }

}
