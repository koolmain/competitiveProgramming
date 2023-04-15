package algorithms.dsasheet.lovebabbar.Array;

import java.util.Arrays;

//https://www.youtube.com/watch?v=hVl2b3bLzBw
public class MergeTwoSortedArray {

    public static void main(String args[]){
        MergeTwoSortedArray mta = new MergeTwoSortedArray(); 
        int a[] = {1,3,5,7}; 
        int b[] = {0,2,6,8,9}; 
        mta.mergerTwoArray(a, b, a.length);
        System.out.println(Arrays.toString(a)); 
        System.out.println(Arrays.toString(b));
    }
    
    void mergerTwoArray(int a[], int b[], int m){
        int aPtr=0;
        
        while(aPtr < m ){
            if(a[aPtr] > b[0]){
                int temp = a[aPtr]; 
                a[aPtr] = b[0]; 
                b[0] = temp; 
                insertInPlace(b, temp);
            }
            aPtr++;
        }
    }

    void insertInPlace(int arr[], int ele){
        int ctr =1; 
        while (ctr < arr.length && ele > arr[ctr]){
            arr[ctr-1] = arr[ctr]; 
            ctr++; 
        }
        arr[--ctr] = ele; 
    }
}
