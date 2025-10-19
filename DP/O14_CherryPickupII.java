package DP;

public class O14_CherryPickupII {
    private int func(int i , int j1 , int j2 , int grid[][] , int dp[][][]){
        int n = grid.length ; 
        int m = grid[0].length ; 
        if(i < 0 || i>= n || j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) return Integer.MIN_VALUE ;
        if(i == n-1){
            if(j1 == j2){
                return grid[i][j1]; 
            }
            else{
                return grid[i][j1] + grid[i][j2]; 
            }
        }
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2]; 
        int max = Integer.MIN_VALUE ;
        for(int rob1 = -1 ; rob1 <=1  ; rob1 ++){
            for(int rob2 = -1 ; rob2 <= 1 ; rob2 ++){
                int val = 0 ;  
                if(j1 == j2){
                    val = grid[i][j1]; 
                }   
                else {
                    val = grid[i][j1] + grid[i][j2]; 
                }
                val += func(i+1 , j1 + rob1 , j2 + rob2 , grid, dp); 
                max = Math.max(max , val); 
                dp[i][j1][j2] = max; 
            }
        }
        return max; 

    }
    public int cherryPickup(int[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length ; 
        int dp[][][] = new int[n][m][m]; 
        // for(int layer[][] : dp){
        //     for(int row[] : layer){
        //         Arrays.fill(row , -1); 
        //     }
        // }
        // return func(0 , 0 , m-1 , grid , dp); 

        // for(int j1 = 0 ; j1 < m ; j1 ++){
        //     for(int j2 = 0 ; j2 < m ; j2 ++){
        //         if(j1 == j2){
        //             dp[n-1][j1][j2] = grid[n-1][j1]; 
        //         }
        //         else{
        //             dp[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2];  
        //         }
        //     }
        // }
        // for(int i = n-2 ; i>= 0; i --){
        //     for(int j1 = 0 ; j1 < m ; j1 ++){
        //         for(int j2 = 0 ; j2 < m ; j2 ++){
        //             int max = Integer.MIN_VALUE;
        //             for(int rob1 = -1 ; rob1 <= 1 ; rob1 ++){
        //                 for(int rob2 = -1 ; rob2 <= 1 ; rob2 ++){
        //                     int val = 0 ;
        //                     if(j1 == j2){
        //                         val = grid[i][j1]; 
        //                     }
        //                     else{
        //                         val = grid[i][j1] + grid[i][j2]; 
        //                     }
        //                     if(j1 + rob1 >= 0 && j1 + rob1 < m && j2 + rob2 >= 0 && j2 + rob2 < m){
        //                         val += dp[i+1][j1+rob1][j2+rob2]; 
        //                     }
        //                     max = Math.max(max , val); 
        //                 }
        //             }
        //             dp[i][j1][j2] = max; 
        //         }
        //     }
        // }
        // return dp[0][0][m-1]; 

        int[][] prev = new int[m][m]; 
        int[][] curr = new int[m][m];

        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    prev[j1][j2] = grid[n - 1][j1];
                else
                    prev[j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int max = Integer.MIN_VALUE;

                    for (int d1 = -1; d1 <= 1; d1++) {
                        for (int d2 = -1; d2 <= 1; d2++) {
                            int nj1 = j1 + d1;
                            int nj2 = j2 + d2;

                            if (nj1 >= 0 && nj1 < m && nj2 >= 0 && nj2 < m) {
                                int val = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
                                val += prev[nj1][nj2];
                                max = Math.max(max, val);
                            }
                        }
                    }

                    curr[j1][j2] = max;
                }
            }
            for (int j1 = 0; j1 < m; j1++) {
                prev[j1] = curr[j1].clone(); 
            }
        }

        return prev[0][m - 1];
    }
}
