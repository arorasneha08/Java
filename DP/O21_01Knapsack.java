package DP;

public class O21_01Knapsack {
    static int func(int index , int cap , int dp[][] , int wt[] , int val[]){
        if(index == 0){
            if(wt[0] <= cap) return val[0]; 
            else return 0 ; 
        }
        if(dp[index][cap] != -1) return dp[index][cap]; 
        int notpick = func(index - 1 , cap , dp , wt , val); 
        int pick = 0 ; 
        if(wt[index] <= cap){
            pick = val[index] + func(index-1 , cap - wt[index] , dp , wt , val); 
        }
        return dp[index][cap] = Math.max(pick , notpick );
    }
    static int knapsack(int W, int val[], int wt[]) {
        int n= wt.length ; 
        int dp[][] = new int[n][W+1]; 
        // for(int row[] : dp){
        //     Arrays.fill(row , -1); 
        // }
        // return func(n-1 , W , dp , wt , val); 
        
        // for(int i = 0 ; i < n ; i++){
        //     dp[i][0] = 0 ; 
        // }
        // for(int i = wt[0] ; i<= W; i ++){
        //     dp[0][i] = val[0]; 
        // }
        // for(int i = 1 ; i < n ; i++){
        //     for(int w = 0 ; w <= W ; w ++){
        //         int notpick = dp[i-1][w]; 
        //         int pick = Integer.MIN_VALUE ; 
        //         if(wt[i] <= w){
        //             pick = dp[i-1][w-wt[i]] + val[i]; 
        //         }
        //         dp[i][w] = Math.max(pick , notpick); 
        //     }   
        // }
        // return dp[n-1][W]; 
        
        int prev[] = new int[W+1]; 
        prev[0] = 0 ; 
        for(int i = wt[0] ; i<= W; i ++){
            prev[i] = val[0]; 
        }
        for(int i = 1 ; i < n ; i++){
            int curr[] = new int[W+1]; 
            for(int w = 0 ; w <= W ; w ++){
                int notpick = prev[w]; 
                int pick = Integer.MIN_VALUE ; 
                if(wt[i] <= w){
                    pick = prev[w-wt[i]] + val[i]; 
                }
                curr[w] = Math.max(pick , notpick); 
            }   
            prev = curr; 
        }
        return prev[W]; 
    }
}
