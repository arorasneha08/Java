public class O6_BookAllocation {
    private static boolean isPossible(int mid , int arr[] , int k){
        int n = arr.length ; 
        int pages = 1; 
        int sum = 0 ; 
        for(int i = 0 ; i < n ; i++){
            if(sum + arr[i] <= mid){
                sum += arr[i];
            }
            else{
                sum = arr[i] ;
                pages ++; 
            }
        }
        return (pages <= k) ; 
    }
    public static int findPages(int[] arr, int k) {
        int n = arr.length ; 
        if (k > n) return -1;
        int start = 0 ;
        int end = 0 ; 
        for(int i = 0; i < n ; i++){
            start = Math.max(start , arr[i]); 
            end += arr[i] ; 
        }
        int res = -1 ; 
        while(start <= end){
            int mid = (start + end)/2; 
            if(isPossible(mid, arr, k)){
                res = mid  ;
                end = mid - 1; 
            }
            else {
                start = mid + 1 ; 
            }
        }
        return res; 
    }
}
