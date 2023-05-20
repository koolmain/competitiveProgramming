package algorithms.dsasheet.AadtyaVerma.DynamicProgramming.lcs;

import java.util.Arrays;

//https://www.youtube.com/watch?v=4Urd0a0BNng
//LCS 
public class LongestCommonSubsequence {
    
        public static void main(String[] args){
            String a = "abcdgh";
            String b= "abedfha"; 

            LongestCommonSubsequence lcs1 = new LongestCommonSubsequence(); 
            System.out.println("Total common subsequence between a and b is "+ lcs1.lcs(a, b, a.length(), b.length()));
        }

        int lcs(String a, String b, int n, int m){
            int dp[][] = new int[n+1][m+1]; 

            for(int i=0; i <= n; i++){
                for(int j=0; j <= m; j++){
                    if(i==0 || j==0){
                        dp[i][j] =0;
                        continue;
                    }
                    if(a.charAt(i-1) == b.charAt(j-1)){
                        dp[i][j] = 1 + dp[i-1][j-1]; 
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);  
                    }
                }
            }
            print2d(dp);
            return dp[n][m]; 
        }

        void print2d(int[][] dp){
            //printing DP table
            for(int i=0; i< dp.length; i++)
            System.out.println(Arrays.toString(dp[i])); 
        }
}
