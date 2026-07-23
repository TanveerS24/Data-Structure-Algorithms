package TreesDS.app;

import TreesDS.tree.Node;
import java.util.List;
import java.util.ArrayList;

//import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;

public class BinarySearchTree {
    
    @SuppressWarnings("unused")
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
                return null;
            
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
        if(root == null){
            return null;
        }
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public boolean validateBST(Node root){
        return validateBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validateBSTHelper(Node root, long min, long max){
        if(root == null)
            return true;

        if(root.data<=min || root.data>=max)
            return false;

        return validateBSTHelper(root.left, min, root.data) && validateBSTHelper(root.right, root.data, max);
    }
    
    public int kthSmallestElement(Node root, int k){
        int[] count = {0};
        return inOrder(root, k, count);
    }

    private int inOrder(Node root, int k, int[] count){
        if(root == null){
            return -1;
        }

        int left = inOrder(root.left, k, count);
        if(left != -1){
            return left;
        }

        count[0]++;
        if(count[0] == k){
            return root.data;
        }

        return inOrder(root.right, k, count);
    }

    public int kthLargestElement(Node root, int k){
        int[] count = {0};
        return reverseInOrder(root, k, count);
    }

    private int reverseInOrder(Node root, int k, int[] count){
        if(root == null){
            return -1;
        }

        int right = reverseInOrder(root.right, k, count);
        if(right != -1){
            return right;
        }

        count[0]++;
        if(count[0] == k){
            return root.data;
        }

        return reverseInOrder(root.left, k, count);
    }
    
    public boolean isBalanced(Node root){
        if(root == null){
            return true;
        }

        int leftDepth = findDepth(root.left);
        int rightDepth = findDepth(root.right);

        if(Math.abs(leftDepth - rightDepth) > 1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public void mirror(Node root){
        if(root == null){
            return;
        }

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        mirror(root.left);
        mirror(root.right);
    }

    public List<Integer> breadthFirstSearch(Node root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            Node current = queue.poll();

			result.add(current.data);

			if(current.left!=null) queue.offer(current.left);
			if(current.right != null) queue.offer(current.right);
        }
        return result;
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
        // int[] insertionValues = {50, 30, 70, 20, 40, 60, 80};
        // BinarySearchTree BT = new BinarySearchTree();
        // for(int x:insertionValues){
        //     BT.tree = BT.insert(BT.tree, x);
        // }
        // BT.inOrder(BT.tree);
        
    }
}
