package DP;

import java.util.Arrays;

public class O4_FrogJump {
    int func(int i , int arr[] , int dp[], int n){
        if(i == 0) return 0 ; 
        if(dp[i] != -1) return dp[i]; 
        int first = func(i-1, arr, dp, n) + Math.abs(arr[i-1] - arr[i]); 
        int second = Integer.MAX_VALUE ; 
        if(i > 1){
            second = func(i-2, arr, dp, n) + Math.abs(arr[i-2] - arr[i]); 
        }
        return dp[i] = Math.min(first , second) ; 
    
    }
    int minCost(int[] height) {
        int n = height.length; 
        int dp[] = new int[n]; 
        Arrays.fill(dp, -1); 
        // return func(n-1 , height , dp, n); 
        dp[0] = 0 ;
        
        for(int i = 1 ; i < n ; i++){
            int first = dp[i-1] + Math.abs(height[i-1] - height[i]);
            int sec = Integer.MAX_VALUE ;
            if(i > 1){
                sec = dp[i-2] + Math.abs(height[i-2] - height[i]); 
            }
            dp[i] = Math.min(first , sec); 
        }
        return dp[n-1]; 
    }
}
