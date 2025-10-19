package DP;

import java.util.Arrays;

public class O48_BurstBallons {
    private int func(int i , int j , int[] arr , int[][] dp){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int max = 0;
        for(int idx = i; idx <= j; idx++){
            int cost = arr[i-1] * arr[idx] * arr[j+1]
                     + func(i, idx - 1, arr, dp)
                     + func(idx + 1, j, arr, dp);
            max = Math.max(max, cost);
        }
        return dp[i][j] = max;
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;

        for(int i = 0; i < n; i++){
            arr[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return func(1, n, arr, dp);
    }
}
