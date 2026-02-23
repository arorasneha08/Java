public class MinimumSidewaysJumps {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length ; 
        int INF = (int) 1e9+7 ; 
        int dp[] = new int[4]; 
        dp[0] = 1 ;
        dp[1] = 0 ; 
        dp[2] = 1 ; 

        for(int i = 1 ;  i < n ; i++){
            if(obstacles[i] != 0){
                dp[obstacles[i]-1] = INF; 
            }
            for(int lane = 0 ; lane < 3 ; lane ++){
                if(obstacles[i] != lane + 1){
                    dp[lane] = Math.min(dp[lane] , 1 + Math.min(dp[(lane + 1) % 3] , dp[(lane + 2) % 3]));
                }
            }
        }
        return Math.min(dp[0] , Math.min(dp[1] , dp[2])); 
    }
}
