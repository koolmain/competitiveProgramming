package algorithms.codestudio.dailychallenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args){
        List<Integer> arr = Arrays.asList(10,9,10); 
        ArrayList result = nextGreaterElement(new ArrayList<>(arr), arr.size()); 
        result.forEach(System.out::println);

    }


    public static ArrayList<Integer> nextGreaterElement(ArrayList<Integer> arr, int n)
    { 
        ArrayList<Integer> result = new ArrayList<>(); 
        Stack<Integer> stack = new Stack<>(); 
        if(arr.size() > 0){
        stack.push(arr.get(arr.size()-1)); 
        result.add(-1);
        int currentMax; 

       for(int i = arr.size()-2; i>=0; i--){
        while(arr.get(i) >= stack.peek()){
            stack.pop(); 
            if(stack.size() ==0 ){
                stack.push(-1); 
                break; 
            }

        }
        result.add(stack.peek()); 
        stack.push(arr.get(i)); 
       } 
    }

      Collections.reverse(result); 
      return result; 
    }
}
