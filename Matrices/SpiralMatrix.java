package Matrices;
import  java.util.* ; 

public class SpiralMatrix {

class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        List<Integer> ans = new ArrayList<>();
        int r = arr.length; 
        int c = arr[0].length; 
        int top = 0 , bottom = r-1 , left = 0 , right = c-1 ; 

        while(left <= right && top <= bottom){

            for(int i = left ; i <= right ; i++){
                ans.add(arr[top][i]);
            }
            top ++ ; 

            for(int i = top ; i<= bottom ; i++){
                ans.add(arr[i][right]); 
            }
            right -- ; 
            
            if(top <= bottom){
                for(int i = right ; i>=left ; i--){
                    ans.add(arr[bottom][i]); 
                }
                bottom -- ;
            }

            if(left <= right){
                for(int i = bottom  ; i>= top ; i--){
                    ans.add(arr[i][left]);
                } 
                left++; 
            }
        }
        return ans; 
    }
}
}


// leetcode 54 