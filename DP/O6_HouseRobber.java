package DP;

import java.util.Arrays;

public class O6_HouseRobber {
    private int func(int i , int dp[] , int arr[]){
        if(i == 0) return arr[0] ;
        if(i == 1) return Math.max(arr[0] , arr[1]); 
        if(dp[i] != -1) return dp[i] ;

        int notpick = func(i-1 , dp , arr); 
        int pick = 0 ; 
        if(i > 1){
            pick = func(i-2 , dp , arr) + arr[i]; 
        }
        dp[i] = Math.max(pick , notpick); 
        return dp[i]; 
    }
    public int rob(int[] arr) {
        int n = arr.length ; 
        int dp[] = new int[n]; 
        Arrays.fill(dp , -1); 
        // return func(n-1 , dp , arr); 

        dp[0] = arr[0] ; 
        if(n > 1){
            dp[1] = Math.max(arr[0] , arr[1]); 
        }
        for(int i = 2 ; i < n ; i++){
            int notpick = dp[i-1] ; 
            int pick = dp[i-2] + arr[i]; 
            int max = Math.max(pick , notpick); 
            dp[i] = max; 
        }
        return dp[n-1]; 
        
        // space optimised 
        // if(n == 0) return 0 ; 
        // if(n == 1) return arr[0]; 
        // int prev1 = arr[0] ;
        // int prev2 = Math.max(arr[0] , arr[1]); 
        // int max = prev2 ;
        // for(int i = 2 ; i < n ; i++){
        //     int notpick = prev2 ; 
        //     int pick = 0 ;
        //     if(i > 1){
        //         pick = arr[i] + prev1 ; 
        //     } 
        //     max = Math.max(pick , notpick); 
        //     prev1 = prev2 ; 
        //     prev2 = max; 
        // }
        // return max ; 
    }
}
