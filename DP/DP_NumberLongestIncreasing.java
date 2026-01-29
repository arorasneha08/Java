import java.util.Arrays;

public class DP_NumberLongestIncreasing {
    int mod = (int) 1e9 + 7 ; 
    private int func(int r , int c , int mat[][] , int dp[][], int n , int m){
        if(r < 0 || c < 0 || r >= n || c >= m) return 0; 
        if(dp[r][c] != -1) return dp[r][c]; 

        int delRow[] = {-1 , 0 , 1, 0};
        int delCol[] = {0 , -1 , 0 , 1}; 

        int count = 1 ; 
        for(int i = 0 ; i < 4 ; i ++){
            int row = delRow[i] + r;
            int col = delCol[i] + c;
            if(row >= 0 && row < n && col >= 0 && col < m && mat[r][c] < mat[row][col]){
                count += func(row , col , mat , dp , n , m); 
                count %= mod; 
            } 
        }
        return dp[r][c] = (int) count ; 
    }
    public int countPaths(int[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length ; 
        int dp[][] = new int[n][m]; 
        for(int row[] : dp){
            Arrays.fill(row , -1); 
        }
        long count = 0 ; 
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m ; j++){
                count += func(i , j , grid , dp, n , m); 
                count %= mod ; 
            }
        }
        return (int) count ;
    }
}
