package DP;

public class O22_UnboundedKnapsack {
    static int func(int index,  int cap , int val[] , int wt[] , int dp[][]){
        if(index == 0){
            return (cap / wt[0]) * val[0] ; 
        }   
        if(dp[index][cap] != -1) return dp[index][cap]; 
        int notpick = func(index-1 , cap , val , wt, dp); 
        int pick = Integer.MIN_VALUE; 
        if(wt[index] <= cap){
            pick = val[index] + func(index , cap - wt[index] , val , wt, dp); 
        }
        return dp[index][cap] = Math.max(pick , notpick ); 
    }
    static int knapSack(int val[], int wt[], int capacity) {
        int n = wt.length ; 
        int dp[][] = new int[n][capacity+1] ; 
        // for(int row[] : dp){
        //     Arrays.fill(row , -1); 
        // }
        // return func(n-1 , capacity , val , wt , dp) ;
        
        
        // for(int i = 0 ; i <n ;i ++){
        //     dp[i][0] = 0 ; 
        // }
        // for(int i = wt[0] ; i <=capacity ; i ++){
        //     dp[0][i] = (i / wt[0]) * val[0]; 
        // }
        // for(int i = 1 ;  i<n ; i ++){
        //     for(int w = 0 ; w <= capacity ; w ++){
        //         int notpick = dp[i-1][w]; 
        //         int pick = Integer.MIN_VALUE ;
        //         if(wt[i] <= w){
        //             pick = dp[i][w-wt[i]] + val[i]; 
        //         }
        //         dp[i][w] = Math.max(pick , notpick); 
        //     }
        
        // }
        // return dp[n-1][capacity]; 
        
        
        int prev[] = new int[capacity+1]; 
        prev[0] = 0 ; 
        for(int i = wt[0] ; i <=capacity ; i ++){
            prev[i] = (i / wt[0]) * val[0]; 
        }
        for(int i = 1 ;  i<n ; i ++){
            int curr[] = new int[capacity+1]; 
            for(int w = 0 ; w <= capacity ; w ++){
                int notpick = prev[w]; 
                int pick = Integer.MIN_VALUE ;
                if(wt[i] <= w){
                    pick = curr[w-wt[i]] + val[i]; 
                }
                curr[w] = Math.max(pick , notpick); 
            }
            prev = curr; 
        
        }
        return prev[capacity]; 
    }
}
