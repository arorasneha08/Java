public class MinimumSubarraySum {
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int n = nums.length ; 
            int left = 0 ;
            int sum = 0 ; 
            int right = 0 ; 
            int min = Integer.MAX_VALUE ; 
    
            while(right < n){
                sum += nums[right];
                 
                while(sum >= target){
                    min = Math.min(min , right - left + 1); 
                    sum -= nums[left]; 
                    left ++ ; 
                }
                right ++ ; 
            }
            
            if(min == Integer.MAX_VALUE){
                return 0 ; 
            }
            return min; 
        }
    }
}

// leetcode 209 