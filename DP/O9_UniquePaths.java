package DP;

public class O9_UniquePaths {
    private int func(int i , int j , int m , int n , int dp[][]){
        if(i == 0 && j == 0) return 1 ; 
        if(i < 0 || i >= m || j < 0 || j > n) return 0 ; 
        if(dp[i][j] != -1) return dp[i][j]; 
        int left = 0 , up = 0; 
        if(j > 0){
            left = func(i , j-1 , m, n , dp); 
        }
        if(i > 0){
            up = func(i-1 , j , m, n, dp); 
        }
        return dp[i][j] = left + up ; 
    }
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n]; 
        // for(int row[] :  dp){
        //     Arrays.fill(row , -1); 
        // }
        // return func(m-1 , n-1 , m, n, dp); 
        
        // for(int i = 0 ;  i< m ; i ++){
        //     dp[i][0] = 1;  
        // }
        // for(int i = 0 ; i< n ; i ++){
        //     dp[0][i] = 1; 
        // }
        // for(int i = 1 ;  i < m ; i++){
        //     for(int j = 1 ; j < n ; j ++){
        //         dp[i][j] = dp[i-1][j] + dp[i][j-1]; 
        //     }
        // }
        // return dp[m-1][n-1]; 

        int prev[] = new int[n]; 
        for(int i = 0 ;  i< m ; i ++){
            int curr[] = new int[n]; 
            for(int j = 0 ; j < n ; j ++){
                if(i == 0 && j == 0){
                    curr[j] = 1;  
                }
                else{
                    int left = 0 , up = 0 ; 
                    if(i > 0){
                        left = prev[j]; 
                    }
                    if(j > 0){
                        up = curr[j-1]; 
                    }
                    curr[j] = left + up ; 
                }
            }
            prev = curr; 
        }
        return prev[n-1]; 
    }
}
