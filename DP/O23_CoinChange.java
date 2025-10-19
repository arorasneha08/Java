package DP;

import java.util.Arrays;

public class O23_CoinChange {
    private int func(int index, int amt , int arr[] , int dp[][]){
        if(index == 0){
            if(amt % arr[0] == 0) return amt/arr[0]; 
            return (int) 1e9 ; 
        }
        if(amt == 0) return 0; 
        if(dp[index][amt] != -1) return dp[index][amt]; 
        int notpick = func(index-1 , amt , arr, dp); 
        int pick = (int) 1e9 ; 
        if(arr[index] <= amt){
            pick = 1 + func(index , amt-arr[index] , arr, dp); 
        }
        return dp[index][amt] = Math.min(pick , notpick) ; 
    }
    public int coinChange(int[] arr, int amount) {
        int n = arr.length ; 
        int dp[][]= new int[n][amount+1]; 
        for(int row[] : dp){
            Arrays.fill(row , -1); 
        }
        // int res =  func(n-1 , amount , arr , dp);
        // if(res == (int) 1e9) return -1; 
        // return res;  
        
        // for(int i = 0 ; i < n ; i++){
        //     dp[i][0] = 0 ; 
        // }
        // for(int i = 0 ; i <= amount ; i++){
        //     if(i % arr[0] == 0){
        //         dp[0][i] = i / arr[0]; 
        //     }
        //     else{
        //         dp[0][i] = (int) 1e9 ; 
        //     }
        // }
        // for(int i = 1 ; i< n ; i ++){
        //     for(int a = 0 ; a <= amount ; a++){
        //         int notpick = dp[i-1][a]; 
        //         int pick = (int) 1e9 ; 
        //         if(arr[i] <= a){
        //             pick = 1 + dp[i][a-arr[i]];
        //         }
        //         dp[i][a] = Math.min(pick , notpick); 
        //     }
        // }
        // int res =  dp[n-1][amount]; 
        // if(res == (int) 1e9) return -1; 
        // return res; 

        int prev[] = new int[amount+1]; 
        prev[0] = 0 ; 
        for(int i = 0 ; i <= amount ; i++){
            if(i % arr[0] == 0){
                prev[i] = i / arr[0]; 
            }
            else{
                prev[i] = (int) 1e9 ; 
            }
        }
        for(int i = 1 ; i< n ; i ++){
            int curr[] = new int[amount+1]; 
            for(int a = 0 ; a <= amount ; a++){
                int notpick = prev[a]; 
                int pick = (int) 1e9 ; 
                if(arr[i] <= a){
                    pick = 1 + curr[a-arr[i]];
                }
                curr[a] = Math.min(pick , notpick); 
            }
            prev = curr; 
        }
        int res =  prev[amount]; 
        if(res == (int) 1e9) return -1; 
        return res; 
    }
}
