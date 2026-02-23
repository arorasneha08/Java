package Arrays ; 

public class O18_MaxCircularSubarraySum {
    public int maxSubarraySumCircular(int[] arr) {
        int currMax = 0 , currMin = 0 ; 
        int maxSum = arr[0] , minSum = arr[0]; 
        int total = 0 ;
        for(int num : arr){
            currMax = Math.max(currMax + num , num); 
            maxSum = Math.max(currMax , maxSum); 
            currMin = Math.min(currMin + num , num); 
            minSum = Math.min(minSum , currMin); 
            total += num; 
        }
        if(maxSum > 0){ // in case of array wiht all negative numbers 
            return Math.max(maxSum, total - minSum);
        }
        return maxSum ; 
    }
}
