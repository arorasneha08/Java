package Math;

import java.util.HashMap;

public class O8_FractionToDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0"; 
        StringBuilder res = new StringBuilder(); 
        if(numerator < 0 ^ denominator < 0){
            res.append("-"); 
        }

        long divident = Math.abs(Long.valueOf(numerator)); 
        long divisor = Math.abs(Long.valueOf(denominator)); 
        res.append(divident/divisor); 
        long rem = divident % divisor ; 

        if(rem == 0){
            return res.toString();
        }
        res.append("."); 
        HashMap<Long , Integer> mpp = new HashMap<>(); 
        while(rem != 0){
            if(mpp.containsKey(rem)){
                int idx = mpp.get(rem); 
                res.insert(idx , "("); 
                res.append(")"); 
                break ; 
            }
            mpp.put(rem , res.length());
            rem *= 10 ; 
            res.append(rem /  divisor); 
            rem %= divisor ;
        }
        return res.toString(); 
    }
}
