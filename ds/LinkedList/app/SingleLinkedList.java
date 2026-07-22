package LinkedList.app;

import LinkedList.Node.SingleNode;

public class SingleLinkedList {
    private SingleNode head;

    public SingleLinkedList() {
        this.head = null;
    }

    public void insertAtBeginning(int data){
        SingleNode newNode = new SingleNode(data);
        newNode.setNext(head);
        head = newNode;
    }

    public void insertAtEnd(int data){
        SingleNode newNode = new SingleNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        SingleNode current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
    }

    public void insertAtPosition(int data, int position){
        if(position == 0){
            insertAtBeginning(data);
            return;
        }
        
        SingleNode newNode = new SingleNode(data);
        SingleNode current = head;
        for(int i = 0; i < position - 1; i++){
            if(current == null){
                throw new IndexOutOfBoundsException("Position out of bounds");
            }
            current = current.getNext();
        }

        newNode.setNext(current.getNext());
        current.setNext(newNode);
    }

    public void traversal(){
        SingleNode current = head;
        while (current != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public void deleteAtBeginning(){
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.getNext();
    }

    public void deleteAtEnd(){
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.getNext() == null) {
            head = null;
            return;
        }
        SingleNode current = head;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        current.setNext(null);
    }

    public void deleteAtPosition(int position){
        if (position == 0) {
            deleteAtBeginning();
            return;
        }
        SingleNode current = head;
        for (int i = 0; i < position - 1; i++) {
            if (current == null || current.getNext() == null) {
                throw new IndexOutOfBoundsException("Position out of bounds");
            }
            current = current.getNext();
        }
        if (current.getNext() == null) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }
        current.setNext(current.getNext().getNext());
    }

    public boolean search(int data){
        SingleNode current = head;
        int position = 0;
        while (current != null) {
            if (current.getData() == data) {
                System.out.println("Data found at position: " + position);
                return true;
            }
            current = current.getNext();
            position++;
        }
        System.out.println("Data not found");
        return false;
    }

    public void update(int oldData, int newData){
        if(search(oldData)){
            SingleNode current = head;
            while (current != null) {
                if (current.getData() == oldData) {
                    current.setData(newData);
                    System.out.println("Data updated from " + oldData + " to " + newData);
                    return;
                }
                current = current.getNext();
            }
        } else {
            System.out.println("Old data not found, update failed");
        }
    }

    public int countNodes(){
        SingleNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        //System.out.println("Number of nodes in the list: " + count);
        return count;
    }

