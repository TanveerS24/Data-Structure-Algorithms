package ds.app;

import ds.tree.Node;

//import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;

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

    public Node delete(Node root, int data){
        if(root == null){
            return null;
        }

        if(root.data<data) 
            root.right = delete(root.right, data);
        else if(root.data>data)
            root.left = delete(root.left, data);
        else{
            if(root.left == null && root.right ==null)
                root = null;
            
            else if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            else{
                Node Successor = findMin(root.right);
                root.data = Successor.data;
                root.right = delete(root.right, Successor.data);
            }
        }

        return root;
    }

    public Node findMin(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    //public boolean validateBST(){}
    
    //public int kthSmallestElement(){}

    //public int kthLargestElement(){}

    //public boolean isBalanced(){}

    //public boolean isBinarySearchTree(){}

    //public Node mirror(){}

    public void breadthFirstSearch(Node root){
        if(root == null){
            return;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            Node current = queue.poll();

			System.out.print(current.data+" ");

			if(current.left!=null) queue.offer(current.left);
			if(current.right != null) queue.offer(current.right);
        }
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
