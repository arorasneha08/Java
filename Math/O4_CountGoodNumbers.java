package Math;

public class O4_CountGoodNumbers {
    int mod = (int) 1e9 + 7 ; 

    private long power(long x , long n){
        if(n == 0) return 1  ; 
        long temp = power(x , n/2); 
        if(n % 2 == 0){
            return (temp * temp) % mod ; 
        }
        else{
            return (x * temp * temp) % mod; 
        }
    }
    public int countGoodNumbers(long n) {
        long evenPos = (n + 1)/2 ; 
        long oddPos = n / 2 ;
        long oddWays = power(4, oddPos); 
        long evenWays = power(5, evenPos); 
        return (int)((oddWays * evenWays) % mod) ;  
    }
}
