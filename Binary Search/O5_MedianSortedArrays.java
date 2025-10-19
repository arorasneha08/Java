public class O5_MedianSortedArrays {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int n = arr1.length ; 
        int m = arr2.length ; 
        if(n > m){
            return findMedianSortedArrays(arr2 , arr1);
        }
        int low = 0 ; 
        int high = n;  
        int left = (n + m + 1)/2; 

        while(low <= high){
            int mid1 = low + (high - low)/2; 
            int mid2 = (left - mid1); 
            int l1 = (mid1 - 1 >= 0) ? arr1[mid1-1]: Integer.MIN_VALUE;
            int l2 = (mid2 - 1 >= 0) ? arr2[mid2-1]: Integer.MIN_VALUE; 
            int r1 = (mid1 < n) ? arr1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < m) ?arr2[mid2] : Integer.MAX_VALUE;  
            if(l1 <= r2 && l2 <= r1){
                if((n + m) % 2 == 0){
                    return (Math.max(l1 , l2) + Math.min(r1 , r2))/2.0 ; 
                }
                else{
                    return Math.max(l1 , l2); 
                }
            }
            else if(l1 > r2){
                high = mid1 - 1; 
            }
            else{
                low = mid1 + 1 ; 
            }   
        }
        return 0.0;
    }
}
