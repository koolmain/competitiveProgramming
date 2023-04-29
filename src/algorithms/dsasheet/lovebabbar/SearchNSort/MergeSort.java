package algorithms.dsasheet.lovebabbar.SearchNSort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args){
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        MergeSort ms = new MergeSort(); 
        ms.mergeSort(arr, 0, arr.length -1);
        System.out.println(Arrays.toString(arr));
    }

    void mergeSort(int[] arr, int low, int high){
        if(low < high){
            int mid = low + (high-low)/2; 
            mergeSort(arr, low, mid); 
            mergeSort(arr, mid + 1, high); 

            merge(arr, low, mid, high); 
        }
    }

    void merge(int arr[], int low, int mid, int high){

        int n1 = mid - low +1 + 1; 
        int n2 = high - mid + 1; 

        int L[] = new int[n1]; 
        int R[] = new int[n2]; 
        int i=0;
        for(;i< n1-1;i++)
            L[i] = arr[low+i]; 
        L[i] = Integer.MAX_VALUE; 


        for(i=0;i< n2-1;i++)
            R[i] = arr[mid+1+i]; 
        R[i] = Integer.MAX_VALUE; 

        int j = i = 0;
        int k=low; 
        while (!(L[i] == Integer.MAX_VALUE  && R[j] == Integer.MAX_VALUE)){
            if(L[i] <= R[j]){
                arr[k] = L[i]; 
                i++;
            }else {
                arr[k] = R[j]; 
                j++; 
            }
            k++; 
        }


    }
    
}
