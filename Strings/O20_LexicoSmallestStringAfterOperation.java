package Strings;

public class O20_LexicoSmallestStringAfterOperation {
    public String getSmallestString(String s, int k) {
        int n = s.length(); 
        if(k == 0) return s; 
        StringBuilder res = new StringBuilder(); 
        
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i); 
            int steps = Math.min(ch - 'a' , 26 - (ch - 'a'));
            if(steps <= k){
                res.append('a'); 
                k-= steps; 
            } 
            else{
                int newVal = ch - k ; 
                if(newVal <= k ) newVal += 26 ; 
                res.append((char)newVal); 
                k = 0 ; 
            }
        }
        return res.toString() ; 
    }
}
