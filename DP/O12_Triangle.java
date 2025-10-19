package DP;

import java.util.List;

public class O12_Triangle {
    private int func(int i , int j , int dp[][] , List<List<Integer>> triangle , int n){
        if(i < 0 || i >= n || j > i) return 0 ; 
        if(i == n-1 && j == n-1) return triangle.get(i).get(j); 
        if(dp[i][j] != -1) return dp[i][j]; 

        int left = func(i+1 , j , dp , triangle , n);  
        int up = func(i+1 , j+1 , dp , triangle , n);

        return dp[i][j] = Math.min(up , left) + triangle.get(i).get(j);  
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size() ; 
        int dp[][] = new int[n][]; 
        for(int i = 0 ; i < n ; i ++){
            dp[i] = new int[i+1]; 
        }
        // for(int row[] : dp){
            // Arrays.fill(row , -1) ; 
        // }
        // return func(0 , 0 , dp , triangle , n);

        // for(int i = 0 ; i < n ; i++){
        //     dp[n-1][i] = triangle.get(n-1).get(i); 
        // }
        // for(int i = n-2 ; i >= 0 ; i--){
        //     for(int j = i ; j >= 0 ; j --){
        //         int left = Integer.MAX_VALUE , up = Integer.MAX_VALUE ; 
        //         left = dp[i+1][j]; 
        //         up = dp[i+1][j+1]; 
        //         dp[i][j] = Math.min(left, up) + triangle.get(i).get(j); 
        //     }
        // } 
        // return dp[0][0]; 

        int next[] = new int[n]; 
        for(int i = 0 ; i < n ; i++){
            next[i] = triangle.get(n-1).get(i); 
        }
        for(int i = n-2 ; i >= 0 ; i--){
            int curr[] = new int[n]; 
            for(int j = i ; j >= 0 ; j --){
                int left = Integer.MAX_VALUE , up = Integer.MAX_VALUE ; 
                left = next[j]; 
                up = next[j+1]; 
                curr[j] = Math.min(left, up) + triangle.get(i).get(j); 
            }
            next = curr; 
        } 
        return next[0]; 
    }
}

// leetcode 120 