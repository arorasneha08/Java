package DP;

public class O24_CoinChangeII {
    private int func(int index, int amt , int arr[] , int dp[][]){
        if(index < 0) return 0 ; 
        if(amt == 0) return 1; 
        if(dp[index][amt] != -1) return dp[index][amt]; 
        int notpick = func(index-1 , amt , arr, dp); 
        int pick = 0 ; 
        if(arr[index] <= amt){
            pick = func(index , amt-arr[index] , arr, dp); 
        }
        return dp[index][amt] = pick + notpick ; 
    }
    public int change(int amount, int[] arr) {
        int n = arr.length ; 
        int dp[][]= new int[n][amount+1]; 
        // for(int row[] : dp){
        //     Arrays.fill(row , -1); 
        // }
        // return func(n-1 , amount , arr, dp) ;

        // for(int i = 0 ; i < n ; i ++){
        //     dp[i][0] = 1;  
        // }
        // for(int i = 0 ; i<= amount ; i++){
        //     if(i % arr[0] == 0) dp[0][i] = 1; 
        // }
        // for(int i = 1 ; i < n ; i++){
        //     for(int a = 0 ; a <= amount; a++){
        //         int notpick = dp[i-1][a]; 
        //         int pick = 0 ;
        //         if(arr[i] <= a){
        //             pick = dp[i][a-arr[i]]; 
        //         }
        //         dp[i][a]= pick + notpick; 
        //     }
        // }
        // return dp[n-1][amount]; 

        int prev[] = new int[amount+1]; 
        prev[0] = 1; 
        for(int i = 0 ; i<= amount ; i++){
            if(i % arr[0] == 0) prev[i] = 1; 
        }
        for(int i = 1 ; i < n ; i++){
            int curr[] = new int[amount+1]; 
            for(int a = 0 ; a <= amount; a++){
                int notpick = prev[a]; 
                int pick = 0 ;
                if(arr[i] <= a){
                    pick = curr[a-arr[i]]; 
                }
                curr[a]= pick + notpick; 
            }
            prev = curr; 
        }
        return prev[amount]; 
    }
}
