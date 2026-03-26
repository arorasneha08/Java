import java.util.ArrayList;
import java.util.List;

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

    private void func(List<String> list, StringBuilder sb , int n){
        if(sb.length() == n){
            list.add(sb.toString()); 
            return ; 
        }
        sb.append('0'); 
        func(list , sb , n); 
        sb.deleteCharAt(sb.length()-1); 
        
        if(sb.length() == 0 || sb.charAt(sb.length()-1) != '1'){
            sb.append('1'); 
            func(list , sb , n); 
            sb.deleteCharAt(sb.length()-1); 
        }
        
    }
    int countStrings2(int n) {
        StringBuilder sb = new StringBuilder(); 
        List<String> list = new ArrayList<>(); 
        
        func(list , sb , n); 
        return list.size(); 
        
    }

    // CP Code :- Modular Exponentiation

    class Solution {

    static final int MOD = 1000000007;

    private long[][] multiply(long[][] A, long[][] B){
        long[][] res = new long[2][2];

        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                for(int k = 0; k < 2; k++){
                    res[i][j] = (res[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return res;
    }

    private long[][] power(long[][] mat, int n){
        long[][] res = {{1,0},{0,1}}; // identity

        while(n > 0){
            if((n & 1) == 1){
                res = multiply(res, mat);
            }
            mat = multiply(mat, mat);
            n >>= 1;
        }
        return res;
    }

    int countStrings(int n) {
        if(n == 1) return 2;
        if(n == 2) return 3;

        long[][] base = {{1,1},{1,0}};
        long[][] res = power(base, n - 2);

        long fn = (res[0][0] * 3 + res[0][1] * 2) % MOD;

        return (int)fn;
    }
}
}


// gfg  :- https://www.geeksforgeeks.org/problems/consecutive-1s-not-allowed1912/1