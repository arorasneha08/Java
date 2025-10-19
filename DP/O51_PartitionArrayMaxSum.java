package DP;

import java.util.Arrays;

public class O51_PartitionArrayMaxSum {
    private int func(int i , int arr[] , int n , int k , int dp[]){
        if(i == n) return 0 ; 
        int res = Integer.MIN_VALUE; 
        int max = Integer.MIN_VALUE ; 
        int len = 0 ; 
        if(dp[i] != -1) return dp[i]; 

        for(int j = i ; j < Math.min(i+k , n) ; j++){
            len ++; 
            max = Math.max(max , arr[j]) ;
            int sum = (len * max) + func(j+1 , arr, n, k, dp); 
            res = Math.max(res , sum) ;  
        }
        return dp[i] = res ; 
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length ; 
        int dp[] = new int[n]; 
        Arrays.fill(dp , -1); 
        return func(0 , arr, n,k, dp); 
    }
}
