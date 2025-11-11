public class O10_MinOneBitRequiredZero {
    public int minimumOneBitOperations(int n) {
        int ans = 0;
        while (n > 0) {
            ans ^= n;   
            n >>= 1;    
        }
        return ans;    
    }
}

// leetcode 1611 