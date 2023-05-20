package algorithms.dsasheet.AadtyaVerma.DynamicProgramming.lcs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//https://www.youtube.com/watch?v=x5hQvnUcjiM&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=23
public class PrintLCS {

    public static void main(String[] args){
        String a = "acbcf"; 
        String b = "abcdaf"; 
        PrintLCS printLCS = new PrintLCS(); 
        System.out.println(printLCS.getLCS(a, b, a.length(), b.length()));
    }

    String getLCS(String a, String b, int n, int m){
        int[][] dp = lcs(a, b, n, m); 
        List<Character> lcsList = new ArrayList<>(); 
        int i =n, j=m; 
        while(i!=0 && j!=0){
            if(a.charAt(i-1) == b.charAt(j-1)){
                lcsList.add(a.charAt(i-1));
                i--; j--; 
            }
            else{
                if(dp[i][j-1] > dp[i-1][j])
                    j--; 
                else 
                    i--; 
            } 
        }
        Collections.reverse(lcsList); 
        return lcsList.toString(); 
    }

    int[][] lcs(String a,String b , int n, int m){
        List<Character> lcsString = new ArrayList<>(); 
        int dp[][] = new int[n+1][ m+1]; 
        for(int i=0; i <= n; i++){
            for(int j=0; j<=m; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0; 
                    continue; 
                }

                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1]; 
                    lcsString.add(a.charAt(i-1)); 
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); 
                }
            }
        }
        return dp; 
    }
    
}
