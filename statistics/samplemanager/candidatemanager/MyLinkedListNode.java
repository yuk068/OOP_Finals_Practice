package yukwork.statistics.samplemanager.candidatemanager;

public class MyLinkedListNode {

    private Object payload;
    private MyLinkedListNode next;

    public MyLinkedListNode(Object payload) {
        this.payload = payload;
    }

    public MyLinkedListNode(Object payload, MyLinkedListNode next) {
        this.payload = payload;
        this.next = next;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public MyLinkedListNode getNext() {
        return next;
    }

    public void setNext(MyLinkedListNode node) {
        next = node;
    }

}
