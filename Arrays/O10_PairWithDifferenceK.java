package Arrays;

import java.util.Arrays;

public class O10_PairWithDifferenceK {
    int countPairs(int[] arr, int k) {
        int n = arr.length ; 
        Arrays.sort(arr); 
        int left = 0 ; 
        int right = 1 ; 
        int count = 0 ; 
        while(right < n){
            if(left == right){
                right ++;
                continue; 
            }
            int diff = arr[right] - arr[left]; 
            if(diff == k){
                int leftCount = 0 , rightCount = 0; 
                int leftVal = arr[left]; 
                int rightVal = arr[right]; 
                while(left < n && arr[left] == leftVal){
                    leftCount++ ; 
                    left ++; 
                }
                while(right < n && arr[right] == rightVal){
                    rightCount++; 
                    right ++; 
                }
                count += leftCount * rightCount; 
            }
            else if(diff < k){
                right ++ ; 
            }
            else{
                left ++; 
            }
        }
        return count; 
    }
}
