package DP;

import java.util.Arrays;

class O1_FibonacciNumber {
    private int func(int n , int dp[]){
        if(n == 0) return dp[0] = 0 ; 
        if(n == 1) return dp[1] = 1 ; 
        if(dp[n] != -1) return dp[n]; 
        return dp[n] = func(n-1 , dp) + func(n-2 , dp); 
    }
    public int fib(int n) {
        // memoisation 
        int dp[] = new int[n+1];
        Arrays.fill(dp , -1); 
        func(n , dp); 
        // return dp[n] ; 

        // tabulation 

        if(n == 0) return 0 ; 
        if(n == 1) return 1; 
        dp[0] = 0 ; 
        dp[1] = 1;  
        for(int i = 2 ; i <= n ; i ++){
            dp[i] = dp[i-1] + dp[i-2] ;
        }
        // return dp[n]; 

        int prev1 = 0 ; 
        int prev2 = 1 ; 
        if(n == 0) return 0 ; 
        if(n == 1) return 1; 
        for(int i = 2 ; i<= n ; i ++){
            int curr = prev1 + prev2 ; 
            prev1 = prev2; 
            prev2 = curr; 
        }
        return prev2 ; 
    }   
}

// leetcode 