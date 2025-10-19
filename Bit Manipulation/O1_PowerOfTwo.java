public class O1_PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false; 
        int val = n & (n-1) ;
        if(val == 0) return true;
        return false ;  
    }
}
