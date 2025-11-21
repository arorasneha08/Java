import java.util.*;

public class O3_ReplaceNonCoPrimeArray {
    private int gcd(int a , int b){
        if(b == 0) return a ; 
        return gcd(b , a % b); 
    }
    public List<Integer> replaceNonCoprimes(int[] arr) {
        List<Integer> list = new ArrayList<>() ;
        for(int num : arr){
            while(!list.isEmpty()){
                int top = list.get(list.size()-1); 
                int gcd = gcd(top , num); 
                if(gcd == 1) break ; 
                list.remove(list.size()-1); 
                num = num * (top / gcd); 
            }
            list.add(num); 
        }
        return list; 
    }
}
