import java.util.Arrays;

public class DP_GreatestSumDivisibleByThree {
    private int func(int idx, int sum, int[] arr, int[][] dp, int n) {
        if (idx == n) {
            return (sum % 3 == 0) ? 0 : Integer.MIN_VALUE;
        }

        if (dp[idx][sum] != -1) return dp[idx][sum];

        int notpick = func(idx + 1, sum, arr, dp, n);
        int pick = arr[idx] + func(idx + 1, (sum + arr[idx]) % 3, arr, dp, n);

        return dp[idx][sum] = Math.max(pick, notpick);
    }

    public int maxSumDivThree(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][3];

        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);

        int result = func(0, 0, arr, dp, n);
        return Math.max(result, 0);  
    }
}
