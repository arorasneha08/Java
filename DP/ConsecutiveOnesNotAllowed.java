public class ConsecutiveOnesNotAllowed{
    int countStrings(int n) {

        if(n == 1) return 2;

        long prev2 = 2; // dp[1]
        long prev1 = 3; // dp[2]

        for(int i = 3; i <= n; i++){
            long curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return (int)prev1;
    }
}

// gfg  :- https://www.geeksforgeeks.org/problems/consecutive-1s-not-allowed1912/1