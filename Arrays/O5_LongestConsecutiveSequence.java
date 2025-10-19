package Arrays;

import java.util.HashSet;

public class O5_LongestConsecutiveSequence {
    public int longestConsecutive(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int n = arr.length ; 
        for(int i = 0 ; i < n ; i++){
            set.add(arr[i]); 
        }
        int max = 0;
        for(int num : set){
            if(!set.contains(num-1)){
                int streak = 1 ; 
                int curr = num ; 
                while(set.contains(curr+1)){
                    curr ++; 
                    streak ++; 
                }
                max = Math.max(max , streak); 
            }
        }
        return max ; 
    }
}
