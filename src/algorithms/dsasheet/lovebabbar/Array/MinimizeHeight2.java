package algorithms.dsasheet.lovebabbar.Array;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/minimize-the-heights3351/1
public class MinimizeHeight2 {

    public static void main(String[] args){
        MinimizeHeight2 mh2 = new MinimizeHeight2(); 
       int arr[] = {2,6,3,4,7,2,10,3,2,1}; // k =5 
      // int arr[] = {1,15,10}; 
        System.out.println(mh2.getMinDiff(arr, 10, 5));
    }

    //n - towers 
    // k - increment and decrement by 
    // int getMinDiff(int[] arr, int n, int k) {

    //     if(n== 0)
    //         return 0;
    //     if (n==1)
    //         return arr[0];
    //     int currentMin=0, currentMax=0, currentDiff; 
    //     Arrays.sort(arr);
    //     System.out.println(Arrays.toString(arr));
    //     int diff = ((arr[n-1] - k )  - (arr[0] +k)) < 0 ? 0:((arr[n-1] - k )  - (arr[0] +k)) ;
    //     System.out.println("first diff" + diff);
    //     //making partition on each i and taking max diff 
    //     for(int i=1; i< n-2; i++){
    //         if(arr[i] < k ) 
    //             continue;
    //         currentMin = Math.min(arr[0]+k , (arr[i]-k)); 
    //         System.out.println("Current min arr[0]+k "+ (arr[0]+k) +" arr["+i+"]-k) "+ (arr[i]-k) + " currentmin "+ currentMin);
            
    //         currentMax = Math.max(arr[n-1] -k , arr[i-1]+k); 
    //         System.out.println("Current max arr[n-1] -k "+ (arr[n-1] -k) +" arr["+(i-1)+"]+k "+ (arr[i-1]+k) + " currentmin "+ currentMax);
    //         currentDiff = currentMax - currentMin; 
    //         System.out.println("current diff "+currentDiff);
    //         diff = Math.min(diff, currentDiff);
    //     }

    //     return diff; 
    // }

    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int ans = arr[n-1] - arr[0]; 
        int curMin = arr[0]; 
        int curMax = arr[n-1]; 
        for(int i=1; i<n; i++){
            if(arr[i] < k) continue; 
            curMin = Math.min(arr[0]+k, arr[i]-k); 
            curMax = Math.max(arr[i-1]+k, arr[n-1]-k); 
            ans = Math.min(ans, curMax - curMin); 
        }
        return ans; 
    }
}
