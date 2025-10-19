package DP;

public class O46_MatrixChainMultiply {
    static int func(int i , int j , int arr[] , int dp[][]){
        if(i == j) return 0 ; 
        int min = Integer.MAX_VALUE; 
        if(dp[i][j] != -1) return dp[i][j]; 
        for(int k = i ; k < j ; k++){
            int steps = arr[i-1] * arr[k] * arr[j] + func(i, k, arr, dp) + func(k+1, j, arr, dp);
            min = Math.min(min , steps); 
        }
        return  dp[i][j] = min ; 
    }
    static int matrixMultiplication(int arr[]) {
        int n = arr.length ; 
        // int dp[][] = new int[n][n+1] ; 
        // for(int row[] : dp){
        //     Arrays.fill(row , -1); 
        // }
        
        // return func(1, n-1 , arr , dp);
        
        int dp[][] = new int[n][n] ; 
        // not necessary condition 
        // for(int i = 0 ; i <n ; i++){
        //     dp[i][i] = 0 ; 
        // }
        
        for(int i = n-1 ; i >= 1  ; i--){
            for(int j = i + 1 ; j < n ; j ++){
                int min = Integer.MAX_VALUE ; 
                for(int k = i ; k < j ; k++){
                    int steps = arr[i-1] * arr[k] * arr[j] + dp[i][k] + dp[k+1][j]; 
                    min = Math.min(min , steps); 
                }
                dp[i][j]= min ; 
            }
        }
        return dp[1][n-1]; 
    }
}
