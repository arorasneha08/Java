public class O4_NthRootM {
    private long func(int mid , int n , int m){
        long ans = 1 ; 
        for(int i = 0 ; i < n ; i++){
            ans = ans * mid; 
            if (ans > m) return ans;
        }
        return ans ; 
    }
    public int nthRoot(int n, int m) {
        int start = 1; 
        int end = m ; 
        while(start <= end){
            int mid = (start + end)/2 ; 
            long midElem = func(mid , n, m); 
            if(midElem == m){
                return mid; 
            }
            else if(midElem < m){
                start = mid + 1; 
            }
            else{
                end = mid - 1; 
            }
        }
        return -1 ; 
    }
}
