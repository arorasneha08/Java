package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class T1_KDiffPairs {
    // all distinct pairs 
    public int findPairs(int[] arr, int k) {
        if(k == 0){
            HashMap<Integer , Integer> mpp = new HashMap<>(); 
            for(int num : arr){
                mpp.put(num , mpp.getOrDefault(num , 0)+ 1); 
            }
            int cnt = 0 ; 
            for(int key : mpp.keySet()){
                if(mpp.get(key) > 1) cnt ++; 
            }
            return cnt ; 
        }
        int count = 0 ; 
        HashSet<Integer> set = new HashSet<>(); 
        for(int num : arr){
            set.add(num); 
        }
        for(int num : set){
            if(set.contains(num + k)) count ++; 
        }
        return count; 
    }

    // n^2 complexity :- 
    public int findPairs2(int[] arr, int k) {
        int n = arr.length ; 
        int i = 0 ; 
        Arrays.sort(arr); 
        int cnt = 0 ; 
        while(i < n){
            while(i > 0 && i < n && arr[i] == arr[i-1]) {
                i++ ;
            }
            if(i >= n) break ; 
            int j = i + 1; 
            while(j < n && arr[j] - arr[i] <= k){
                while(j > i + 1 && j < n && arr[j] == arr[j-1]){
                    j++;  
                }
                if(j >= n){
                    break; 
                }
                if(arr[j] - arr[i] == k){
                    cnt ++; 
                }
                j++ ;
            }
            i ++ ; 
        }
        return cnt; 
    }
}
