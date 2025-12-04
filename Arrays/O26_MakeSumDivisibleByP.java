package Arrays ; 
import java.util.HashMap;

public class O26_MakeSumDivisibleByP{
    public int minSubarray(int[] arr , int p) {
        int n = arr.length ; 
        long total = 0 ; 
        for(int num : arr){
            total += num ; 
        }
        int need = (int)(total % p) ; 
        if(need == 0) return 0; 
        long pref = 0 ; 
        int min = n ; 
        HashMap<Integer , Integer> mpp = new HashMap<>(); 
        mpp.put(0 , -1); 

        for(int i = 0 ; i < n ; i++){
            pref = (pref + arr[i])% p ; 
            int target = (int)(pref - need + p) % p ;
            if(mpp.containsKey(target)){
                min = Math.min(min , i - mpp.get(target)); 
            }
            mpp.put((int)pref , i); 
        }
        if(min == n) return -1; 
        return min ; 
    }
}
// leetcode 1590 