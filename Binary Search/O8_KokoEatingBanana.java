public class O8_KokoEatingBanana {
    private boolean isPossible(int mid , int arr[] , int k){
        int res = 0 ; 
        for(int i = 0 ; i < arr.length ; i++){
            res += Math.ceil((double)arr[i] / mid);  
        }
        if(res <= k) return true; 
        return false; 
    }
    public int minEatingSpeed(int[] arr, int h) {
        int n = arr.length ; 
        int start = 1 ; 
        int end = 0 ; 
        for(int i = 0 ; i < n ; i++){
            end = Math.max(end , arr[i]);  
        }
        int res = 0 ; 
        while(start <= end){
            int mid = (start + end) / 2 ; 
            if(isPossible(mid , arr, h)){
                res = mid ; 
                end = mid - 1; 
            }
            else{
                start = mid + 1; 
            }
        }
        return res ; 
    }
}
