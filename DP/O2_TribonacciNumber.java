package DP;

import java.util.Arrays;

public class O2_TribonacciNumber {
    private int func(int n , int dp[]){
        if(n == 0) return dp[0] = 0  ;
        if(n == 1) return dp[1] = 1 ; 
        if(n == 2) return dp[2] = 1 ; 
        if(dp[n] != -1) return dp[n]; 
        return dp[n] = func(n-1 , dp) + func(n-2 , dp) + func(n-3 , dp); 
    }
    public int tribonacci(int n) {
        int dp[] = new int[n+1]; 
        Arrays.fill(dp , -1); 
        func(n, dp); 
        if(n == 0) return 0  ;
        if(n == 1) return 1 ; 
        if(n == 2) return 1 ; 
        dp[0] = 0 ;
        dp[1] = 1; 
        dp[2] = 1; 
        for(int i = 3 ; i<=n ; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3]; 
        }
        // return dp[n] ;

        int p1 = 0 ; 
        int p2 = 1 ; 
        int p3 = 1; 
        if(n == 0) return 0  ;
        if(n == 1) return 1 ; 
        if(n == 2) return 1 ; 
        for(int i = 3 ; i <= n ; i++){
            int curr = p1 + p2 + p3; 
            p1 = p2 ; 
            p2 = p3; 
            p3 = curr; 
        }
        return p3 ; 
    }
}

// leetcode 1137 