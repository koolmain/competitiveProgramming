package algorithms.dsasheet.lovebabbar.LinkedList;

import static java.time.ZonedDateTime.now; 
import java.time.*; import java.time.format.*;
//https://450dsa.com/linked_list
//https://practice.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list5035/1
public class SegregateOddNEvenNodes extends LinkedList {


    Node segregate(Node head){
        Node oddStart = head, oddEnd = head, evenStart = null, evenEnd = null, current = head.next, temp =null; 
        oddStart.next = oddEnd; 
        int counter=1; 
        

        while(current != null){
            if(counter % 2 == 0){
                if(evenStart == null){
                    evenStart = createNode(current.data); 
                    evenEnd = evenStart; 
                    evenStart.next =evenEnd; 
                }else{
                    temp = evenEnd; 
                    evenEnd = createNode(current.data); 
                    temp.next = evenEnd; 
                }
            }else{
                    temp = oddEnd; 
                    oddEnd = createNode(current.data);
                    temp.next = oddEnd; 
            }
            current = current.next; 
            counter++; 
        }
        // System.out.println("odd List" );
        // printList(oddStart);
        // System.out.println("even List" );
        // printList(evenStart);
        evenEnd.next = oddStart; 
        return evenStart; 
    }
    
    public static void main(String[] args){
        // SegregateOddNEvenNodes ll = new SegregateOddNEvenNodes(); 
        // ll.addNode(17);
        // ll.addNode(15);
        // ll.addNode(8);
        // ll.addNode(9);
        // ll.addNode(2);
        // ll.addNode(4);
        // ll.addNode(6);
        // ll.printList(ll.head);
        // Node newHead = ll.segregate(ll.head); 
        // ll.printList(newHead);
       // System.out.println(now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT)); 
       System.out.println(now(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("YYYY-MM-DD'T'hh:mm:ss.s'T'ZD"))); 
    }
}
