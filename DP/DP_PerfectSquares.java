import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DP_PerfectSquares {
    // appeoach 1 -> dp
    private int func(int n, int dp[]) {
        if (n == 0)
            return 0;
        int res = n;
        if (dp[n] != -1)
            return dp[n];

        for (int i = 1; i * i <= n; i++) {
            int temp = i * i;
            res = Math.min(res, 1 + func(n - temp, dp));
        }
        return dp[n] = res;
    }

    public int minSquares(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return func(n, dp);
    }

    // appraoch 2  -> bfs 
    public int numSquares(int n) {
        Queue<Integer> q = new LinkedList<>();
        int visited[] = new int[n + 1];
        q.offer(n);
        visited[n] = 1;
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            level++;

            for (int i = 0; i < size; i++) {
                int curr = q.poll();

                for (int j = 1 ; j * j <= curr ; j++) {
                    int next = curr - j * j;

                    if (next == 0) {
                        return level;
                    }
                    if (visited[next] == 0) {
                        visited[next] = 1;
                        q.offer(next);
                    }
                }
            }
        }
        return level;
    }
}
