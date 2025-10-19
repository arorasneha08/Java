package DP;

public class O17_MinSumPartition {
    public int minDifference(int arr[]) {
        int n = arr.length; 
        int total = 0 ; 
        for(int i = 0 ; i < n ; i ++){
            total += arr[i]; 
        }
        int target = total ; 
        boolean dp[][] = new boolean[n][target+1]; 
        for(int i = 0 ; i < n ; i++){
            dp[i][0] = true; 
        }
        if(arr[0] <= target) dp[0][arr[0]] = true; 
        
        for(int i = 1 ; i < n ;  i++){
            for(int t = 1 ; t <= target ; t++){
                boolean notpick = dp[i-1][t]; 
                boolean pick = false ; 
                if(arr[i] <= t){
                    pick = dp[i-1][t-arr[i]]; 
                }
                dp[i][t] = pick || notpick ; 
            }
        }
        int min = Integer.MAX_VALUE ; 
        for(int s1 = 0 ; s1 <= total/2 ; s1 ++){
            if(dp[n-1][s1] == true){
                min = Math.min(min , Math.abs((total- s1) - s1));
            }
        }
        return min ; 
    }
}
