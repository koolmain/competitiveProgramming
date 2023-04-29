package algorithms.dsasheet.lovebabbar.Array;

public class Kadane {

    public static void main(String[] args){
        
    }

    long maxSubarraySum(int arr[], int n){
        
        int currentSum = arr[0], globalSum = arr[0];
        for(int i=1; i< arr.length; i++ ){
            currentSum = Math.max(currentSum+arr[i], arr[i]); 
            if(currentSum > globalSum){
                globalSum = currentSum; 
            }
        }
        
        return globalSum; 
        
    }
    
}
