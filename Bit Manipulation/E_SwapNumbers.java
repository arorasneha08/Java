import java.util.*;

public class E_SwapNumbers {
    static List<Integer> get(int a,int b){
        a = a ^ b;
        b = a ^ b ; 
        a = a ^ b; 
        List<Integer> res = new ArrayList<>();
        res.add(a);
        res.add(b);
        return res; 
    }
}
