package ds.app;

import ds.tree.Node;
//import java.util.Scanner;

public class BinarySearchTree {
    
    private Node tree;

    

    public BinarySearchTree(){
        this.tree = null;
    }
    
    public Node insert(Node root, int data) {

        if(root == null){
            return new Node(data);
        }

        if(data < root.data){
            root.left = insert(root.left, data);
        }
        else if(data > root.data){
            root.right = insert(root.right, data);
        }

        return root;
    }

    public void delete(int data){
        
    }

    public int findDepth(Node root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(findDepth(root.left), findDepth(root.right));
    }

    public void inOrder(Node root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }
    
    public static void main(String[] args){
        int[] insertionValues = {50, 30, 70, 20, 40, 60, 80};
        BinarySearchTree BT = new BinarySearchTree();
        for(int x:insertionValues){
            BT.tree = BT.insert(BT.tree, x);
        }
        BT.inOrder(BT.tree);
        
    }
}
