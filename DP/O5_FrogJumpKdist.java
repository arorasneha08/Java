package DP;

import java.util.Arrays;

public class O5_FrogJumpKdist {
    private int func(int i , int arr[] , int k , int n , int dp[]){
        if(i == 0) return 0 ; 
        if(dp[i] != -1) return dp[i]; 
        int steps = Integer.MAX_VALUE ;
        for(int j = 1 ; i <= k ; i ++){
            if(i-j >= 0){
                int jump = func(i-j , arr, k, n, dp) + Math.abs(arr[i] - arr[i-j]); 
                steps = Math.min(steps , jump) ; 
            }
        }
        return dp[i] = steps; 
    }
    public int frogJump(int[] heights, int k) {
        int n = heights.length; 
        int dp[] = new int[n]; 
        Arrays.fill(dp , -1);
        return func(n-1 , heights , k , n, dp);  
    }
}

