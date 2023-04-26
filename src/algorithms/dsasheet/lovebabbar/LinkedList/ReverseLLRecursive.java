package algorithms.dsasheet.lovebabbar.LinkedList;

public class ReverseLLRecursive {

    Node head; 

    class Node{
        int data; 
        Node next; 
        Node(int data){
            this.data = data; 
            this.next = null; 
        }
    }

    Node reverse(Node head){

    }

    Node addNode(int data){
        Node newNode = new Node(data); 
        newNode.next = this.head; 
        this.head = newNode; 
        return newNode; 
    }

    void printLL(Node head){
        Node cur = head; 
        while(null != cur){
            System.out.print(cur.data+" --> ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        ReverseLLRecursive llRecursive = new ReverseLLRecursive(); 
        llRecursive.addNode(7); 
        llRecursive.addNode(3); 
        llRecursive.addNode(5); 
        llRecursive.addNode(1); 
        llRecursive.addNode(4); 
        llRecursive.addNode(2); 
        llRecursive.addNode(9); 



    }
    
}
