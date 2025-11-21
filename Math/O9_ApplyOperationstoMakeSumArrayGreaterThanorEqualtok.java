
public class O9_ApplyOperationstoMakeSumArrayGreaterThanorEqualtok {
    public int minOperations(int k) {
        int op = Integer.MAX_VALUE ; 
        for(int i = 1 ; i <= k ; i++){
            int count = (i - 1) + (int) Math.ceil((double) (k - i)/ i);  
            op = Math.min(op , count); 
        }
        return op ;
    }
}

// leetcode 3091 