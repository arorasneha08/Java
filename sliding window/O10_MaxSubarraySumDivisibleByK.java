public class O10_MaxSubarraySumDivisibleByK {
    public long maxSubarraySum(int[] arr, int k) {
        int n = arr.length ; 
        long pref[] = new long[n+1];
        for(int i = 0; i < n ;i++){
            pref[i+1] = pref[i] + arr[i];
        }
        long ans = Long.MIN_VALUE;
        for(int start = 0; start < k ; start ++){
            long curr = 0; 
            long best = Long.MIN_VALUE;
            for(int i = start ; i < n- k + 1 ; i+= k){
                int right = i + k - 1 ; 
                long sum = pref[right + 1] - pref[i]; 
                curr = Math.max(sum , curr + sum); 
                best = Math.max(best , curr); 
            }
            ans = Math.max(ans , best); 
        }
        return ans ;
    }
}

// leetcode 3381  