package DP;

import java.util.Arrays;

public class O25_RodCutting {
    private int func(int i, int length, int[] arr, int[][] dp) {
        if (i == 0) {
            return length * arr[0]; 
        }

        if (dp[i][length] != -1) return dp[i][length];

        int notPick = func(i - 1, length, arr, dp);

        int pick = Integer.MIN_VALUE;
        int rodLength = i + 1;
        if (rodLength <= length) {
            pick = arr[i] + func(i, length - rodLength, arr, dp);
        }

        return dp[i][length] = Math.max(pick, notPick);
    }

    public int cutRod(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return func(n - 1, n, arr, dp);
    }
}
