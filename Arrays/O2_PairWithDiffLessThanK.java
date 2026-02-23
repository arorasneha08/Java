package Arrays;

import java.util.Arrays;

public class O2_PairWithDiffLessThanK {
    public static int countPairs(int arr[], int k) {
        int n = arr.length ; 
        Arrays.sort(arr);
        int i = 0 ; 
        int j = 1; 
        int count = 0 ; 
        
        while(j < n){
            while(arr[j] - arr[i] >= k){
                i++; 
            }
            if(arr[j] - arr[i] < k){
                count += (j - i) ; 
            }
            j++; 
        }
        return count; 
    }
}
