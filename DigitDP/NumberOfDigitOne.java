package DigitDP;

import java.util.Arrays;

// leetcode 233 
public class NumberOfDigitOne {
    private int func(String s, int idx, int tight, int count, int dp[][][]) {
        if (idx == s.length()) return count;

        if (dp[idx][tight][count] != -1) return dp[idx][tight][count];

        int limit = (tight == 1) ? s.charAt(idx) - '0' : 9;
        int res = 0;

        for (int i = 0; i <= limit; i++) {
            int updatedCnt = count + ((i == 1) ? 1 : 0);
            int newTight = (tight == 1 && i == limit) ? 1 : 0;

            res += func(s, idx + 1, newTight, updatedCnt, dp);
        }

        return dp[idx][tight][count] = res;
    }

    public int countDigitOne(int n) {
        String s = String.valueOf(n);
        int len = s.length();

        int dp[][][] = new int[len][2][len + 1];

        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }

        return func(s, 0, 1, 0, dp);
    }
}
