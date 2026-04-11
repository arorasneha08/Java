public class O5_MedianSortedArrays {
    public double medianOf2(int a[], int b[]) {
        int n = a.length ; 
        int m = b.length ; 
        if(n > m) return medianOf2(b , a); 
        
        int len = n + m ; 
        int left = (n + m + 1)/2; 
        
        int start = 0 ;
        int end = n ; 
        
        while(start <= end){
            int mid1 = start + (end - start)/2 ; 
            int mid2 = left - mid1 ; 
            
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE ;
            int r1 = Integer.MAX_VALUE , r2 = Integer.MAX_VALUE; 
            
            if(mid1 - 1 >= 0) l1 = a[mid1 - 1];
            if(mid2 - 1 >= 0) l2 = b[mid2 - 1]; 
            if(mid1 < n) r1 = a[mid1]; 
            if(mid2 < m) r2 = b[mid2]; 
            
            if(l1 <= r2 && l2 <= r1){
                if(len % 2 == 0){
                    return (Math.max(l1 , l2) + Math.min(r1 , r2)) / 2.0;
                }
                else{
                    return Math.max(l1 , l2); 
                }
            }
            else if(l1 > r2){
                end = mid1 - 1 ;  
            }
            else{
                start = mid1 + 1; 
            }
        }
        return 0 ; 
    }
}
