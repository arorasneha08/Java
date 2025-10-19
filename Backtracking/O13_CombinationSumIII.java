package Backtracking  ; 
import java.util.*;

public class O13_CombinationSumIII {
    private void func(int idx , int k , int n, List<Integer> list , List<List<Integer>> res , int sum){
        if(list.size() == k){
            if(sum == n){
                res.add(new ArrayList<>(list)); 
            }
            return ; 
        }
        for(int i = idx ; i <= 9 ; i++){
            if(sum + i > n) break ; 
            list.add(i);
            func(i + 1 , k, n, list , res , sum + i); 
            list.remove(list.size()-1); 
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>(); 
        List<Integer> list = new ArrayList<>(); 
        func(1 , k , n , list , res, 0); 
        return res; 
    }
}
