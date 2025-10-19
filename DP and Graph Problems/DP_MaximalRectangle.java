public class DP_MaximalRectangle {
    public int maximalSquare(char[][] mat) {
        int n = mat.length ; 
        int m = mat[0].length ; 
        int max = 0  ;
        int dp[][] = new int[n][m]; 
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(mat[i][j] == '1'){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;  
                    }
                    else{
                        dp[i][j] = 1 + Math.min(dp[i-1][j] , Math.min(dp[i-1][j-1] , dp[i][j-1])); 
                    }
                }
                max = Math.max(max , dp[i][j]); 
            }
        }
        return max * max ; 
    }
}
