import java.util.*;

public class O6_PrimeFactorUsingSieve {
    static List<Integer> findPrimeFactors(int N) {
        List<Integer> res = new ArrayList<>();
        int primes[] = new int[N+1] ;
        Arrays.fill(primes , 1); 
        
        for(int i = 2 ; i * i <= N ; i++){
            if(primes[i] == 1){
                for(int j = i * i ; j <= N ; j+= i){
                    primes[j] = 0 ; 
                }
            }
        }
        for(int i = 2 ; i <= N ; i++){
            if(primes[i] == 1 && N % i == 0){
                while(N % i == 0){
                    res.add(i); 
                    N /= i ;
                }
            }
        }
        if(N > 1) res.add(N); 
        return res; 
    }
}
