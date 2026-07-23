package LinkedList.Node;

public class DoubleNode {
    private int data;
    private DoubleNode next;
    private DoubleNode prev;

    public DoubleNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public int getData() {
        return data;
    }
    public DoubleNode getNext() {
        return next ;
    }
    public DoubleNode getPrev() {
        return prev;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }
    public void setPrev(DoubleNode prev) {
        this.prev = prev;
    }
    public void setData(int data) {
        this.data = data;
    }
}
