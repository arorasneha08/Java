package Backtracking; 
import java.util.*;

public class O2_Permutations {
    private void func(int index , List<Integer> list , List<List<Integer>> res , int arr[] , int visited[]){
        int n = arr.length; 
        if(list.size() == arr.length){
            res.add(new ArrayList<>(list)); 
            return ; 
        }
        for(int i = 0 ; i < n ; i++){
            if(i > 0 && arr[i] == arr[i-1] && visited[i-1] == 0) continue; 

            /**
             * arr = [1,1,2] 
             * visited = [0,0,0]
             * Without the condition, permutations like this appear:
                [1(0),1(1),2]
                [1(1),1(0),2]
                These are the same permutation but generated from different indices.We want only one.
             *  visited[i-1] == 0 means:the previous duplicate element has NOT been used in the current permutation path.
             */
            if(visited[i] == 1) continue; 
            list.add(arr[i]); 
            visited[i] = 1 ; 
            func(index + 1 , list , res ,arr , visited) ; 
            list.remove(list.size()-1);
            visited[i] = 0 ; 
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length ; 
        Arrays.sort(nums) ; 
        List<Integer> list = new ArrayList<>(); 
        int visited[] = new int[n]; 
        func(0 , list, res, nums , visited); 
        return res; 
    }
}

// permuations 2
