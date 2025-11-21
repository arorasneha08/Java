
import java.util.*;

public class O12_HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>(); 
        while(n != 1){
            int sum = 0 ; 
            while(n > 0){
                int r = n % 10; 
                sum += r * r ; 
                n = n / 10 ; 
            }
            if(set.contains(sum)) return false; 
            set.add(sum); 
            n = sum ; 
        }
        return true; 
    }
}
