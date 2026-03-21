package DigitDP ; 
import java.util.*;

public class ClassyNumbers {
    static long dp[][][]; 

    private static long func(String s, int idx, int tight, int count) {
        if (idx == s.length()) return 1;

        if (dp[idx][tight][count] != -1)
            return dp[idx][tight][count];

        int limit = (tight == 1) ? s.charAt(idx) - '0' : 9;
        long res = 0;

        for (int i = 0; i <= limit; i++) {

            int newCount = count + ((i != 0) ? 1 : 0);
            if (newCount > 3) continue;

            int newTight = (tight == 1 && i == limit) ? 1 : 0;

            res += func(s, idx + 1, newTight, newCount);
        }

        return dp[idx][tight][count] = res;
    }

    public static long solve(long n) {
        if (n < 0) return 0;

        String s = String.valueOf(n);
        int len = s.length();

        dp = new long[len][2][4];  

        for (long[][] layer : dp) {
            for (long[] row : layer) {
                Arrays.fill(row, -1);
            }
        }

        return func(s, 0, 1, 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            long l = sc.nextLong();
            long r = sc.nextLong();

            System.out.println(solve(r) - solve(l - 1));
        }

        sc.close();
    }
}