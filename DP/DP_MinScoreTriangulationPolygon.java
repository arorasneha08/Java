import java.util.Arrays;

public class DP_MinScoreTriangulationPolygon {

    private int func(int i, int j, int[] arr, int[][] dp) {
        if (j - i < 2) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int res = Integer.MAX_VALUE;

        for (int k = i + 1; k < j; k++) {
            res = Math.min( res, func(i, k, arr, dp) + arr[i] * arr[j] * arr[k] + func(k, j, arr, dp));
        }

        return dp[i][j] = res;
    }

    public int minScoreTriangulation(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return func(0, n - 1, arr, dp);
    }
}

// leetcode 1039 