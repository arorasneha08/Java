package Arrays;

import java.util.Arrays;

public class O19_MaxSumOfMin {
    public int arrayPairSum(int[] arr) {
        int n = arr.length ; 
        Arrays.sort(arr) ; 
        int sum = 0 ; 
        for(int i = 0 ; i < n ; i+= 2){
            sum += arr[i]; 
        }
        return sum; 
    }
}
