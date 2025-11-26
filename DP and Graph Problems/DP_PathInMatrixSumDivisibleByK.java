import java.util.Arrays;

public class DP_PathInMatrixSumDivisibleByK {
    int mod = (int) 1e9 + 7;

    private int func(int i, int j, int sum, int grid[][], int k, int dp[][][], int n, int m) {
        if (i == n || j == m)
            return 0;
        if (i == n - 1 && j == m - 1) {
            if (((sum + grid[i][j]) % k) == 0) {
                return 1;
            }
            return 0;
        }
        if (dp[i][j][sum] != -1)
            return dp[i][j][sum];
        int down = func(i + 1, j, (sum + grid[i][j]) % k, grid, k, dp, n, m);
        int right = func(i, j + 1, (sum + grid[i][j]) % k, grid, k, dp, n, m);
        return dp[i][j][sum] = (right + down) % mod;
    }

    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][][] = new int[n][m][k];
        for (int layer[][] : dp) {
            for (int row[] : layer) {
                Arrays.fill(row, -1);
            }
        }
        return func(0, 0, 0, grid, k, dp, n, m) % mod;
    }
}
