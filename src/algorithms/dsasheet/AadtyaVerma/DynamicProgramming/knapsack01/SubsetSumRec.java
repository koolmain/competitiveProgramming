package algorithms.dsasheet.AadtyaVerma.DynamicProgramming.knapsack01;

public class SubsetSumRec{
    public static void main(String[] args){
        int[] arr = {2,5,7,8,10}; 
        int sum =11; 
        SubsetSumRec ss = new SubsetSumRec(); 
        System.out.println(ss.subsetSum(arr, sum, arr.length));
        
    }

    boolean subsetSum(int[] arr, int sum, int n){
        if(n ==0){
            return false; 
        }
        if(sum ==0){
            return true;
        }
        if(arr[n-1] <= sum){
            return  subsetSum(arr, sum - arr[n-1], n-1) || subsetSum(arr, sum, n-1);  
        }else{
            return subsetSum(arr, sum, n-1);
        }
    }
}