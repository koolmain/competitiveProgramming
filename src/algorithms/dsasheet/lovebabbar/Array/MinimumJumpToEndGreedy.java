package algorithms.dsasheet.lovebabbar.Array;

//greedy approach 

public class MinimumJumpToEndGreedy {

    public static void main(String[] args){
        int arr[] = {1,3,5,8,9,2,6,7,6,8,9}; 
        // int arr[] = {0,1,1,1,1}; 
    //    int arr[] = {2,1,0,3}; 
       // int arr[] = {2,1,0,3,5,1,2}; 
        MinimumJumpToEndGreedy gd = new MinimumJumpToEndGreedy(); 
               // calling minJumps method
        System.out.println(gd.minJumps(arr));
    }

    // int possiblyJumpToEnd(int arr[], int length){
    //     int counter=0; 
    //     for(int i=0; i < length-1; ){
    //         int max=0; 
    //         if(i >= length)
    //             break; 
    //         for(int j=i; j< arr[i];j++){
    //             max = Math.max(max, arr[i]); 
    //         }
    //         i += max;
    //         counter++; 
    //     }
    //     return counter; 
    // }

    ////https://www.youtube.com/watch?v=Yrw3MNh_368
    static int jump(int arr[]){
        if(arr[0] == 0 && arr.length > 1) {
            return -1;
        }
        
        int maxReachable = 0;
        int currPos = 0;
        int jump = 0;
        int i = 0;
        for(; i<arr.length-1; i++) {
            if(i>maxReachable || maxReachable < arr.length)
                return -1;
            int currReachable = i + arr[i];
            maxReachable = Math.max(currReachable, maxReachable);
            
            if(currPos == i) {
                jump++;
                currPos = maxReachable;
            }
            

        }
        return jump;
        
    }

    //https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1
    static int minJumps(int arr[])
    {
        if (arr.length <= 1)
            return 0;

        // Return -1 if not possible to jump
        if (arr[0] == 0)
            return -1;

        // initialization
        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;

        // Start traversing array
        for (int i = 1; i < arr.length; i++) {
            // Check if we have reached 
// the end of the array
            if (i == arr.length - 1)
                return jump;

            // updating maxReach
            maxReach = Math.max(maxReach, i + arr[i]);

            // we use a step to get to the current index
            step--;
            System.out.println(" i "+i+" Step "+ step+ " maxreach "+maxReach);
            // If no further steps left
            if (step == 0) {
                System.out.println("Jump increasing "+jump);
                // we must have used a jump
                jump++;

                // Check if the current 
// index/position or lesser index
                // is the maximum reach point 
// from the previous indexes
                if (i >= maxReach)
                    return -1;

                // re-initialize the steps to the amount
                // of steps to reach maxReach from position i.
                step = maxReach - i;
            }
        }

        return -1;
    }

    // Driver method to test the above function
    // public static void main(String[] args)
    // {
    //     int arr[] = new int[] { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };

    //     // calling minJumps method
    //     System.out.println(minJumps(arr));
    // }
    
}
