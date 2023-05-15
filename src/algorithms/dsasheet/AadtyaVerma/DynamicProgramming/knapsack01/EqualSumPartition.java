package algorithms.dsasheet.AadtyaVerma.DynamicProgramming.knapsack01;

import java.util.Arrays;

public class EqualSumPartition {
    public static void main(String[] args){
        int arr[] = {1,5,11,5}; 
        EqualSumPartition ep = new EqualSumPartition(); 
        System.out.println("Equal paritition possibility is "+ ep.equalSumPatition(arr));
    }

    boolean equalSumPatition(int arr[]){
        int sum =0; 
        for(int i =0; i< arr.length; i++){
            sum += arr[i]; 
        }
        if(sum % 2 !=0) 
            return false; 

        int needSubsetSum = sum/2; 


        boolean dp[][] = new boolean[arr.length+1][needSubsetSum+1];

        for(int num=0; num <= arr.length; num++){
            for(int sm =0; sm <= needSubsetSum; sm++){
                if(num == 0 ){
                    if(sm == 0) {
                        dp[num][sm] = true; 
                        continue;
                    }
                    dp[num][sm] = false;
                    continue; 
                }

                if(sm ==0)
                    dp[num][sm] = true; 

                if(arr[num-1] <= sm){
                    dp[num][sm] = dp[num-1][sm-arr[num-1]] || dp[num-1][sm]; 
                }else 
                    dp[num][sm] = dp[num-1][sm]; 
            }
        }
        for(int i=0; i< dp.length; i++)
            System.out.println(Arrays.toString(dp[i])); 
        return dp[arr.length][needSubsetSum]; 
    }
    
}
