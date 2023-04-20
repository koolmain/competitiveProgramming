package algorithms.dsasheet.lovebabbar.Array;

//Using two pointer
//https://www.youtube.com/watch?v=ZI2z5pq0TqA
public class TrappingRainWater {

    public static void main(String[] args){
        // int[] arr= {3,0,0,2,0,4}; 
        int[] arr= {7,4,5,0}; 
        // int[] arr= {7,4,0,9}; 
        // int[] arr= {6,9,9}; 
        System.out.println(trap(arr));
        System.out.println(trappingWater(arr,arr.length));
    }


    public static int trap(int[] heights) {
        if (heights.length == 0) return 0;

        int l = 0, r = heights.length - 1;
        int leftMax = heights[l], rightMax = heights[r];
        int res = 0;

        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, heights[l]);
                res += leftMax - heights[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, heights[r]);
                res += rightMax - heights[r];
            }
        }

        return res;
    }

    static long trappingWater(int arr[], int n) { 
        int l=0, r = n-1; 
        int lmax = arr[l], rmax = arr[r]; 
        int res=0; 
        while(l<r){
            if(lmax < rmax){
                l+=1; 
                lmax = Math.max(lmax, arr[l]); 
                res += lmax - arr[l]; 
            }else{
                r-=1; 
                rmax = Math.max(rmax, arr[r]); 
                res += rmax - arr[r]; 
            }
    }
        return res; 
    }
    
    // static long trappingWater(int arr[], int n) { 
    //     int left=0;
    //     long waterBlock =0; 
    //     for(int i =0; i< n; i++){
    //         // if(left < 0 && arr[i] > 0)
    //         //     left= i; 
    //         if(arr[i] > arr[left]){
    //             int ctr = left; 
    //             while(ctr < i ){
    //                 waterBlock += arr[left] - arr[ctr]; 
    //                 ctr++; 
    //             }
    //             left = i; 
    //         }
    //     }
    //     return waterBlock; 
    // } 
}
