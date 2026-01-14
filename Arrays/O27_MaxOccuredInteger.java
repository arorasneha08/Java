package Arrays;

import java.util.List;

public class O27_MaxOccuredInteger {
    public int maxOccured(List<Integer> L, List<Integer> R) {
        int max = 0  ;
        for(int num : L){
            max =  Math.max(max , num); 
        }
        for(int num : R){
            max = Math.max(max , num); 
        }
        int count[] = new int[max+2]; 
        for(int i = 0 ; i < L.size() ; i++){
            count[L.get(i)] ++; 
            count[R.get(i) + 1] -- ; 
        }
        for(int i = 1 ; i <= max; i++){
            count[i] = count[i-1] + count[i] ;    
        }
        int maxCount = 0 ; 
        int res = 0 ; 
        for(int i = 0 ; i <= max; i++){
            if(count[i] > maxCount){
                res = i ; 
                maxCount = count[i]; 
            }
        }
        return res; 
    }
}

// gfg 