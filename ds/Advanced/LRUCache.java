//This is not the proper implementation of LRU, this has  O(n) search time instead of O(1)
package Advanced;

import LinkedList.app.DoublyLinkedList;

//import java.util.HashMap;

public class LRUCache{

    //private HashMap<Integer,Integer> map;
    private DoublyLinkedList list;
    private final int length = 10;

    public LRUCache(){
        //map = new HashMap<>();
        list = new DoublyLinkedList();
    }

    public void enqueue(int data){
        if(list.countNodes()>length){
            list.removeFromEnd();
        }
        list.addAtBeginning(data);
        //map.put(data, 0);
    }

    public void clearCache(){
        list.clearList();
    }

    public void get(int data){
        list.moveToFront(data);
    }
    



}