package DP;

public class O11_MinimumPathSum {
    private int func(int i , int j , int grid[][] , int dp[][], int n , int m ){
        if(i == 0 && j == 0) return grid[i][j];
        if(i < 0 || j < 0 || i >= n || j >= m) return Integer.MAX_VALUE; 
        int min = Integer.MAX_VALUE ;
        
        if(dp[i][j] != -1) return dp[i][j] ; 

        int left = func(i-1 , j, grid , dp , n, m); 
        int up = func(i , j-1 , grid , dp, n , m);  
        return dp[i][j] = Math.min(left, up) + grid[i][j]; 
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length; 
        int dp[][] = new int[n][m]; 
        // for(int row[] : dp){
        //     Arrays.fill(row , -1); 
        // }
        // return func(n-1, m-1 , grid , dp , n, m); 

        // for(int i = 0 ; i < n ; i++){
        //     for(int j = 0 ; j < m ; j++){
        //         if(i == 0 && j == 0){
        //             dp[i][j] = grid[i][j] ;
        //         }
        //         else{
        //             int left = Integer.MAX_VALUE , up = Integer.MAX_VALUE  ; 
        //             if(i > 0){
        //                 left = dp[i-1][j]; 
        //             }
        //             if(j > 0){
        //                 up = dp[i][j-1];
        //             }
        //             dp[i][j] = Math.min(left , up) + grid[i][j] ; 
        //         }
        //     }
        // }
        // return dp[n-1][m-1]; 

        int prev[] = new int[m]; 
        for(int i = 0 ; i < n ; i++){
            int curr[] = new int[m] ; 
            for(int j = 0 ; j < m ; j++){
                if(i == 0 && j == 0){
                    curr[j] = grid[i][j] ;
                }
                else{
                    int left = Integer.MAX_VALUE , up = Integer.MAX_VALUE  ; 
                    if(i > 0){
                        left = prev[j]; 
                    }
                    if(j > 0){
                        up = curr[j-1];
                    }
                    curr[j] = Math.min(left , up) + grid[i][j] ; 
                }
            }
            prev = curr; 
        }
        return prev[m-1]; 
    }
}

// leetcode 64 