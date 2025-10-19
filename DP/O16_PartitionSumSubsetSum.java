package DP;

public class O16_PartitionSumSubsetSum {
    public boolean canPartition(int[] arr) {
        int n = arr.length ; 
        int total = 0 ;
        for(int i = 0 ;  i < n ; i++){
            total += arr[i]; 
        }
        if(total % 2 != 0) return false; 
        int target = total / 2 ; 
        boolean dp[][] = new boolean[n][target + 1]; 

        for(int i = 0 ; i < n ; i++){
            dp[i][0] = true; 
        }
        if(arr[0] <= target) dp[0][arr[0]] = true; 

        for(int i = 1 ; i< n ; i ++){
            for(int t = 1 ; t <= target ; t ++){
                boolean notpick = dp[i-1][t]; 
                boolean pick = false;
                if(arr[i] <= t){
                    pick = dp[i-1][t - arr[i]]; 
                }
                dp[i][t] = pick || notpick ; 
            }
        }
        return dp[n-1][target]; 
    }
}

// leetcode 416 