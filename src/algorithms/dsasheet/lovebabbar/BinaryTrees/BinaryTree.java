package algorithms.dsasheet.lovebabbar.BinaryTrees;

import static java.lang.Math.*;

import java.util.LinkedList;

    class Node {
        int data; 
        Node left, right; 
        int level; 

        Node(int data){
            this.data = data; 
            this.left = this.right = null; 
        }

        Node(int data, int level){
            this.data = data; 
            this.level = level;
            this.left = this.right = null; 
        }
    }

public class BinaryTree {
    Node root; 

//  public class Node {
//             int data; 
//             Node left, right; 
//             int level; 
            
//             Node(int data, int level){
//                 this.data = data; 
//                 this.level = level;
//                 this.left = this.right = null; 
//             }
//         }

    public BinaryTree(int root){
        this.root = new Node(root,1); 
    }

    void printTree(Node node){
        System.out.println(node.data);

        int height = height(node); 

        for(int i=1; i <= height; i++){
            printLevel(node, i,1);
            System.out.println(); // adding new line before each level 
        }

    }

    void printLevel(Node node, int level, int currLevel){
        if(null == node)
            return; 
        if(level == currLevel){
            System.out.print(" "+node.data);
        }else{
            level--; 
            printLevel(node.left, level, currLevel);
            printLevel(node.right, level, currLevel);
        } 

    }

    int height(Node root){
        if(null == root)
            return 0; 
        int lHeight = height(root.left); 
        int rHeight = height(root.right); 

        return max(lHeight, rHeight) + 1; 
    }

    void createBinaryTree(Node root, LinkedList<Node> queue, int level){
        queue.add(root);
        Node node = queue.remove(); 
        int data = node.data; 
        while(node.level <= level){
            Node left = new Node(queue.isEmpty() ? ++data :queue.peekLast().data + 1,node.level+1); 
            node.left = left; 
            queue.add(left);
            Node right = new Node(queue.peekLast().data + 1,node.level+1); 
            node.right = right; 
            queue.add(right); 
            node = queue.remove(); 
        }
    }

    public static void main(String[] args){
        int root =1; 
        BinaryTree tree = new BinaryTree(root); 
        LinkedList<Node> queue = new LinkedList<Node>(); 
        tree.createBinaryTree(tree.root, queue, 4);
        // tree.root.left = new Node(2);
        // tree.root.right = new Node(3);
        // tree.root.left.left = new Node(4);
        // tree.root.left.right = new Node(5);
        // tree.root.right.left = new Node(6);
        // tree.root.right.right = new Node(7);
        tree.printTree(tree.root);


    }

}
