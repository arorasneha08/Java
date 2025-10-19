package DP;

import java.util.Arrays;

public class O36_ShortestCommonSupersequence {
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
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length(); 
        int m = str2.length(); 

        int dp[][] = new int[n+1][m+1];
        for(int row[] : dp){
            Arrays.fill(row , -1); 
        }
        int lcs = func(n , m , str1, str2 , dp); 
        int i = n , j = m ; 
        StringBuilder str = new StringBuilder(); 
        while(i > 0 && j > 0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                str.append(str1.charAt(i-1)); 
                i-- ; 
                j-- ;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                str.append(str1.charAt(i-1)); 
                i-- ;
            }
            else {
                str.append(str2.charAt(j-1)); 
                j-- ;
            }
        }
        while(i> 0){
            str.append(str1.charAt(i-1)); 
            i-- ; 
        }
        while(j > 0){
            str.append(str2.charAt(j-1)); 
            j-- ;
        }
        return str.reverse().toString(); 
    }
}
