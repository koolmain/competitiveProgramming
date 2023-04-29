package algorithms.dsasheet.lovebabbar.LinkedList;

//https://www.youtube.com/watch?v=YE9ggKeHeK0
public class SegregateOddEven extends LinkedList {

    Node segregate(Node head){
        if(head == null)
            return null; 

        Node odd = head; 
        Node even = odd.next; 
        Node temp = even; 

        while(null != even && null != even.next){
            odd.next = even.next; 
            odd = odd.next; 
            even.next = odd.next; 
            even = even.next; 
        }
        odd.next = temp; 
        return head; 
    }
    
    public static void main(String[] args){
        SegregateOddEven ll = new SegregateOddEven(); 
        ll.addNode(17);
        ll.addNode(15);
        ll.addNode(8);
        ll.addNode(9);
        ll.addNode(2);
        ll.addNode(4);
        ll.addNode(6);
        ll.printList(ll.head);
        Node newHead = ll.segregate(ll.head); 
        ll.printList(newHead);
    }
}
