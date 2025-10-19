import java.util.ArrayList;

public class O4_FindTwoOddNum {
    ArrayList<Integer> twoOddNum(int[] arr) {
        int n = arr.length ; 
        ArrayList<Integer> res = new ArrayList<>(); 
        int xor = 0 ;
        for(int i = 0 ; i < n ; i++){
            xor ^= arr[i]; 
        }
        int a = 0 ;
        int b = 0 ; 
        int rightmost = xor & -xor; 
        for(int i = 0 ; i< n ; i++){
            if((arr[i] & rightmost) == 0){
                a ^= arr[i]; 
            }
            else{
                b ^= arr[i]; 
            }
        }
        if(a > b) {
            res.add(a); 
            res.add(b);    
        }
        else{
            res.add(b);
            res.add(a); 
        }
        return res; 
    }
}
