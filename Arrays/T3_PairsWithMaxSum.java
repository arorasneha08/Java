package Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class T3_PairsWithMaxSum {
    static int MaximumSum(int arr[]) {
        int n = arr.length ; 
        Arrays.sort(arr); 
        
        HashMap<Integer , Integer> mpp = new HashMap<>(); 
        for(int num : arr){
            mpp.put(num , mpp.getOrDefault(num, 0) + 1); 
        }
        if(n <= 1) return 0 ;
        if(n == 2){
            return 1 ;
        }
        
        if(arr[n-1] == arr[n-2]){
            int val = mpp.get(arr[n-1]); 
            return (val * (val -1))/2 ;
        }
        else{
            int firstMax = arr[n-1];
            int secMax = arr[n-2] ;
            
            int freq1 = mpp.get(firstMax); 
            int freq2 = mpp.get(secMax); 
            return freq1 * freq2 ; 
        }
    }
}
