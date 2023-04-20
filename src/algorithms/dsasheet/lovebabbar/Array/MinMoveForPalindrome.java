package algorithms.dsasheet.lovebabbar.Array;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/minimum-number-of-moves-to-make-palindrome/solutions/1823173/java-c-2-pointers-step-by-step-dry-run-for-easy-explanation/
//https://leetcode.com/problems/minimum-number-of-moves-to-make-palindrome/solutions/1821936/list-vs-bit/
//https://www.youtube.com/watch?v=JQ1_7eEPloI
//https://www.youtube.com/watch?v=2Vcdjb-H8yA   -- Applying
public class MinMoveForPalindrome {

    public static void main(String[] args){
        MinMoveForPalindrome mp = new MinMoveForPalindrome(); 
        System.out.println(mp.minMovesToMakePalindrome("aabb"));
    }
    public int minMovesToMakePalindrome(String s) {
        char[] ch= s.toCharArray(); 
        List<Character> chList = new ArrayList<>(); 
        for(char c: ch)
            chList.add(c); 
        int res=0; 
        while(chList.size() > 0){
            int N =chList.size(); 
            int diff =1; // count whenther  one matching character is already removed or not. Will be used in removing the last one to avoid OUT OF BOUNDS
            int index = chList.indexOf(chList.get(N-1)); 
            if(index == N-1){
                res += N/2; 
            }
            else{
                res += index;
                chList.remove(index); 
                diff++; 
            } 
            chList.remove(N-diff); 
        }
        return res; 
        }
}