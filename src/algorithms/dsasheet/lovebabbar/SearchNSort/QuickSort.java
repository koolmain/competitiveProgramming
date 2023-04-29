package algorithms.dsasheet.lovebabbar.SearchNSort;

import java.util.Arrays;

public class QuickSort {

    void sort(int[] arr, int low, int high){
        if(low < high){
            int mid = partition( arr, low, high); 
            sort(arr, low, mid -1);
            sort(arr,mid+1, high); 
        } 
    } 

    void swap(int arr[], int a, int b){
        int temp = arr[a]; 
        arr[a] = arr[b]; 
        arr[b] = temp; 
    }

    int partition(int[] arr, int low, int high){
        int pos = low -1; 
        int pivot = arr[high]; 
        for(int i=low; i< high; i++){
            if(arr[i] < pivot){
                pos++; 
                swap(arr, i, pos); 
            }
        }
        swap(arr,++pos, high); 
        return pos; 
    }
	// int partition(int[] arr, int low, int high)
	// {
	// 	// Choosing the pivot
	// 	int pivot = arr[high];

	// 	// Index of smaller element and indicates
	// 	// the right position of pivot found so far
	// 	int i = (low - 1);

	// 	for (int j = low; j <= high - 1; j++) {

	// 		// If current element is smaller than the pivot
	// 		if (arr[j] < pivot) {

	// 			// Increment index of smaller element
	// 			i++;
	// 			swap(arr, i, j);
	// 		}
	// 	}
	// 	swap(arr, i + 1, high);
	// 	return (i + 1);
	// }
    public static void main(String[] args){
        int[] arr={4,7,3,2,5,3,1,9}; 
        QuickSort quickSort = new QuickSort(); 
        quickSort.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    
}
