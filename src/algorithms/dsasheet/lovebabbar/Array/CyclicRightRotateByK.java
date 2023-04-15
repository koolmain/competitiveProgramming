package algorithms.dsasheet.lovebabbar.Array;

import java.util.Arrays;

public class CyclicRightRotateByK {
    
    public static void main(String[] args){
        CyclicRightRotateByK clk = new CyclicRightRotateByK(); 
        int arr[]= {5,3,2,8,6,4,3,8,6,3,1,5,6};
        clk.leftRotateByK(arr, 4);
        // clk.rightRotateByK(arr, 4);
    }
    void leftRotateByK(int arr[], int k){
     
        reverse(arr, 0,k-1); 
        reverse(arr, k,arr.length-1); 
        reverse(arr, 0, arr.length-1);
        System.out.println("After left rotation of "+k+ " " + Arrays.toString(arr));
    } 

    void rightRotateByK(int arr[], int k){
     
        reverse(arr, 0,arr.length-k-1); 
        reverse(arr, arr.length-k, arr.length-1); 
        reverse(arr, 0, arr.length-1);
        System.out.println("After right rotation of "+k+ " " + Arrays.toString(arr));
    } 

    private void reverse(int arr[], int from, int to){
        //always take care of adding in minus when working in '0'th index  i.e. (to-from+1)
        for(int i=0; i< (to-from+1)/2; i++ ){
            int temp = arr[from + i]; 
            arr[from + i] = arr[to-i]; 
            arr[to-i] = temp; 
        }
    } 
}
