package algorithms.dsasheet.AadtyaVerma.DynamicProgramming.knapsack01;

public class Knapsack01DP {
 
    public static void main(String[] args){
        int[] wt= {4,5,1}; 
        int[] val={1,2,3};
        int W = 4; 
        System.out.println(knapSack(W, wt, val, 3));

    }

      //Function to return max val that can be put in knapsack of capacity W.
      static int knapSack(int W, int wt[], int val[], int n) 
      {
           int dp[][] = new int[n+1][W+1]; 
          
          for(int item =0 ; item <= n; item ++ ){
              for(int wgt=0; wgt<= W; wgt++){
                  if(item ==0 || wgt ==0 )
                      dp[item][wgt] =0;
                  else if(wt[item-1] <= wgt){
                      
                          dp[item][wgt] = Math.max(val[item-1] + dp[item-1][wgt - wt[item-1]], 
                              dp[item-1][wgt]); 
                      }else{
                          dp[item][wgt] = dp[item-1][wgt];
                      }
                  }
              }
           return dp[n][W];
      } 
  
}
