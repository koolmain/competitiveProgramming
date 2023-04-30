package algorithms.dsasheet.lovebabbar.BinaryTrees;

// Recursive Java program for level
// order traversal of Binary Tree
 
/* Class containing left and right child of current
    node and key value

    Time Complexity: O(N2), where N is the number of nodes in the skewed tree. So time complexity of printLevelOrder() is O(n) + O(n-1) + O(n-2) + .. + O(1) which is O(N2). 
    Auxiliary Space:  O(N) in the worst case. For a skewed tree, printGivenLevel() uses O(n) space for the call stack. For a Balanced tree, the call stack uses O(log n) space, (i.e., the height of the balanced tree). 

 
   
   */
   class Node {
    int data;
    Node left, right;
    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 
class LevelOrder1 {
    // Root of the Binary Tree
    Node root;
 
    public LevelOrder1() { root = null; }
 
    /* function to print level order traversal of tree*/
    void printLevelOrder()
    {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++)
            printCurrentLevel(root, i);
    }
 
    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(Node root)
    {
        if (root == null)
            return 0;
        else {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);
 
            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }
 
    /* Print nodes at the current level */
    void printCurrentLevel(Node root, int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }
 
    /* Driver program to test above functions */
    public static void main(String args[])
    {
        LevelOrder1 tree = new LevelOrder1();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(28);
        tree.root.left.left.left.left = new Node(40);
 
        System.out.println("Level order traversal of"
                           + "binary tree is ");
        tree.printLevelOrder();
    }
}