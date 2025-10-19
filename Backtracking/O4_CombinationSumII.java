package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O4_CombinationSumII {
    private void func(int index , int arr[] , int target , List<Integer> list , List<List<Integer>> res, int sum
    , int visited[]){
        if(sum == target){
            res.add(new ArrayList<>(list)); 
            return ; 
        }
        if(sum > target) return ; 
        if(index >= arr.length) return ; 

        for(int i = index ; i < arr.length ; i++){
            if(i > index && arr[i] == arr[i-1]) continue; 
            if(arr[i] > target) continue; 
            
            list.add(arr[i]); 
            sum += arr[i]; 
            func(i+1 , arr ,target , list , res, sum , visited); 
            list.remove(list.size()-1); 
            sum -= arr[i]; 
        }
    }
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        int n = arr.length; 
        List<List<Integer>> res = new ArrayList<>(); 
        List<Integer> list = new ArrayList<>(); 
        int visited[] = new int[n]; 
        Arrays.sort(arr); 
        func(0 , arr , target , list, res , 0 , visited) ; 
        return res ; 
    }
}
