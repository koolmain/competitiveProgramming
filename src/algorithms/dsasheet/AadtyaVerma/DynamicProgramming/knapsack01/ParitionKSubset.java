package algorithms.dsasheet.AadtyaVerma.DynamicProgramming.knapsack01;

import java.util.Arrays;
//https://www.youtube.com/watch?v=mBk4I0X46oI

public class ParitionKSubset {
    public static void main(String[] args){
    //    int a[] = {4,3,2,3,5,2,1}; 
        int a[] = {2,2,2,2,3,4,5};
        int k =4; 
        ParitionKSubset ps = new ParitionKSubset(); 
        System.out.println(ps.isKPartitionPossible(a, a.length, k));
    }

    public boolean isKPartitionPossible(int a[], int n, int k)
    {
        int sum =0; 
        for(int i=0; i< a.length; i++)
            sum += a[i]; 
        if(sum % k != 0)
            return false;
        sum/=k; 

        return backtrack(0, k, sum, a, 0, new boolean[a.length]); 

    }

    public boolean backtrack(int i , int k, int sum, int[] arr, int subsetSum, boolean[] visited){
        if(k==0)
            return true; 
        if(subsetSum == sum )
            return backtrack(0, k-1, sum, arr, 0, visited); 
        for(int j=i; j< arr.length; j++){
            if(visited[j] ||  (subsetSum + arr[j] > sum))
                    continue; 
            visited[j] = true; 
            if(backtrack(j + 1, k, sum, arr, subsetSum + arr[j], visited))
                return true; 
            visited[j] = false; 
        } 
        return false; 
    }

    void print2d(boolean[][] dp){
        //printing DP table
        for(int i=0; i< dp.length; i++)
        System.out.println(Arrays.toString(dp[i])); 

}
}
