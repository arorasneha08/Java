public class O9_SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] arr, int k) {
        int n = arr.length ; 
        if(k <= 1) return 0 ; 
        int count = 0 ; 
        int prod = 1 ; 
        int left = 0 ; 
        for(int i = 0 ; i < n ; i++){
            prod *= arr[i];
            while(prod >= k){
                prod = prod / arr[left]; 
                left ++; 
            }
            count += (i - left + 1); 
        }
        return count ; 
    }
}

// remember the base condition 