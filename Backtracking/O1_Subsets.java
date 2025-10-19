package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class O1_Subsets {
    private void func(int index , List<Integer> list, List<List<Integer>> res , int arr[]){
        res.add(new ArrayList<>(list)); 

        for(int i = index ; i< arr.length ; i ++){
            list.add(arr[i]);
            func(i+1 , list , res , arr);  
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); 
        func(0, new ArrayList<>() , res, nums); 
        return res; 
    }
}

// leetcode 78 