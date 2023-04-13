package algorithms.dsasheet.lovebabbar.Array;

import java.util.Arrays;

public class Sort012 {
    public static void main(String[] args){
       int arr[] =  {0, 1, 2, 0, 1, 2}; 
        // int arr[] = {2,1,2,0,2,1,0,1,0,1,2,1,0,1,1}; 
        Sort012 sort012 = new Sort012(); 
        sort012.sort012(arr,arr.length);
        for(int i =0; i< arr.length;i++)
            System.out.print(arr[i]+" ");
    }

    // static void sort012(int a[], int arr_size)
    // {
    //     int lo = 0;
    //     int hi = arr_size - 1;
    //     int mid = 0, temp = 0;
    //     // Iterate till all the elements
    //     // are sorted
    //     while (mid <= hi) {
    //         switch (a[mid]) {
    //             // If the element is 0
    //         case 0: {
    //             temp = a[lo];
    //             a[lo] = a[mid];
    //             a[mid] = temp;
    //             lo++;
    //             mid++;
    //             break;
    //         }
    //             // If the element is 1
    //         case 1:
    //             mid++;
    //             break;
    //             // If the element is 2
    //         case 2: {
    //             temp = a[mid];
    //             a[mid] = a[hi];
    //             a[hi] = temp;
    //             hi--;
    //             break;
    //         }
    //         }
    //     }
    // }


    //using for loop 
    void sort012(int arr[], int n){
        int zP =0, tP=arr.length;  
        for(int i=0;i<arr.length; i++){
            //break the loop if counter reaches to twoPointer 
            if(i == tP) break; 
            if(arr[i] == 0) {
                swap(arr, zP++, i);
                //zP++; 
            }
            if(arr[i] ==2){
                swap(arr, --tP, i--); 
            }
            System.out.print(Arrays.toString(arr));
            System.out.println("       zp "+zP+ " i "+i + " tP "+tP); 
        }
    }

    void swap(int arr[], int ptr, int index){
        int temp= arr[ptr]; 
        arr[ptr] = arr[index]; 
        arr[index] = temp; 
    }
}
