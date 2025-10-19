import java.util.Arrays;

public class DP_MinFallingPathSumII {
    private int func(int i , int j , int grid[][] , int dp[][] , int n){
        if(i < 0 || j < 0 || i >= n || j >= n) return Integer.MAX_VALUE ;
        if(i == 0){
            dp[0][j] = grid[0][j]; 
            return dp[0][j] ; 
        }
        if(dp[i][j] != Integer.MIN_VALUE) return dp[i][j] ; 
        int res = Integer.MAX_VALUE; 

        for(int idx = 0 ; idx < n ; idx++){
            if(idx != j){
                res = Math.min(res , func(i - 1 , idx , grid , dp , n)); 
            }
        }
        return dp[i][j] = grid[i][j] + res; 
    }
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length ; 
        int dp[][] = new int[n][n]; 
        for(int row[] : dp){
            Arrays.fill(row , Integer.MIN_VALUE) ;
        }
        int res = Integer.MAX_VALUE; 
        for(int i = 0 ; i < n ; i++){
            res = Math.min(res , func(n-1 , i , grid , dp , n)); 
        }
        return res; 
    }
}
