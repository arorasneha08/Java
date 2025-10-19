import java.util.*;

public class AdjacentIncreasingSubarray {
    public boolean hasIncreasingSubarrays(List<Integer> arr, int k) {
        int n = arr.size() ;
        for(int i = 0 ; i < n - 2 * k + 1; i++){
            boolean inc1 = true; 
            boolean inc2 = true ; 
            for(int j = i ; j < Math.min(n , i + k - 1) ; j++){
                if(arr.get(j) >= arr.get(j+1)){
                    inc1 = false;
                    break ;  
                }
            }
            for(int j = i + k ; j < Math.min(n, i + 2 * k - 1) ; j++){
                if(arr.get(j) >= arr.get(j+1)){
                    inc2 = false; 
                    break ; 
                }
            }
            if(inc1 && inc2) return true; 
        }
        return false; 
    }
}
