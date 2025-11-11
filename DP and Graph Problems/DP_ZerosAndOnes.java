import java.util.Arrays;

public class DP_ZerosAndOnes {
    private int func(int idx , int zeros , int ones , String[] strs ,int m ,int n , int dp[][][]){
        if(idx == strs.length) return 0 ;
        if(dp[idx][zeros][ones] != -1) return dp[idx][zeros][ones] ;

        int count[] = countValues(strs[idx]); 
        int nottake = func(idx + 1 , zeros , ones , strs , m , n , dp); 
        int take = 0 ; 
        if(zeros >= count[0] && ones >= count[1]){
            take = 1 + func(idx + 1 , zeros - count[0] , ones - count[1], strs , m , n , dp );
        }
        return dp[idx][zeros][ones] = Math.max(take , nottake); 
    }
    private int[] countValues(String str){
        int ones = 0;
        int zeros = 0 ;
        for(int i = 0; i < str.length();  i++){
            char ch = str.charAt(i);
            if(ch == '0') zeros ++ ; 
            else ones ++;  
        }
        return new int[]{zeros , ones};
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length; 
        int dp[][][] = new int[len][m+1][n+1]; 
        for(int layer[][] : dp){
            for(int row[] : layer){
                Arrays.fill(row , -1); 
            }
        }
        return func(0 , m , n, strs, m , n, dp);
    }
}
