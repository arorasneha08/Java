package DP;

public class O8_NinjaTraining {
    private int func(int day , int last , int arr[][] , int dp[][]){
        if(day == 0){
            int max = 0 ; 
            for(int task = 0 ;  task < 3 ;  task ++){
                if(task != last){
                    max = Math.max(max , arr[0][task]); 
                }
            }
            return max ; 
        }
        if(dp[day][last] != -1) return dp[day][last] ; 
        
        int maxPoints = 0 ; 
        for(int task = 0 ; task < 3 ; task ++){
            if(task != last){
                int points = arr[day][task] + func(day-1 , task , arr, dp);  
                maxPoints = Math.max(maxPoints , points); 
            }
        }
        return dp[day][last] = maxPoints; 
    }
    public int maximumPoints(int arr[][]) {
        int n = arr.length ;
        int dp[][] = new int[n][4];
        // for(int i = 0 ;  i< n ; i++){
        //     for(int j = 0 ; j < 4 ; j ++){
        //         dp[i][j] = -1; 
        //     }
        // }
        // return func(n-1 , 3 , arr, dp); 
        
        for(int last = 0 ; last < 4 ; last ++){
            int max = 0 ;
            for(int task = 0 ; task < 3 ;  task ++){
                if(task != last){
                    max = Math.max(max , arr[0][task]); 
                }
            }
            dp[0][last] = max ; 
        }
        for(int day = 1 ; day < n ; day ++){
            for(int last = 0 ; last < 4 ; last ++){
                int max = 0 ; 
                for(int task = 0 ; task < 3 ; task ++){
                    if(task != last){
                        int points = arr[day][task] + dp[day-1][task]; 
                        max = Math.max(max , points); 
                    }
                }
                dp[day][last] = max; 
            }
        }
        return dp[n-1][3]; 
        
    } 
}

// gfg 