package yukwork.datastructure.generics.mylist.mylinkedlist;

public class MyNode {

    private Object payload;
    private MyNode next;

    public MyNode(Object payload) {
        this.payload = payload;
    }

    public MyNode(Object payload, MyNode next) {
        this.payload = payload;
        this.next = next;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public MyNode getNext() {
        return next;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }

}
