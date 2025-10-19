import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class O13_NumberOfExcellentPairs {
    public long countExcellentPairs(int[] arr , int k) {
        Set<Integer> set = new HashSet<>();
        for(int num : arr){
            set.add(num); 
        }
        List<Integer> bits = new ArrayList<>(); 
        for(int num : set){
            bits.add(Integer.bitCount(num));
        }
        int n = bits.size() ;
        long count  =  0  ;
        Collections.sort(bits); 
        for(int i = 0 ; i < bits.size() ; i++){
            int x = bits.get(i); 
            int left = 0 ; 
            int right = n-1; 
            int pos = n  ;
            while(left <= right){
                int mid = left + (right - left) /2 ; 
                if(x + bits.get(mid) >= k){
                    pos = mid ; 
                    right = mid - 1;  
                }
                else {
                    left = mid + 1; 
                }
            }
            count += (n - pos) ; 
        }
        return count ; 
    }
}
