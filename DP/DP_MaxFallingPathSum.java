public class DP_MaxFallingPathSum {
    private int func(int i , int j , int mat[][] , int dp[][] , int n , int m){
        if(i < 0 || j < 0 || i >= n || j >= m ) return Integer.MIN_VALUE; 
        if(i == 0 ) {
            dp[0][j] = mat[0][j]; 
        }
        
        if(dp[i][j] != -1) return dp[i][j] ; 
        
        int left = func(i-1 , j-1 , mat , dp , n, m); 
        int right = func(i-1 , j + 1 , mat , dp , n, m);
        int diag = func(i-1 , j , mat , dp , n , m);
        
        int max = Math.max(diag , Math.max(left , right)) + mat[i][j]; 
        return dp[i][j] = max ;
    }
    public int maximumPath(int[][] mat) {
        int n = mat.length  ;
        int m = mat[0].length ; 
        int dp[][] = new int[n][m]; 
        // for(int row[] : dp){
        //     Arrays.fill(row , -1); 
        // }
        // int max = Integer.MIN_VALUE; 
        // for(int j = 0 ; j < m ; j++){
        //     max = Math.max(max , func(n-1 , j , mat , dp , n , m)); 
        // }
        // return max; 
        
        // for(int j = 0 ; j < m ; j++){
        //     dp[0][j] = mat[0][j] ; 
        // }
        // for(int i = 1 ; i < n ; i++){
        //     for(int j = 0 ; j < m ; j++){
        //         int left = Integer.MIN_VALUE;
        //         int right = Integer.MIN_VALUE ;
        //         int diag = Integer.MIN_VALUE; 
        //         if(i > 0 && j > 0){
        //             left = dp[i-1][j-1]; 
        //         }
        //         if(i > 0 && j < m-1){
        //             right = dp[i-1][j+1]; 
        //         }
        //         if(i > 0){
        //             diag = dp[i-1][j]; 
        //         }
        //         int max = Math.max(left , Math.max(right , diag)) + mat[i][j]; 
        //         dp[i][j] = max  ; 
        //     }
        // }
        // int res = 0 ; 
        // for(int j = 0 ; j < m ; j++){
        //     res = Math.max(res , dp[n-1][j]); 
        // }
        // return res; 
        
        int prev[] = new int[m]; 
        for(int j = 0 ; j < m ; j++){
            prev[j] = mat[0][j] ; 
        }
        for(int i = 1 ; i < n ; i++){
            int curr[] = new int[m]; 
            for(int j = 0 ; j < m ; j++){
                int left = Integer.MIN_VALUE;
                int right = Integer.MIN_VALUE ;
                int diag = Integer.MIN_VALUE; 
                if(i > 0 && j > 0){
                    left = prev[j-1]; 
                }
                if(i > 0 && j < m-1){
                    right = prev[j+1]; 
                }
                if(i > 0){
                    diag = prev[j]; 
                }
                int max = Math.max(left , Math.max(right , diag)) + mat[i][j]; 
                curr[j] = max  ; 
            }
            prev = curr; 
        }
        int res = 0 ; 
        for(int j = 0 ; j < m ; j++){
            res = Math.max(res , prev[j]); 
        }
        return res; 
    }
}
