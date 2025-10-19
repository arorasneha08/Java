import java.util.HashMap;

public class O2_BinarySubarraySum {
    public int numSubarraysWithSum(int[] arr, int goal) {
        HashMap<Integer , Integer> mpp = new HashMap<>(); 
        int n = arr.length; 
        int res = 0 ; 
        int sum = 0 ; 
        mpp.put(0 , 1); 
        for(int i = 0 ; i < n ; i ++){
            sum += arr[i]; 
            int rem = sum- goal ;
            if(mpp.containsKey(rem)){
                res += mpp.get(rem); 
            }
            mpp.put(sum , mpp.getOrDefault(sum , 0) + 1); 
        }
        return res ; 
    }
}
