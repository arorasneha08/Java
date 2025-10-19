package DP;

public class O18_PartitionGivenDifference {
    int countPartitions(int[] arr, int d) {
        int n = arr.length;

        int total = 0;
        for (int num : arr) total += num;

        if ((total - d) < 0 || (total - d) % 2 != 0) return 0;

        int target = (total - d) / 2;

        int[][] dp = new int[n][target + 1];

        if (arr[0] == 0) {
            dp[0][0] = 2; 
        } else {
            dp[0][0] = 1;
            if (arr[0] <= target) dp[0][arr[0]] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= target; t++) {
                int notpick = dp[i - 1][t];
                int pick = 0;
                if (arr[i] <= t) {
                    pick = dp[i - 1][t - arr[i]];
                }
                dp[i][t] = pick + notpick;
            }
        }

        return dp[n - 1][target];
    }
}

//