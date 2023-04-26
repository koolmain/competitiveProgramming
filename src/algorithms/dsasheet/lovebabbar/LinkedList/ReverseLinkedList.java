package algorithms.dsasheet.lovebabbar.LinkedList;

public class ReverseLinkedList {

    Node head; 

    private class Node{
                int data; 
                Node next; 
                Node(int data){
                    this.data = data; 
                    this.next = null ; 
                }
    }

    Node addNode(int data){
        Node newNode = new Node(data); 
        newNode.next = head; 
        head = newNode; 
        return newNode; 
    }
    Node reverse(Node head){
        Node prev=null,cur= head,next=null; 
        while(cur != null){
            next = cur.next; 
            cur.next = prev; 
            prev = cur; 
            cur = next; 
        } 
        return prev; 
    } 

    void printList(Node head){
        Node cur = head; 
        while(cur != null){
            System.out.print(cur.data + " --> ");
            cur = cur.next; 
        }
        System.out.println();
    }

    public static void main(String[] args){
        ReverseLinkedList lst = new ReverseLinkedList(); 
        lst.addNode(3); 
        lst.addNode(2); 
        lst.addNode(4); 
        lst.addNode(5); 
        lst.addNode(8); 
        lst.addNode(9); 
        lst.printList(lst.head);
        Node head = lst.reverse(lst.head);
        lst.printList(head);


    }
    
}
