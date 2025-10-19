package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O3_SubsetsII {
    private void func(int index , int arr[] , int n , List<Integer> list ,List<List<Integer>> res){
        res.add(new ArrayList<>(list)); 

        for(int i = index ; i < n ; i++){
            if(i > index && arr[i] == arr[i-1]) continue; 
            list.add(arr[i]); 
            func(i + 1 , arr , n , list , res); 
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); 
        int n = nums.length ; 
        Arrays.sort(nums); 
        func(0 , nums , n, new ArrayList<>() , res); 
        return res; 
    }
}
