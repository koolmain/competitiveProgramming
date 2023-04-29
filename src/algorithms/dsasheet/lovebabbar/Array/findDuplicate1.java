package algorithms.dsasheet.lovebabbar.Array;

//https://www.youtube.com/watch?v=K5lFvnNChaY
// Using Floyd cycle detection algorithm
public class findDuplicate1 {

    public static void main(String[] args){
        findDuplicate1 dup1 = new findDuplicate1(); 
        // int[] nums= {1,3,4,2,2}; 
        int[] nums= {3,1,3,4,2}; 
        System.out.println(dup1.findDuplicate(nums)); 
    }

    //using floyd cycle detections 
    //why it works https://www.youtube.com/watch?v=Cs3KwAsqqn4
    public int findDuplicate(int[] nums) {
        int hare=nums[0] ,turtle = nums[0]; 
        do{
            hare = nums[nums[hare]]; 
            turtle = nums[turtle]; 
        }while(turtle != hare); 

        turtle = nums[0]; 
        while(turtle != hare){
            hare = nums[hare]; 
            turtle = nums[turtle]; 
        }

        return hare; 
    }
}
