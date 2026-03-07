package Strings;

class O27_MinFlipsToMakeBinaryStringAlternating {
    public int minFlips(String s) {
        int n = s.length(); 
        int diff1 = 0 ; 
        int diff2 = 0 ; 
        String str = s + s; 
        int res = n ; 
        for(int i = 0 ; i < 2 * n ; i++){
            char exp1 = (i % 2 == 0) ? '0' : '1'; 
            char exp2 = (i % 2 == 0) ? '1' : '0'; 
            if(str.charAt(i) != exp1) diff1 ++; 
            if(str.charAt(i) != exp2) diff2 ++; 

            if(i >= n){
                char leftExp1 = ((i - n) % 2 == 0) ? '0' : '1'; 
                char leftExp2 = ((i - n) % 2 == 0) ? '1' : '0'; 
                if(str.charAt(i - n) != leftExp1) diff1 -- ;
                if(str.charAt(i - n) != leftExp2) diff2 -- ; 
            }
            if(i >= n-1){
                res = Math.min(res , Math.min(diff1 , diff2)); 
            }
        }
        return res; 
    }
}