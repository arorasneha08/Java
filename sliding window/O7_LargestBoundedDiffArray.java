import java.util.*;

public class O7_LargestBoundedDiffArray {
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        ArrayList<Integer> res = new ArrayList<>() ;
        TreeMap<Integer , Integer> mpp = new TreeMap<>();
        int left = 0 , right = 0 ;
        int maxLen = 0 ; 
        int startIdx = 0 ; 
        
        int n = arr.length; 
        while(right < n){
            mpp.put(arr[right] , mpp.getOrDefault(arr[right], 0)+1); 
            
            while(mpp.lastKey() - mpp.firstKey() > x){
                mpp.put(arr[left] , mpp.get(arr[left])-1); 
                if(mpp.get(arr[left]) == 0){
                    mpp.remove(arr[left]); 
                }
                left ++ ; 
            }
            
            if(right - left + 1 > maxLen){
                maxLen = right - left + 1 ; 
                startIdx = left;
            }
            right ++ ; 
        }
        for(int i = startIdx ; i < startIdx + maxLen ; i++){
            res.add(arr[i]); 
        }
        return res; 
    }
}
