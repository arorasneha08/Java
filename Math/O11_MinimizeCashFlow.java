
public class O11_MinimizeCashFlow {
    static int getMax(int[] arr) {
        int idx = 0;
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > arr[idx]) idx = i;
        return idx;
    }

    static int getMin(int[] arr) {
        int idx = 0;
        for (int i = 1; i < arr.length; i++)
            if (arr[i] < arr[idx]) idx = i;
        return idx;
    }

    static void settle(int[] net, int[][] ans) {
        int maxCredit = getMax(net);
        int maxDebit = getMin(net);

        if (net[maxCredit] == 0 && net[maxDebit] == 0)
            return;

        int amount = Math.min(-net[maxDebit], net[maxCredit]);
        net[maxCredit] -= amount;
        net[maxDebit] += amount;

        ans[maxDebit][maxCredit] = amount;
        
        settle(net, ans);
    }

    public static int[][] minCashFlow(int[][] transaction, int N) {
        int[] net = new int[N];

        for (int p = 0; p < N; p++) {
            for (int i = 0; i < N; i++) {
                net[p] += (transaction[i][p] - transaction[p][i]);
            }
        }

        int[][] ans = new int[N][N];
        settle(net, ans);
        return ans;
    }
}
