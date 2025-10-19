package DP;

public class O15_SubsetSum {
    static boolean func(int index, int target , Boolean[][] dp , int arr[]){
        if(target == 0) return true; 
        if(index == 0){
            if(arr[index] == target) return true; 
            return false; 
        }
        if(dp[index][target] != null) return dp[index][target]; 
        boolean notpick = func(index - 1 , target , dp , arr); 
        boolean pick = false; 
        if(target >= arr[index]){
            pick = func(index - 1 , target - arr[index] , dp , arr); 
        }
        dp[index][target] = pick || notpick ; 
        return dp[index][target]; 
    }
    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length ; 
        Boolean dp[][] = new Boolean[n][sum+1]; 
        // return func(n-1 , sum , dp, arr); 
        
        // for(int i = 0 ;  i< n ;  i++){
        //     Arrays.fill(dp[i] , false); 
        // }
        // for(int i = 0 ; i < n ; i ++){
        //     dp[i][0] = true;  
        // }
        // if(arr[0] <= sum) dp[0][arr[0]] = true; 
        
        // for(int i = 1 ; i < n ; i++){
        //     for(int t = 1 ; t <= sum ; t ++){
        //         boolean nottake = dp[i-1][t]; 
        //         boolean take = false; 
        //         if(t >= arr[i]){
        //             take = dp[i-1][t - arr[i]]; 
        //         }
        //         dp[i][t] = take || nottake ; 
        //     }
        // }
        // return dp[n-1][sum] ; 
        
        boolean prev[] = new boolean[sum+1]; 
        prev[0] = true; 
        if(arr[0] <= sum) prev[arr[0]] = true; 
        
        for(int i = 1 ; i < n ; i++){
            boolean curr[] = new boolean[sum+1]; 
            curr[0] = true; 
            for(int t = 1 ; t <= sum ; t ++){
                boolean nottake = prev[t]; 
                boolean take = false; 
                if(t >= arr[i]){
                    take = prev[t - arr[i]]; 
                }
                curr[t] = take || nottake ; 
            }
            prev = curr ; 
        }
        return prev[sum] ; 
    }
}

