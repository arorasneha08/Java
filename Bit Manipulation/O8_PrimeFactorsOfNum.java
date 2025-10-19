import java.util.HashSet;

public class O8_PrimeFactorsOfNum {
    private boolean isPrime(int n){
        if(n <= 1) return false;
        for(int i = 2; i * i <= n ; i++){
            if(n % i == 0){
                return false; 
            }
        }
        return true; 
    }
    public int distinctPrimeFactors(int[] arr) {
        HashSet<Integer> primes = new HashSet<>();
        for(int i = 2 ; i <= 10000 ; i++){
            if(isPrime(i)){
                primes.add(i); 
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(int num : arr){
            for(int p : primes){
                if(num % p == 0){
                    set.add(p); 
                    while(num % p == 0){
                        num = num / p ; 
                    }
                }
            }
        }
        return set.size(); 
    }
}
