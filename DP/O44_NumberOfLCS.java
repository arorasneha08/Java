package DP;

public class O44_NumberOfLCS {
    public int findNumberOfLIS(int[] arr) {
        int n = arr.length ; 
        int dp[] = new int[n] ;
        int count[] = new int[n]; 
        for(int i = 0 ; i < n ; i++){
            dp[i] = 1; 
            count[i] = 1 ; 
        }
        int max = Integer.MIN_VALUE; 
        for(int i = 0 ; i < n ; i ++){
            for(int prev = 0 ; prev < i  ; prev ++){
                if(arr[prev] < arr[i]){
                    if(dp[i] < dp[prev] + 1){
                        dp[i] = 1 + dp[prev]; 
                        count[i] = count[prev]; 
                    } 
                    else if(dp[prev] + 1 == dp[i]){
                        count[i] += count[prev]; 
                    }
                }
            }
            max = Math.max(max , dp[i]); 
        }
        int total = 0 ; 
        for(int i = 0 ;  i< n ; i ++){
            if(dp[i] == max){
                total += count[i] ; 
            }
        }
        return total ;
    }
}
