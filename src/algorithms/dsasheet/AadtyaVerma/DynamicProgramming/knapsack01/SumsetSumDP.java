package algorithms.dsasheet.AadtyaVerma.DynamicProgramming.knapsack01;

public class SumsetSumDP {
    public static void main(String[] args){
        int arr[] = {2,5,7,8,10}; 
        int sum = 11; 
        SumsetSumDP ssDP = new SumsetSumDP(); 
        System.out.println(ssDP.subsetSum(arr, sum, arr.length));
    }
    
    boolean subsetSum(int[] arr, int sum, int n){
        boolean [][]dp = new boolean[arr.length+1][sum+1]; 

        for(int num = 0; num <= arr.length; num++){
            for(int sm =0; sm <= sum; sm++){
                if(num ==0){
                    dp[num][sm] = false;
                    continue; // continue to avoid -1 in line 23 as we have been using length +1. So in case we start from 1 
                }
                if(sum==0)
                    dp[num][sm] = true; 

                if(arr[num-1] < sm){
                    dp[num][sm] = dp[num-1][sm-arr[num-1]] || dp[num-1][sm]; 
                }else {
                    dp[num][sm] = dp[num-1][sum]; 
                }
            }
        }

        return dp[arr.length][sum]; 
    }
}
