package Arrays;

import java.util.Arrays;

public class O22_MinIncrementArrayUnique {
    public int minIncrementForUnique(int[] arr) {
        int n = arr.length ; 
        Arrays.sort(arr); 
        int op = 0 ; 
        for(int i = 1 ; i < n ; i++){
            if(arr[i] <= arr[i-1]){
                op += arr[i-1] - arr[i] + 1; 
                arr[i] = arr[i-1] + 1 ; 
            }
        }
        return op; 
    }
}
