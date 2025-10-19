package Arrays;

public class O4_MaxProductSubarray {
    public int maxProduct(int[] arr) {
        int n = arr.length; 
        int prod = 1 ; 
        int max = Integer.MIN_VALUE ;
        for(int i = 0 ; i < n ; i++){
            if(prod == 0) prod = 1;  
            prod = prod * arr[i]; 
            max = Math.max(max , prod); 
        }
        prod = 1; 
        for(int i = n-1; i >= 0 ; i--){
            if(prod == 0) prod = 1;  
            prod = prod * arr[i]; 
            max = Math.max(max , prod); 
        }
        return max; 
    }
}
