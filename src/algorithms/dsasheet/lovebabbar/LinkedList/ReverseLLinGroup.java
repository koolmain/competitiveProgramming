package algorithms.dsasheet.lovebabbar.LinkedList;

public class ReverseLLinGroup {
    
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
    Node reverseInGroup(Node head, int k){
        int count=0; 
        Node prevOld = null, newHead = null, prev =null, cur = head, next = null; 
        while(cur != null)
        {
            count =0; 
            while(count++ < k && null != cur){
                next = cur.next; 
                cur.next = prev; 
                cur = next; 
                prev = cur; 
            }
            newHead = (null != newHead) ? newHead : prev;   
            if(null != prevOld)
                prevOld.next = prev; 
            prevOld = prev; 

        }
        return newHead; 
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
        ReverseLLinGroup lst = new ReverseLLinGroup(); 
        lst.addNode(2); 
        lst.addNode(3); 
        lst.addNode(8); 
        lst.addNode(7); 
        lst.addNode(4); 
        lst.addNode(1); 
        lst.addNode(9); 
        lst.printList(lst.head);
        Node head = lst.reverseInGroup(lst.head, 4);
        lst.printList(head);


    }
}
