import java.util.*;

public class DP_CanIWin {

    // in this code got the tle error because converting the boolean array to the string takes the O(n) time for each operation 

    // HashMap<String , Boolean> mpp ; 
    // private boolean func(int maxChoosableInteger , int desiredTotal , boolean chosen[]){
    //     if(desiredTotal <= 0){
    //         return false ;
    //     }
    //     String str = Arrays.toString(chosen); 
    //     if(mpp.containsKey(str)){
    //         return mpp.get(str); 
    //     }
    //     for(int i = 1 ; i <= maxChoosableInteger ; i++){
    //         if(chosen[i]){
    //             continue; 
    //         }
    //         chosen[i] = true; 
    //         if(!func(maxChoosableInteger , desiredTotal - i , chosen)){
    //             mpp.put(str , true); 
    //             chosen[i] = false; 
    //             return true; 
    //         }
    //         chosen[i] = false; 
    //     }
    //     mpp.put(str , false) ;
    //     return false ;
    // }
    // public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    //     if(desiredTotal <= maxChoosableInteger){
    //         return true; 
    //     }
    //     mpp = new HashMap<>() ;
    //     if(((maxChoosableInteger) * (maxChoosableInteger + 1) / 2) < desiredTotal){
    //         return false; 
    //     }
    //     return func(maxChoosableInteger , desiredTotal , new boolean[maxChoosableInteger + 1]); 
    // }


    HashMap<Integer , Boolean> mpp ; 

    private boolean func(int maxChoosableInteger , int desiredTotal , int usedMask){
        if(desiredTotal <= 0){
            return false ;
        }
        if(mpp.containsKey(usedMask)){
            return mpp.get(usedMask); 
        }
        for(int i = 1 ; i <= maxChoosableInteger ; i++){
            int bit = 1 << i ; 
            if((usedMask & bit) != 0) {
                continue; 
            } 
            if(!func(maxChoosableInteger , desiredTotal - i , usedMask | bit)){
                mpp.put(usedMask , true); 
                return true; 
            }
        }
        mpp.put(usedMask , false) ;
        return false ;
    }
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal <= maxChoosableInteger){
            return true; 
        }
        mpp = new HashMap<>() ;
        if(((maxChoosableInteger) * (maxChoosableInteger + 1) / 2) < desiredTotal){
            return false; 
        }
        return func(maxChoosableInteger , desiredTotal , 0); 
    }
}
