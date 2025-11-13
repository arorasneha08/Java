package Math;

public class O16_MinOperationToMakeAllOnes {
    private int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }

    public int minOperations(int[] arr) {
        int n = arr.length;
        int ones = 0;
        for (int x : arr) {
            if (x == 1) ones++;
        }

        if (ones > 0) {
            return n - ones;
        }

        int overallGcd = arr[0];
        for (int i = 1; i < n; i++) {
            overallGcd = gcd(overallGcd, arr[i]);
        }
        if (overallGcd != 1) return -1;

        int len = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int g = arr[i];
            for (int j = i + 1; j < n; j++) {
                g = gcd(g, arr[j]);
                if (g == 1) {
                    len = Math.min(len, j - i + 1);
                    break;
                }
            }
        }
        return (len - 1) + (n - 1);
    }
}
