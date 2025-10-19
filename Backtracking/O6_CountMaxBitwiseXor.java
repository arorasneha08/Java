package Backtracking ; 

public class O6_CountMaxBitwiseXor {
    private int backtrack(int idx , int currXor , int maxXor, int arr[]){
        if(idx == arr.length){
            if(currXor == maxXor){
                return 1 ; 
            }
            return 0 ; 
        }
        int pick = backtrack(idx + 1 , currXor | arr[idx] , maxXor , arr); 
        int notpick = backtrack(idx + 1 , currXor , maxXor , arr); 
        return pick + notpick ; 
    }
    public int countMaxOrSubsets(int[] arr) {
        int n = arr.length; 
        int maxXor = 0 ; 
        for(int i = 0 ; i < n ; i++){
            maxXor |= arr[i]; 
        }
        return backtrack(0 , 0, maxXor , arr) ; 
    }
}

// leetcode 2044 