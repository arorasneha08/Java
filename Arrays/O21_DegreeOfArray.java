package Arrays;

import java.util.HashMap;

public class O21_DegreeOfArray {
    public int findShortestSubArray(int[] arr) {
        int n = arr.length ; 
        HashMap<Integer , Integer> freq = new HashMap<>();
        HashMap<Integer , Integer> first = new HashMap<>();
        HashMap<Integer , Integer> last = new HashMap<>();
        int degree = 0 ; 

        for(int i = 0 ; i < n ; i++){
            int num = arr[i]; 
            freq.put(num , freq.getOrDefault(num , 0) + 1); 
            degree = Math.max(degree , freq.get(num)); 
            if(!first.containsKey(num)){
                first.put(num , i); 
            }
            last.put(num , i); 
        }
        int min = n ; 
        for(int num : freq.keySet()){
            if(freq.get(num) == degree){
                int len = last.get(num) - first.get(num) + 1; 
                min = Math.min(min , len); 
            }
        }
        return min ; 
    }
}

// leetcode 697 