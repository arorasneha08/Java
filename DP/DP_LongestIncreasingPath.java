public class DP_LongestIncreasingPath {
    private int func(int r , int c , int mat[][], int dp[][]){
        int n = mat.length ;
        int m = mat[0].length ;
        int delRow[] = {-1 , 0 , 1 , 0};
        int delCol[] = {0 , -1 , 0 , 1}; 

        if(r < 0 || c < 0 || r >= n || c >= m) return 0 ; 
        if(dp[r][c] != -1) return dp[r][c]; 
        int max = 1 ;

        for(int i = 0 ; i < 4 ; i++){
            int row = delRow[i] + r ;
            int col = delCol[i] + c; 
            if(row >= 0 && row < n && col >= 0 && col < m && mat[r][c] < mat[row][col]){
                int len = 1 + func(row , col , mat ,dp); 
                max = Math.max(max , len); 
            }
        }
        return dp[r][c] = max ; 
    }
    public int longestIncreasingPath(int[][] mat) {
        int n = mat.length ;
        int m = mat[0].length ;
        int dp[][] = new int[n][m]; 
        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j <m ; j++){
                dp[i][j] = -1; 
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                int len = func(i , j , mat , dp);
                max = Math.max(max , len);
            }
        }
        return max ; 
    }
}
