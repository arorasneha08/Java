public class O2_LowerBound {
    int lowerBound(int[] arr, int target) {
        int n = arr.length ; 
        int start = 0 ;
        int end = n-1; 
        int res = n; 
        while(start <= end){
            int mid = (start + end)/2; 
            if(arr[mid] >= target){
                res = mid; 
                end = mid - 1; 
            }
            else{
                start = mid + 1; 
            }
        }
        return res; 
    }
    int upperBound(int[] arr, int target) {
        int n = arr.length ; 
        int start = 0 ;
        int end = n-1; 
        int res = n; 
        while(start <= end){
            int mid = (start + end)/2; 
            if(arr[mid] > target){
                res = mid; 
                end = mid - 1; 
            }
            else{
                start = mid + 1; 
            }
        }
        return res; 
    }
}
