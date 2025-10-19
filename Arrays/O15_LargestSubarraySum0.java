package Arrays;

import java.util.HashMap;

public class O15_LargestSubarraySum0 {
    int maxLength(int arr[]) {
        int n = arr.length; 
        int sum = 0 ; 
        HashMap<Integer , Integer> mpp = new HashMap<>(); 
        int max = 0; 
        for(int i = 0 ; i < n ; i ++){
            sum += arr[i];
            if(sum == 0){
                max = i + 1 ; 
            }
            if(mpp.containsKey(sum)){
                int len = i - mpp.get(sum);
                max = Math.max(max , len); 
            }
            else{
                mpp.put(sum , i);
            }
        }
        return max ; 
    }
}
