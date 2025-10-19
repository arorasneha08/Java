package DP;

import java.util.Arrays;

public class O40_LIS {
    private int func(int index , int prev , int arr[] , int dp[][]){
        if(index == arr.length) return 0 ;  
        if(dp[index][prev+1] != -1 ) return dp[index][prev+1]; 

        int notpick = func(index + 1 , prev , arr, dp); 
        int pick = 0 ; 
        if(prev == -1 || arr[index] > arr[prev]){
            pick = 1 + func(index + 1 , index , arr, dp); 
        }
        return dp[index][prev+1] = Math.max(pick , notpick); 
    }
    public int lengthOfLIS(int[] arr) {
        int n = arr.length ; 
        // int dp[][] = new int[n][n+1]; 
        // for(int row[] : dp){
        //     Arrays.fill(row , -1); 
        // }
        // return func(0 , -1 , arr, dp) ; 
        
        // int dp[][] = new int[n+1][n+1]; 
        // for(int idx = n-1; idx >= 0 ; idx --){
        //     for(int prev = idx - 1 ; prev >= -1 ; prev --){
        //         int notpick = dp[idx + 1][prev + 1]; 
        //         int pick = 0 ; 
        //         if(prev == -1 || arr[idx] > arr[prev]){
        //             pick = 1 + dp[idx+1][idx+1]; 
        //         }
        //         dp[idx][prev+1] = Math.max(pick , notpick); 
        //     }
        // }
        // return dp[0][0]; 

        // int next[] = new int[n+1];
        // for(int index = n-1 ; index >= 0 ; index --){
        //     int curr[] = new int[n+1]; 
        //     for(int prevIdx = index-1 ; prevIdx >= -1 ; prevIdx --){
        //         int notpick = next[prevIdx+1]; 
        //         int pick = 0 ;
        //         if(prevIdx == -1 || arr[index] > arr[prevIdx]){
        //             pick = 1 + next[index+1]; 
        //         }
        //         int len = Math.max(pick , notpick);
        //         curr[prevIdx+1]= len ; 
        //     }
        //     next = curr; 
        // }
        // return next[0]; 
        

        // iterative approach :- 

        int dp[] = new int[n+1]; 
        Arrays.fill(dp , 1); 
        int max = Integer.MIN_VALUE; 
        for(int i = 0 ; i < n ; i ++){
            for(int prev = 0 ; prev < i ; prev++){
                if(arr[prev] < arr[i]){
                    dp[i] = Math.max(dp[i] , 1 + dp[prev]); 
                }
            }
            max = Math.max(max , dp[i]); 
        }
        return max ;
        
    }
}