    public void reverseList(){
        SingleNode prev = null;
        SingleNode current = head;
        SingleNode next = null;

        while(current != null){
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void displayReverse(SingleNode node){
        if(node == null){
            return;
        }
        displayReverse(node.getNext());
        System.out.print(node.getData() + " -> ");

    }

    public void findMiddleNode(){
        SingleNode slowPtr = head;
        SingleNode fastPtr = head;

        if(head != null){
            while(fastPtr != null && fastPtr.getNext() != null){
                fastPtr = fastPtr.getNext().getNext();
                slowPtr = slowPtr.getNext();
            }
            System.out.println("Middle node data: " + slowPtr.getData());
        }
    }

    public void NthNodeFromEnd(int n){
        SingleNode firstPtr = head;
        SingleNode secondPtr = head;

        if(head != null){
            for(int i = 0; i < n; i++){
                if(firstPtr == null){
                    System.out.println("Position out of bounds");
                    return;
                }
                firstPtr = firstPtr.getNext();
            }

            while(firstPtr != null){
                firstPtr = firstPtr.getNext();
                secondPtr = secondPtr.getNext();
            }
            System.out.println("Nth node from end data: " + secondPtr.getData());
        }
    }

    public void detectLoop(){
        SingleNode slowPtr = head;
        SingleNode fastPtr = head;

        while(fastPtr != null && fastPtr.getNext() != null){
            fastPtr = fastPtr.getNext().getNext();
            slowPtr = slowPtr.getNext();
            if(slowPtr == fastPtr){
                System.out.println("Loop detected");
                return;
            }
        }
        System.out.println("No loop detected");
    }

    public void removeDuplicates(){
        SingleNode current = head;
        while(current != null && current.getNext() != null){
            if(current.getData() == current.getNext().getData()){
                current.setNext(current.getNext().getNext());
            } else {
                current = current.getNext();
            }
        }
    }

    public void rotateList(int k){
        if(head == null || k == 0){
            return;
        }
        SingleNode current = head;
        int count = 1;
        while(current.getNext() != null){
            current = current.getNext();
            count++;
        }
        k = k % count;
        if(k == 0){
            return;
        }
        current.setNext(head);
        for(int i = 0; i < count - k; i++){
            head = head.getNext();
        }
        current = head;
        for(int i = 0; i < count - k - 1; i++){
            current = current.getNext();
        }
        current.setNext(null);
    }

    public boolean isEmpty(SingleNode head) {
        return head == null;
    }

    public void clearList(){
        head = null;
    }

    public void swapNodes(int data1, int data2){
        if(data1 == data2){
            return;
        }

        if(!search(data1) || !search(data2)){
            System.out.println("One or both elements not found, swap failed");
            return;
        }

        SingleNode prevNode1 = null, currNode1 = head;
        while(currNode1 != null && currNode1.getData() != data1){
            prevNode1 = currNode1;
            currNode1 = currNode1.getNext();
        }
        SingleNode prevNode2 = null, currNode2 = head;
        while(currNode2 != null && currNode2.getData() != data2){
            prevNode2 = currNode2;
            currNode2 = currNode2.getNext();
        }

        if(prevNode1 != null){
            prevNode1.setNext(currNode2);
        } else {
            head = currNode2;
        }
        if(prevNode2 != null){
            prevNode2.setNext(currNode1);
        } else {
            head = currNode1;
        }
    } 

    public static void main(String[] args) {

        // SingleLinkedList ll = new SingleLinkedList();

        // System.out.println("===== INSERT =====");
        // ll.insertAtBeginning(30);
        // ll.insertAtBeginning(20);
        // ll.insertAtBeginning(10);
        // ll.insertAtEnd(40);
        // ll.insertAtEnd(50);
        // ll.insertAtPosition(25, 2);
        // ll.traversal();
        // System.out.println("\n===== SEARCH =====");
        // ll.search(30);
        // ll.search(100);
        // System.out.println("\n===== UPDATE =====");
        // ll.update(25, 26);
        // ll.traversal();
        // System.out.println("\n===== COUNT =====");
        // System.out.println("Node Count : " + ll.countNodes());
        // System.out.println("\n===== FIND MIDDLE =====");
        // ll.findMiddleNode();
        // System.out.println("\n===== NTH NODE FROM END =====");
        // ll.NthNodeFromEnd(2);
        // System.out.println("\n===== DISPLAY REVERSE =====");
        // ll.displayReverse(ll.head);      // Make head public or create a wrapper method.
        // System.out.println("null");
        // System.out.println("\n===== REVERSE LIST =====");
        // ll.reverseList();
        // ll.traversal();
        // System.out.println("\n===== DELETE BEGINNING =====");
        // ll.deleteAtBeginning();
        // ll.traversal();
        // System.out.println("\n===== DELETE END =====");
        // ll.deleteAtEnd();
        // ll.traversal();
        // System.out.println("\n===== DELETE POSITION =====");
        // ll.deleteAtPosition(1);
        // ll.traversal();
        // System.out.println("\n===== ROTATE LIST =====");
        // ll.insertAtEnd(60);
        // ll.insertAtEnd(70);
        // ll.insertAtEnd(80);
        // ll.traversal();
        // ll.rotateList(2);
        // System.out.println("After Rotation:");
        // ll.traversal();
        // System.out.println("\n===== REMOVE DUPLICATES =====");
        // SingleLinkedList dup = new SingleLinkedList();
        // dup.insertAtEnd(10);
        // dup.insertAtEnd(20);
        // dup.insertAtEnd(20);
        // dup.insertAtEnd(30);
        // dup.insertAtEnd(30);
        // dup.insertAtEnd(30);
        // dup.insertAtEnd(40);
        // System.out.println("Before:");
        // dup.traversal();
        // dup.removeDuplicates();
        // System.out.println("After:");
        // dup.traversal();
        // System.out.println("\n===== DETECT LOOP =====");
        // ll.detectLoop();     // Should print No loop detected
        // System.out.println("\n===== ISEMPTY =====");
        // System.out.println(ll.isEmpty(ll.head));
        // System.out.println("\n===== CLEAR LIST =====");
        // ll.clearList();
        // ll.traversal();
        // System.out.println("Empty : " + ll.isEmpty(ll.head));
    }
}
