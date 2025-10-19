package DP;

public class O7_HouseRobberII {
    private int func(int dp[] , int arr[] , int n ){
        dp[0] = arr[0] ; 
        if(n > 1){
            dp[1] = Math.max(arr[0] , arr[1]); 
        }
        for(int i = 2 ; i < n ; i++){
            int notpick = dp[i-1] ; 
            int pick = dp[i-2] + arr[i]; 
            int max = Math.max(pick , notpick); 
            dp[i] = max; 
        }
        return dp[n-1]; 
    }
    public int rob(int[] arr) {
        int n = arr.length ;
        if(n == 1) return arr[0]; 
        int dp[] = new int[n]; 
        int a[] = new int[n]; 
        int b[] = new int[n]; 
        for(int i = 0 ; i < n ; i ++){
            if(i > 0){
                a[i-1] = arr[i] ; 
            }
            if(i < n-1){
                b[i] = arr[i]; 
            }
        }
        int val1 = func(dp , a , n); 
        int val2 = func(dp , b ,n); 
        return Math.max(val1, val2); 
    }
}
