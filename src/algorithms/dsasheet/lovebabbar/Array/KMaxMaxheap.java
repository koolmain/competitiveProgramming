package algorithms.dsasheet.lovebabbar.Array;

import java.util.Arrays;

import algorithms.category.graphs.minspanningtree.KruskalsMST;

//implementing using max heap 
public class KMaxMaxheap {

    public static void main(String[] args){
        int arr[] = { 7,10,4,3,20,15};
        KMaxMaxheap kMax = new KMaxMaxheap(); 
        kMax.getKMax(arr, 3); 

    }

    void swap(int arr[], int first, int second){
        int temp = arr[first]; 
        arr[first] = arr[second]; 
        arr[second] = temp; 
    }

    int getKMax(int arr[], int k){
        int N = k; 
        for(int i = N/2 -1 ; i >= 0 ; i--  ){
            heapify(arr, N, i);
        }

        for(int i = k; i< arr.length; i++){
            if(arr[0] < arr[i]){
                swap(arr, 0, i); 
                heapify(arr, N, 0);
            }
        }

        return arr[0]; 
    }

    void heapify(int arr[], int length, int pos){

        int left = 2*pos+ 1 ; 
        int right = 2*pos + 2; 
        int largest = pos; 
        if(left < length && arr[largest] < arr[left])
            largest = left; 
        if(right < length && arr[largest] < arr[right])
            largest = right; 

        if(largest != pos) {
            int temp = arr[largest]; 
            arr[largest] = arr[pos]; 
            arr[pos] = temp; 
        }
        heapify(arr, length, largest);
    }
    
}
