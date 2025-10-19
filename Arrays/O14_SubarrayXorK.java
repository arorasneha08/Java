package Arrays;

import java.util.HashMap;

public class O14_SubarrayXorK {
    public long subarrayXor(int arr[], int k) {
        int n = arr.length ; 
        int xor = 0 ; 
        HashMap<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0 , 1); 
        long count = 0 ; 
        for(int i = 0 ; i < n ; i++){
            xor = xor ^ arr[i] ; 
            int rem = xor ^ k ; 
            if(mpp.containsKey(rem)){
                count += mpp.get(rem); 
            }
            mpp.put(xor , mpp.getOrDefault(xor , 0) + 1); 
        }
        return count; 
    }
}
