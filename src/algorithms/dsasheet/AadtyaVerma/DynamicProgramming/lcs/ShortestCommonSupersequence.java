package algorithms.dsasheet.AadtyaVerma.DynamicProgramming.lcs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShortestCommonSupersequence {

    public static void main(String[] args){
        String a= "acbcf"; 
        String b= "abcdaf"; 
        ShortestCommonSupersequence scs = new ShortestCommonSupersequence(); 
        System.out.println("Shortest Supersequence is "+ scs.getScs(a, b, a.length(), b.length()));
    }


    String getScs(String a, String b, int n, int m){
        List<Character> lcsString = new ArrayList<>(); 
        int[][] dp = lcs(a,b,n,m); 
        int i=n, j=m; 
        while(i!=0 && j!=0){
            if(a.charAt(i-1) == b.charAt(j-1)){
                lcsString.add(a.charAt(i-1)); 
                i--; j--; 
            }
            else{
                if(dp[i-1][j] > dp[i][j-1]){
                    lcsString.add(a.charAt(i-1)); 
                    i--; 
                }
                else{ 
                    lcsString.add(b.charAt(j-1)); 
                    j--; 
                }
            }
        }
        Collections.reverse(lcsString);
        return lcsString.toString(); 
    }

    int[][] lcs(String a, String b, int n, int m){
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i <= n; i++){
            for(int j=0; j<= m; j++ ){
                if(i ==0 || j==0){
                    dp[i][j]= 0; 
                    continue; 
                }else{
                    if(a.charAt(i-1) == b.charAt(j-1))
                        dp[i][j] = 1 + dp[i-1][j-1]; 
                    else 
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp; 
    }
    
}
