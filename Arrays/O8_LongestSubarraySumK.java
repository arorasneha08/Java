package Arrays;

import java.util.HashMap;

public class O8_LongestSubarraySumK {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length ; 
        int max = 0 ;
        int sum =  0 ; 
        HashMap<Integer , Integer> mpp = new HashMap<>(); 
        for(int i = 0 ; i < n ; i ++){
            sum += arr[i] ;
            if(sum == k){
                max = Math.max(max , i+1); 
            }
            int rem = sum - k ; 
            if(mpp.containsKey(rem)){
                int len = i - mpp.get(rem);  
                max = Math.max(max , len); 
            }
            if(!mpp.containsKey(sum)){
                mpp.put(sum , i);     
            }
            
        }
        return max; 
    }
    public static int longestSubarrayWithSumK(int []arr, long target) {
        int n = arr.length; 
        int left = 0 , right = 0 ; 
        long sum = 0 ;
        int max = 0 ;
        while(right < n){
            sum += arr[right];
            while(sum > target){
                sum -= arr[left]; 
                left ++; 
            }
            if(sum == target){
                max = Math.max(max , right - left + 1); 
            }
            right ++; 
        }
        return max; 
    }
}
