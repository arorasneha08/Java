public class PeakElemArr {
    class Solution {
        public int findPeakElement(int[] nums) {
            int n = nums.length ;
            int start = 1 ;
            int end = n-2 ;
            if(n == 0 || n == 1) return 0 ; 
    
            if(nums[0] > nums[1]) return 0 ; 
            if(nums[n-1] > nums[n-2]) return n-1 ; 
    
            while(start <= end){
                int mid = start + (end - start)/2; 
                if((nums[mid] > nums[mid+1]) && (nums[mid] > nums[mid-1])){
                    return mid ; 
                }
                else if(nums[mid] < nums[mid+1]){
                    start = mid + 1 ; 
                }
                else{
                    end = mid - 1 ; 
                }
            }
            return -1 ; 
        }
    }
}

// leetcode 162 