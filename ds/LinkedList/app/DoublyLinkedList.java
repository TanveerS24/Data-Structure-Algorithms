package LinkedList.app;

import LinkedList.Node.DoubleNode;


public class DoublyLinkedList {
    private DoubleNode head;
    private DoubleNode tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    private void addEmpty(int data){
        DoubleNode node = new DoubleNode(data);
        head = tail = node;
    }

    public void addAtBeginning(int data) {
        if(isEmpty()){
            addEmpty(data);
            return;
        }

        DoubleNode node = new DoubleNode(data);

        node.setNext(head);
        head.setPrev(node);
        head = node;
    }

    public void addAtEnd(int data) {
        if(isEmpty()){
            addEmpty(data);
            return;
        }
        DoubleNode node = new DoubleNode(data);
        tail.setNext(node);
        node.setPrev(tail);
        tail = node;

    }

    public void addAtPosition(int data, int position) {
        if(isEmpty()){
            emptyMessage();
            return;
        }
        DoubleNode current = validPosition(position);
        if(current != null){
            DoubleNode node = new DoubleNode(data);
            DoubleNode next = current.getNext();
            node.setPrev(current);
            node.setNext(next);
            current.setNext(node);
            if (next != null) {
                next.setPrev(node);
            }
            return;
        } 
    }
    
    public void removeFromBeginning() {
        if(removeHelper()){
            return;
        }

        head = head.getNext();
        head.setPrev(null);
    }

    public void removeFromEnd() {
        if(removeHelper()){
            return;
        }

        tail = tail.getPrev();
        tail.setNext(null);
    }

    public void removeFromPosition(int position) {
        if(position == 1){
            removeFromBeginning();
            return;
        }

        if(position == countNodes()){
            removeFromEnd();
            return;
        }

        DoubleNode current = validPosition(position);
        if(current!=null){
            DoubleNode prev = current.getPrev();
            DoubleNode next = current.getNext();
            prev.setNext(next);
            next.setPrev(prev);
        }
    }

    private boolean removeHelper(){
        if(isEmpty()){
            emptyMessage();
            return true;
        }

        if(countNodes() == 1) {
            clearList();
            return true;
        }
        return false;
    }

    private DoubleNode validPosition(int position){
        int count = 0;
        DoubleNode current = head;
        while(current!=null){
            count++;
            if(count == position){
                return current; 
            }
            current = current.getNext();
        }
        invalidPositionMessage();
        return null;
    }

    //public void traverseForward(){}

    //public void traverseReverse(){}

    //public boolean search(int data){}

    //public boolean update(int data1, int data2){}

    public int countNodes(){
        int count = 0;

        DoubleNode current = head;
        while(current!=null){
            count++;
            current = current.getNext();
        }
        return count;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void clearList(){
        head = tail = null;
    }

    //public void reverseList(){}

    //public DoubleNode middleNode(){}

    //public DoubleNode nthFromMiddle(int n){}

    //public void removeDuplicates(){}

    //public void rotateLeft(){}

    //public void rotateRight(){}

    //public boolean detectLoop(){}

    //public void sortList(){}

    private void emptyMessage(){
        System.out.println("Empty List");
    }

    private void invalidPositionMessage(){
        System.out.println("Invalid Position");
    }

    public static void main(String[] args){
        System.out.println("HI");
    }
}
