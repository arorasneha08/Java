
public class O16_NumSubstringsWithOnlyOnes {
    public int numSub(String s) {
        int n = s.length(); 
        int mod = (int) 1e9+7 ; 
        int ones = 0  ; 
        long count = 0 ; 
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if(ch == '1'){
                ones ++ ; 
            }
            else {
                count = (count + (long) ones * (ones + 1)/ 2 % mod) % mod;  
                ones = 0 ; 
            }
        }
        count = (count + (long) ones * (ones + 1) / 2 % mod) % mod; 
        return (int) count ;
    }
}

// leetcode 1513    