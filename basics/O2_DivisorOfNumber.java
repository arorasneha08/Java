package basics;

import java.util.ArrayList;
import java.util.Collections;

public class O2_DivisorOfNumber {
    public ArrayList<Integer> getDivisors(int n) {
        ArrayList<Integer> res = new ArrayList<>(); 
        for(int i = 1 ; i * i <= n; i++){
            if(n % i == 0){
                res.add(i); 
                if(i != n / i){
                    res.add(n / i); 
                }
            }
        }
        Collections.sort(res) ;
        return res; 
    }
}