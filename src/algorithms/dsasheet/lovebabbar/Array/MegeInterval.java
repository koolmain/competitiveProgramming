package algorithms.dsasheet.lovebabbar.Array;

import java.util.Arrays;

//https://leetcode.com/problems/merge-intervals/
//https://github.com/Freeze777/SDE-Interviewer-Notes/blob/main/LeetCodeJava/src/main/java/leetcode/medium/sort/MergeIntervals.java
public class MegeInterval {

    public static void main(String[] args){
        // int[][] intervals = {{1,3},{2,6},{8,10},{15,18}}; 
        int[][] intervals = {{1,4},{4,6}}; 
        MegeInterval mi = new MegeInterval(); 
        mi.mergeIntervals(intervals);
        mi.printArrays(intervals); 
    }

    void mergeIntervals(int [][] intervals){
        for(int i=0; i< intervals.length-1; i++){
            if(intervals[i][1] >= intervals[i+1][0]){
                intervals[i][1] = intervals[i+1][1]; 
                intervals[i+1][0] = intervals[i][0];  
            }
        }
    }

    void printArrays(int[][] intervals){
        for(int i =0; i< intervals.length; i++)
            System.out.println(Arrays.toString(intervals[i]));
    }

    
}
