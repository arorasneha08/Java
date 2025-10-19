package DP;

import java.util.Arrays;

public class O49_EvaluateBooleanTrue {
    static int func(int i , int j , boolean isTrue , String s , int dp[][][]){
        if(i > j) return 0 ;  
        if(i == j){
            if(isTrue){
                return s.charAt(i) == 'T' ? 1 : 0  ; 
            }
            else {
                return s.charAt(i) == 'F' ? 1 : 0 ; 
            }
        }
        if(dp[i][j][isTrue ? 1 : 0] != -1) return dp[i][j][isTrue ? 1 : 0]; 
        
        int ways = 0 ; 
        for(int idx = i+1 ; idx < j ; idx += 2){
            int leftTrue = func(i, idx - 1, true, s, dp);
            int leftFalse = func(i, idx - 1, false, s, dp);
            int rightTrue = func(idx + 1, j, true, s, dp);
            int rightFalse = func(idx + 1, j, false, s, dp);
            
            if(s.charAt(idx) == '&'){
                if(isTrue) ways += leftTrue * rightTrue; 
                else ways += leftFalse * rightTrue + leftTrue * rightFalse + rightFalse * leftFalse; 
            }
            else if(s.charAt(idx) == '|'){
                if(isTrue) ways += leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue; 
                else ways += rightFalse * leftFalse; 
            }
            else{
                if(isTrue) ways += leftFalse * rightTrue + leftTrue * rightFalse ; 
                else ways += leftTrue * rightTrue + leftFalse * rightFalse; 
            }
        }
        return dp[i][j][isTrue ? 1 : 0] = ways; 
    }
    static int countWays(String s) {
        int n = s.length();
        int dp[][][] = new int[n][n][2]; 
        for(int layer[][] : dp){
            for(int row[] : layer){
                Arrays.fill(row,  -1); 
            }
        }
        return func(0 , n-1 , true , s, dp); 
    }
}
