package algorithms.dsasheet.lovebabbar.LinkedList;

public class LinkedList {
    
    Node head; 
    Node end; 

    class Node{
                int data; 
                Node next; 
                Node(int data){
                    this.data = data; 
                    this.next = null ; 
                }
    }

    Node addNodeBackward(int data){
        Node newNode = new Node(data); 
        newNode.next = head; 
        head = newNode; 
        return newNode; 
    }

    void addNode(int data){
        Node newNode = new Node(data); 
        if(null == head){
            head = newNode; 
            end = newNode; 
        }else {
            end.next = newNode; 
            end = newNode; 
        }
    }

    Node createNode(int data){
        return new Node(data); 
    }


    void printList(Node head){
        Node cur = head; 
        while(cur != null){
            System.out.print(cur.data + " --> ");
            cur = cur.next; 
        }
        System.out.println();
    }

    // public static void main(String[] args){
    //     LinkedList lst = new LinkedList(); 
    //     lst.addNode(3); 
    //     lst.addNode(2); 
    //     lst.addNode(4); 
    //     lst.addNode(5); 
    //     lst.addNode(8); 
    //     lst.addNode(9); 
    //     lst.printList(lst.head);
    //     //Node head = lst.reverse(lst.head);
    //     lst.printList(head);


    // }
    
}
