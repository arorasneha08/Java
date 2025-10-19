package DP;

import java.util.Arrays;

public class O19_TargetSum {
    private int func(int index , int target , int dp[][], int arr[]){
        if(index == 0){
            if(arr[0] == 0 && target == 0) return 2 ; 
            else if(arr[0] == target || target == 0) return 1; 
            return 0; 
        }
        if(arr[0] <= target) dp[0][arr[0]] = 1; 
        if(dp[index][target] != -1) return dp[index][target]; 
        int notpick = func(index - 1 , target , dp , arr); 
        int pick = 0 ;
        if(arr[index] <= target){
            pick = func(index -1 , target - arr[index] , dp , arr); 
        }
        return dp[index][target] = pick + notpick ; 
    }
    public int findTargetSumWays(int[] arr, int target) {
        int n = arr.length ; 
        int total = 0 ; 
        for(int i = 0 ; i< n ; i ++){
            total += arr[i] ; 
        }
        if((total - target < 0)|| ((total - target) % 2 != 0)) return 0 ; 
        int k = (total - target)/2; 
        int dp[][] = new int[n][k+1]; 
        for(int row[] : dp){
            Arrays.fill(row , -1) ;
        }
        return func(n-1 , k , dp , arr); 
    }
}

// leetcode 494 