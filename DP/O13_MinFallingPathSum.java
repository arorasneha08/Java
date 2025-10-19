package DP;

public class O13_MinFallingPathSum {
    private int func(int i , int j , int[][] grid , int[][] dp , int n){
        if(j < 0 || j >= n) return Integer.MAX_VALUE; 
        if(i == 0) return grid[i][j]; 
        if(dp[i][j] != -1) return dp[i][j]; 

        int a = func(i - 1, j, grid, dp, n);     // top
        int b = func(i - 1, j - 1, grid, dp, n); // top-left
        int c = func(i - 1, j + 1, grid, dp, n); // top-right

        return dp[i][j] = Math.min(a, Math.min(b, c)) + grid[i][j];
    }

    public int minFallingPathSum(int[][] grid) {
        int n = grid.length; 
        int[][] dp = new int[n][n]; 
        // for(int[] row : dp) {
        //     Arrays.fill(row, -1); 
        // }

        // int min = Integer.MAX_VALUE; 
        // for(int j = 0; j < n; j++) {
        //     min = Math.min(min, func(n - 1, j, grid, dp, n)); 
        // }
        // return min; 

        // for(int i = 0 ; i < n ; i ++){
        //     dp[0][i] = grid[0][i]; 
        // }
        // for(int i = 1 ; i < n ; i ++){
        //     for(int j = 0 ; j < n ; j ++){
        //         int a = Integer.MAX_VALUE , b = Integer.MAX_VALUE , c = Integer.MAX_VALUE ; 
        //         if(i > 0){
        //             a = dp[i-1][j]; 
        //         }
        //         if(i > 0 && j > 0){
        //             b = dp[i-1][j-1]; 
        //         }
        //         if(i > 0 && j < n-1){
        //             c = dp[i-1][j+1]; 
        //         }
        //         dp[i][j] = Math.min(a, Math.min(b, c)) + grid[i][j]; 
        //     }
        // }
        // int min = Integer.MAX_VALUE ;
        // for(int i = 0 ; i < n ; i ++){
        //     min = Math.min(min , dp[n-1][i]);
        // }
        // return min ; 

        int prev[] = new int[n]; 
        for(int i = 0 ; i < n ; i ++){
            prev[i] = grid[0][i]; 
        }
        for(int i = 1 ; i < n ; i ++){
            int curr[] = new int[n]; 
            for(int j = 0 ; j < n ; j ++){
                int a = Integer.MAX_VALUE , b = Integer.MAX_VALUE , c = Integer.MAX_VALUE ; 
                if(i > 0){
                    a = prev[j]; 
                }
                if(i > 0 && j > 0){
                    b = prev[j-1]; 
                }
                if(i > 0 && j < n-1){
                    c = prev[j+1]; 
                }
                curr[j] = Math.min(a, Math.min(b, c)) + grid[i][j]; 
            }
            prev = curr ;
        }
        int min = Integer.MAX_VALUE ;
        for(int i = 0 ; i < n ; i ++){
            min = Math.min(min , prev[i]);
        }
        return min ; 
    }
}

// leetcode 931 