package algorithms.dsasheet.AadtyaVerma.DynamicProgramming.knapsack01;

public class Knapsack01Rec{
    public static void main(String[] args){
        int[] weight = {4,5,1}; 
        int[] value = {1,2,3}; 
        int W =4; 
        // int[] weight = {1,3,4,5}; 
        // int[] value = {1,4,5,7}; 
        // int W =7; 
        Knapsack01Rec knapsack01 = new Knapsack01Rec(); 
        System.out.println(knapsack01.knapsack01(weight,value, W, W, weight.length));
        
    }

    int knapsack01(int[] weight, int[] value, int remainingWeight, int totalWeight,int size){
        int i = size -1; 
        if(size == 0 || remainingWeight == 0)
            return 0; 

        if(weight[i] <= remainingWeight ){
            int selectedVal =  Math.max(value[i] + knapsack01(weight, value, remainingWeight - weight[i], totalWeight, size-1), 
                            knapsack01(weight, value, remainingWeight, totalWeight, size-1)); 
            return selectedVal; 
        }else{
            int selectedVal = knapsack01(weight, value, remainingWeight, totalWeight, size-1);
            return selectedVal;  
        }
    }
}