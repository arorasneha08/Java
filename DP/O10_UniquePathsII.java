package DP;

public class O10_UniquePathsII {
    private int func(int i , int j , int  n, int m , int dp[][] , int grid[][]){
        if(i == 0 && j == 0) return 1;  
        if(i <0 || j < 0 || j >= m || i >= n) return 0 ; 
        if(grid[0][0] == 1 || grid[i][j] == 1) return 0 ; 

        if(dp[i][j] != -1) return dp[i][j];

        int left = func(i , j-1 , n, m , dp , grid);
        int up = func(i-1 , j , n, m, dp , grid); 

        return dp[i][j] = left + up ; 

    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length; 
        int dp[][] = new int[n][m]; 
        // for(int row[] :  dp){
        //     Arrays.fill(row , -1); 
        // }
        if(grid[0][0] == 1) return 0 ; 
        // return func(n-1 , m-1 , n, m, dp , grid); 

        // for(int i = 0 ; i < n ; i ++){
        //     for(int j = 0 ; j< m ; j++){
        //         if(grid[i][j] == 1){
        //             dp[i][j] = 0 ; 
        //             continue ;
        //         }
        //         if(i == 0 && j == 0) {
        //             dp[i][j] = 1;  
        //         }
        //         else {
        //             int left = 0 , up = 0 ; 
        //             if(i > 0){
        //                 left = dp[i-1][j]; 
        //             }
        //             if(j > 0){
        //                 up = dp[i][j-1];  
        //             }
        //             dp[i][j] = left + up ; 
        //         }
        //     }
        // }
        // return dp[n-1][m-1];

        if (grid[0][0] == 1) return 0;
        int prev[] = new int[n]; 
        for(int i = 0 ; i < n ; i ++){
            int curr[] = new int[m] ;
            for(int j = 0 ; j< m ; j++){
                if(grid[i][j] == 1){
                    curr[j] = 0 ; 
                    continue ;
                }
                if(i == 0 && j == 0) {
                    curr[j] = 1;  
                }
                else {
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
        return prev[m-1];
    }
}

// leetcode 63 