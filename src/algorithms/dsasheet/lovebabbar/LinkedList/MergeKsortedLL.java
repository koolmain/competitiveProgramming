package algorithms.dsasheet.lovebabbar.LinkedList;

//https://practice.geeksforgeeks.org/problems/merge-k-sorted-linked-lists/1
//https://www.youtube.com/watch?v=vhdmB3HKQdI&t=554s
public class MergeKsortedLL extends LinkedList {

    int[] heap;
    int k; 

    MergeKsortedLL(int k)

    void heapify(int pos, int k){
            int left = 2* pos + 1; 
            int right = 2* pos + 2; 
            int heavier = pos; 
            if(left < k &&  heap[heavier] < heap[left])
                heavier = left; 
            if(right < k && heap[heavier] < heap[right])
                heavier = right; 

            if(heavier != pos){
                int temp = heap[pos]; 
                heap[pos] = heap[heavier]; 
                heap[heavier] = temp; 
                heapify(heavier, k);
            }  
    }
    
    Node mergeKList(Node[] arr ,int k){
        heap = new int[k];
        Node[] ptrs = new Node[k]; 
        Node head; 

        for(int i=0; i< k; i++){

        }

        
        return head; 
    }
}
