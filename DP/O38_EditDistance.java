package DP;

import java.util.Arrays;

public class O38_EditDistance {
    private int func(int i , int j , String s1, String s2 , int dp[][]){
        if(i == 0 ) return j ; 
        if(j == 0) return i ; 
        
        if(dp[i][j] != -1) return dp[i][j];  
        
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            return dp[i][j] = func(i-1, j-1, s1, s2, dp) ;  
        }
        else{
            int insert = func(i, j-1, s1, s2, dp); 
            int delete = func(i-1 , j, s1, s2, dp); 
            int replace = func(i-1, j-1, s1, s2, dp); 
            return dp[i][j] = 1 + Math.min(insert , Math.min(delete , replace)); 
        }
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length() ; 
        int m = word2.length() ;
        int dp[][] = new int[n+1][m+1]; 
        for(int row[] : dp){
            Arrays.fill(row , -1); 
        } 
        return func(n , m , word1, word2 , dp) ; 
    }
}
