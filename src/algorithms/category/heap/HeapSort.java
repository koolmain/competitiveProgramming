package algorithms.category.heap;

import java.util.Arrays; 

class HeapSort {


    void sort(int arr[],int N){
        int temp; 
        for(int i = N/2 -1 ; i >= 0; i--  ){
            heapify(arr, N, i);
        }
       System.out.println("After heapify "+ Arrays.toString(arr));

        for(int i= N-1 ; i > 0; i--){
            temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
            System.out.println("Heapify Start with i "+i);
            heapify(arr, i, 0);
            System.out.println("heapify array is arfter i "+i+" array "+Arrays.toString(arr));
        }

        System.out.println("Sorted Arrays is "+Arrays.toString(arr)); 
    }
    private void heapify(int arr[], int N, int i){

        int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < N && arr[l] < arr[largest])
			largest = l;

		// If right child is larger than largest so far
		if (r < N && arr[r] < arr[largest])
			largest = r;

		// If largest is not root
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(arr, N, largest);
		}
    }

    public static void main(String[] args ){
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        HeapSort hs = new HeapSort(); 
        hs.sort(arr, arr.length);
    }
}