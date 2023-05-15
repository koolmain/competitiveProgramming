package algorithms.dsasheet.AadtyaVerma.DynamicProgramming.knapsack01;

//https://www.youtube.com/watch?v=Hw6Ygp3JBYw&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=12
// This problem reduce to Subset problem. By distributing signs (+,-) among elements, it is actually distribution one set into 2 subset S1 and S2 such that 
// S1 + (- S2 ) = S1 - S2 = givenSum. We have to count how many ways this distribution possible. Basically it reduce to how many subset exist whose
// sum is equal to S1. 
public class TargetSum{
    public static void main(String[] args){
        int[] arr = {1,1,2,3}; 
        int sum =1; 
        TargetSum ts = new TargetSum(); 
        System.out.println("Total ways to assign signs are "+ ts.targetSum(arr, sum, arr.length));
    }

    int targetSum(int[] arr, int sum , int n ){
        int dp[][] = new int[n+1][sum+1]; 
        for(int i=0;i<= n; i++ )
        {
            for(int j=0; j<= sum; j++){
                if(i==0){
                    if(j==0){
                        dp[i][j] = 1; 
                        continue; 
                    }
                    dp[i][j] = 0; 
                    continue;
                }

                if(j==0){
                    dp[i][j] = 1;
                    continue;
                }

                if(arr[i-1] <=  j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j]; 
                } else {
                    dp[i][j] = dp[i-1][j]; 
                }


            }
        }


        return  dp[n][sum]; 
    }


}