package basics;

public class O3_CheckPrime {
    static boolean isPrime(int n) {
        // int prime[] = new int[n + 1];
        if(n == 1) return false; 
        // Arrays.fill(prime , 1); 
        // for(int i = 2 ; i * i <= n ; i++){
        //     if(prime[i] == 1){
        //         for(int j = i * i  ; j <= n ; j+= i){
        //             prime[j] = 0 ; 
        //         }
        //     }
        // }
        // if(prime[n] == 1) return true; 
        // return false; 
        
        for(int i = 2 ; i * i <= n ; i++){
            if(n % i == 0) return false; 
        }
        return true; 
    }
}
