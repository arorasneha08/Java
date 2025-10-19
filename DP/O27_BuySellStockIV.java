package DP;

public class O27_BuySellStockIV {
    private int func(int i , int buy , int trans , int arr[] , int dp[][][]){
        if(i == arr.length) return 0 ; 
        if(trans == 0) return 0 ; 
        int profit = 0 ; 
        if(dp[i][buy][trans] != -1 ) return dp[i][buy][trans]; 

        if(buy == 1){
            int take = func(i+1 , 0 , trans , arr, dp) - arr[i]; 
            int nottake = func(i+1 , 1, trans , arr, dp); 
            profit = Math.max(take , nottake); 
        }
        else{
            int sell = func(i+1 , 1 , trans - 1 , arr, dp) + arr[i]; 
            int notsell = func(i+1 , 0, trans , arr, dp);
            profit = Math.max(sell , notsell);  
        }
        return dp[i][buy][trans] = profit; 
    }
    public int maxProfit(int k, int[] arr) {
        int n = arr.length ;
        // int dp[][][] = new int[n][2][k+1]; 
        // for(int layer[][] : dp){
        //     for(int row[] : layer){
        //         Arrays.fill(row , -1); 
        //     }
        // }
        // return func(0, 1 , k , arr, dp); 

        // int dp[][][] = new int[n+1][2][k+1]; 
        // for(int i = n-1 ; i>= 0; i--){
        //     for(int buy = 0 ; buy <= 1 ; buy ++){
        //         for(int trans = 1 ; trans <= k ; trans ++){
        //             int profit = 0 ; 
        //             if(buy == 1){
        //                 int take = -arr[i] + dp[i+1][0][trans]; 
        //                 int nottake = dp[i+1][1][trans]; 
        //                 profit = Math.max(take , nottake); 
        //             }
        //             else{
        //                 int sell = arr[i] + dp[i+1][1][trans-1]; 
        //                 int notsell = dp[i+1][0][trans]; 
        //                 profit = Math.max(sell , notsell); 
        //             }
        //             dp[i][buy][trans] = profit; 
        //         }
        //     }
        // }
        // return dp[0][1][k];

        int curr[][] = new int[2][k+1]; 
        for(int i = n-1 ; i>= 0; i--){
            for(int buy = 0 ; buy <= 1 ; buy ++){
                for(int trans = 1 ; trans <= k ; trans ++){
                    int profit = 0 ; 
                    if(buy == 1){
                        int take = -arr[i] + curr[0][trans]; 
                        int nottake = curr[1][trans]; 
                        profit = Math.max(take , nottake); 
                    }
                    else{
                        int sell = arr[i] + curr[1][trans-1]; 
                        int notsell = curr[0][trans]; 
                        profit = Math.max(sell , notsell); 
                    }
                    curr[buy][trans] = profit; 
                }
            }
        }
        return curr[1][k];
    }
}
