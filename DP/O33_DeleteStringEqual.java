package DP;

import java.util.Arrays;

public class O33_DeleteStringEqual {
    private int func(int i , int j , String s1 , String s2 , int dp[][]){
        if(i== 0 || j == 0) return 0 ; 
        if(dp[i][j] != -1) return dp[i][j]; 

        if(s1.charAt(i-1) == s2.charAt(j-1)){
            return dp[i][j] = 1 + func(i-1, j-1 , s1, s2, dp); 
        }
        else{
            return dp[i][j] = Math.max(func(i-1, j, s1, s2, dp) , func(i, j-1, s1, s2, dp)); 
        }
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length(); 
        int m = word2.length(); 

        int dp[][] = new int[n+1][m+1];
        for(int row[] : dp){
            Arrays.fill(row , -1); 
        }
        int lcs = func(n , m, word1, word2, dp);
        int res = n - lcs + m - lcs ;
        return res; 
    }
}
