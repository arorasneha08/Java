import java.util.Arrays;

public class DP_DistinctSubsequencesII {
    public int distinctSubseqII(String s) {
        int MOD = 1000000007;
        int n = s.length();
        int[] dp = new int[n+1];  
        dp[0] = 1; 

        int[] last = new int[26]; 
        Arrays.fill(last, -1);

        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i-1);
            dp[i] = (int)((2L * dp[i-1]) % MOD);

            if (last[c - 'a'] != -1) {
                dp[i] = (dp[i] - dp[last[c - 'a'] - 1] + MOD) % MOD;
            }

            last[c - 'a'] = i;
        }

        return (dp[n] - 1 + MOD) % MOD;  
    }
}

// leetcode 940 