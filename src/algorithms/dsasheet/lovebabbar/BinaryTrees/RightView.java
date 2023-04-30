package algorithms.dsasheet.lovebabbar.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class RightView extends BinaryTree{

    public RightView(int root) {
        super(root);
    }

    void recursion(Node node, int level, List<Integer> view){
        if(null == node) return; 
        if(view.size() == level) 
            view.add(node.data); 
        recursion(node.left, level+1, view);
        recursion(node.right, level+1, view);
    }

    void rightView(Node root){
        List<Integer> views = new ArrayList<>(); 
        recursion(root, 0, views);
        views.stream().forEach(System.out::println);
    }

    public static void main(String[] args){
        RightView tree = new RightView(1); 
        tree.root.left = new Node(2,2);
        tree.root.right = new Node(3,2);
        tree.root.left.left = new Node(2,3);
        tree.root.left.right = new Node(5,3);
        tree.root.left.left.left = new Node(28,4);
        tree.root.left.left.left.left = new Node(40,4);
        tree.rightView(tree.root);
    }
    
}
