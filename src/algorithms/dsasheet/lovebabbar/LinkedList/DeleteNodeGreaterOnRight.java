package algorithms.dsasheet.lovebabbar.LinkedList;

public class DeleteNodeGreaterOnRight extends LinkedList{
    
    Node compute(Node head){
        Node prev = head, curr = head, newHead =head; 
        int update =0; 
        while(curr.next != null){
            if(curr.data < curr.next.data){
                curr =  curr.next;
                prev.next = curr;  
                if(update==0)
                    newHead = curr; 
                continue; 
            }
            update++; 
            prev = curr; 
            curr = curr.next; 
        }
        return newHead; 
    }
    public static void main(String[] args){
        DeleteNodeGreaterOnRight lst = new DeleteNodeGreaterOnRight(); 
        lst.addNode(12); 
        lst.addNode(15); 
        lst.addNode(10); 
        lst.addNode(11); 
        lst.addNode(5); 
        lst.addNode(6); 
        lst.addNode(2); 
        lst.addNode(3); 
        lst.printList(lst.head);
        Node newHead = lst.compute(lst.head); 
        lst.printList(newHead);
       

    }
}
