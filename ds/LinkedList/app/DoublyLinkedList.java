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

    public void traverseForward(){
        if(isEmpty()){
            emptyMessage();
            return;
        }
        DoubleNode current = head;
        System.out.print("null <->");
        while(current!=null){
            System.out.print(current.getData()+" <-> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public void traverseReverse(){
        if(isEmpty()){
            emptyMessage();
            return;
        }
        DoubleNode current = tail;
        System.out.print("null <->");
        while(current!=null){
            System.out.print(current.getData()+" <-> ");
            current = current.getPrev();
        }
        System.out.println("null");
    }

    public boolean search(int data) {
        if(isEmpty()){
            emptyMessage();
            return false;
        }
        
        DoubleNode current = head;

        while (current != null) {
            if (current.getData() == data) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

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

    public void reverseList(){
        if(isEmpty()){
            emptyMessage();
            return;
        }
        if(countNodes() == 1 ){
            return ;
        }

        DoubleNode current = head;
        tail = head;

        while (current != null) {

            DoubleNode next = current.getNext();

            current.setNext(current.getPrev());
            current.setPrev(next);

            if (next == null) {
                head = current;
            }

            current = next;
        }

    }

    public DoubleNode middleNode(){
        if(isEmpty()){
            emptyMessage();
            return null;
        }

        DoubleNode slowptr = head;
        DoubleNode fastptr = head;

        while(fastptr!=null && fastptr.getNext() != null){
            slowptr = slowptr.getNext();
            fastptr = fastptr.getNext().getNext();
        }
        return slowptr;
    }

    public DoubleNode nthFromMiddle(int n){
        DoubleNode middle = middleNode();
        if(middle == null) {
            return middle;
        }

        while(n>0 && middle!=null){
            middle = middle.getNext();
            n--;
        }

        if(n!=0){
            return null;
        }
        return middle;
        
    }

    public void rotateLeft(int count){
        if(isEmpty()){
            emptyMessage();
            return;
        }

        if(head==tail){
            return;
        }

        count = count % countNodes();

        while(count>0){
            DoubleNode temp = head;
            head = temp.getNext();
            head.setPrev(null);
            temp.setNext(null);
            temp.setPrev(tail);
            tail.setNext(temp);
            tail = temp;
            count--; 
        }
    }

    public void rotateRight(int count){
        if(isEmpty()){
            emptyMessage();
            return;
        }

        if(head==tail){
            return;
        }

        count = count % countNodes();

        while(count>0){
            DoubleNode temp = tail;
            tail = tail.getPrev();
            tail.setNext(null);
            head.setPrev(temp);
            temp.setPrev(null);
            temp.setNext(head);
            head = temp;
            count--;   
        }
    }

    public boolean detectLoop(){
        if(isEmpty()){
            emptyMessage();
            return false;
        }

        if(head == tail){
            return false;
        }

        DoubleNode slowptr = head;
        DoubleNode fastptr = head;

        while(fastptr!=null && fastptr.getNext()!=null){
            slowptr = slowptr.getNext();
            fastptr = fastptr.getNext().getNext();
            if(slowptr == fastptr){
                return true;
            }
        }
        return false;
    }

    //Merge sort
    public void sortList() {
        if (isEmpty()) {
            emptyMessage();
            return;
        }

        if(head == tail){
            return;
        }

        head = mergeSort(head);

        // Reset tail
        tail = head;
        while (tail.getNext() != null) {
            tail = tail.getNext();
        }
    }

    private DoubleNode mergeSort(DoubleNode node) {

        if (node == null || node.getNext() == null) {
            return node;
        }

        DoubleNode middle = getMiddle(node);
        DoubleNode secondHalf = middle.getNext();

        middle.setNext(null);
        if (secondHalf != null) {
            secondHalf.setPrev(null);
        }

        DoubleNode left = mergeSort(node);
        DoubleNode right = mergeSort(secondHalf);

        return merge(left, right);
    }

    private DoubleNode getMiddle(DoubleNode node) {

        DoubleNode slow = node;
        DoubleNode fast = node;

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow;
    }

    private DoubleNode merge(DoubleNode left, DoubleNode right) {

        if (left == null)
            return right;

        if (right == null)
            return left;

        if (left.getData() <= right.getData()) {

            left.setNext(merge(left.getNext(), right));

            if (left.getNext() != null)
                left.getNext().setPrev(left);

            left.setPrev(null);

            return left;
        } else {

            right.setNext(merge(left, right.getNext()));

            if (right.getNext() != null)
                right.getNext().setPrev(right);

            right.setPrev(null);

            return right;
        }
    }

    private void emptyMessage(){
        System.out.println("Empty List");
    }

    private void invalidPositionMessage(){
        System.out.println("Invalid Position");
    }

    public static void main(String[] args) {

        // DoublyLinkedList ll = new DoublyLinkedList();

        // System.out.println("===== ADD AT BEGINNING =====");
        // ll.addAtBeginning(30);
        // ll.addAtBeginning(20);
        // ll.addAtBeginning(10);
        // ll.traverseForward();

        // System.out.println("\n===== ADD AT END =====");
        // ll.addAtEnd(40);
        // ll.addAtEnd(50);
        // ll.traverseForward();

        // System.out.println("\n===== ADD AT POSITION =====");
        // ll.addAtPosition(25, 2);      // Inserts after position 2 in your implementation
        // ll.traverseForward();

        // System.out.println("\n===== TRAVERSE REVERSE =====");
        // ll.traverseReverse();

        // System.out.println("\n===== SEARCH =====");
        // System.out.println("25 Found : " + ll.search(25));
        // System.out.println("100 Found : " + ll.search(100));

        // System.out.println("\n===== COUNT =====");
        // System.out.println("Node Count : " + ll.countNodes());

        // System.out.println("\n===== MIDDLE NODE =====");
        // System.out.println("Middle : " + ll.middleNode().getData());

        // System.out.println("\n===== NTH FROM MIDDLE =====");
        // DoubleNode node = ll.nthFromMiddle(2);
        // if (node != null)
        //     System.out.println(node.getData());
        // else
        //     System.out.println("Not Found");

        // System.out.println("\n===== ROTATE LEFT =====");
        // ll.rotateLeft(2);
        // ll.traverseForward();

        // System.out.println("\n===== ROTATE RIGHT =====");
        // ll.rotateRight(2);
        // ll.traverseForward();

        // System.out.println("\n===== REVERSE =====");
        // ll.reverseList();
        // ll.traverseForward();

        // System.out.println("\n===== REMOVE FROM BEGINNING =====");
        // ll.removeFromBeginning();
        // ll.traverseForward();

        // System.out.println("\n===== REMOVE FROM END =====");
        // ll.removeFromEnd();
        // ll.traverseForward();

        // System.out.println("\n===== REMOVE FROM POSITION =====");
        // ll.removeFromPosition(2);
        // ll.traverseForward();

        // System.out.println("\n===== DETECT LOOP =====");
        // System.out.println(ll.detectLoop());

        // System.out.println("\n===== SORT =====");
        // DoublyLinkedList sort = new DoublyLinkedList();

        // sort.addAtEnd(40);
        // sort.addAtEnd(10);
        // sort.addAtEnd(60);
        // sort.addAtEnd(20);
        // sort.addAtEnd(50);
        // sort.addAtEnd(30);

        // System.out.println("Before Sorting:");
        // sort.traverseForward();

        // sort.sortList();

        // System.out.println("After Sorting:");
        // sort.traverseForward();

        // System.out.println("\n===== CLEAR LIST =====");
        // ll.clearList();
        // ll.traverseForward();

        // System.out.println("Is Empty : " + ll.isEmpty());
    }
}
