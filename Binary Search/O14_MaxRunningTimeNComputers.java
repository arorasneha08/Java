public class O14_MaxRunningTimeNComputers {
    private boolean func(long mid , int n , int arr[]){
        long time = 0 ;
        for(int i = 0 ; i < arr.length ; i++){
            time += Math.min((long)arr[i] , mid); 
        }
        if(time >= mid * n) return true; 
        return false; 
    }
    public long maxRunTime(int n, int[] arr) {
        long total = 0 ;
        for(int num : arr){
            total += num ; 
        }
        long res = 0 ; 
        long low = 0 ;
        long high = total / n ;
        while(low <= high){
            long mid = low + (high - low)/2 ;
            if(func(mid , n , arr)){
                res = mid ; 
                low = mid + 1;
            }
            else{
                high = mid - 1; 
            }
        }
        return res ; 
    }
}

//leetcode 2141 