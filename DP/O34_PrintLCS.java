package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class O34_PrintLCS {
    public List<String> allLCS(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        
        Set<String> result = new TreeSet<>();
        backtrack(s1, s2, n, m, dp, new StringBuilder(), result, new HashMap<>());
        return new ArrayList<>(result);
    }

    private Set<String> backtrack(String s1, String s2, int i, int j, int[][] dp,
          StringBuilder path, Set<String> result,
          Map<String, Set<String>> memo) {
              
        String key = i + "," + j + "," + path.toString();
        if (memo.containsKey(key)) return memo.get(key);

        Set<String> res = new HashSet<>();

        if (i == 0 || j == 0) {
            res.add(path.toString());
        } 
        else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            path.insert(0, s1.charAt(i - 1));
            res.addAll(backtrack(s1, s2, i - 1, j - 1, dp, path, result, memo));
            path.deleteCharAt(0);
        }
        else {
            if (dp[i - 1][j] >= dp[i][j - 1]) {
                res.addAll(backtrack(s1, s2, i - 1, j, dp, path, result, memo));
            }
            if (dp[i][j - 1] >= dp[i - 1][j]) {
                res.addAll(backtrack(s1, s2, i, j - 1, dp, path, result, memo));
            }
        }
        memo.put(key, res);
        return result.addAll(res) ? res : res;
    }
}
