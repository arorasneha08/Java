import java.util.Arrays;

public class MaxDistinctAfterOperation {
    public int maxDistinctElements(int[] arr, int k) {
        int n = arr.length ; 
        Arrays.sort(arr); 
        int nextAval = Integer.MIN_VALUE ;
        int count = 0 ; 
        for(int i = 0 ; i < n ; i++){
            int start = Math.max(arr[i] - k , nextAval);
            if(start <= arr[i] + k){
                count ++; 
                nextAval = start + 1; 
            }
        }
        return count; 
    }
}

// leetcode 3397