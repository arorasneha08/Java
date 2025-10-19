package Strings;

public class O11_DecryptStringToNumber {
    public String freqAlphabets(String s) {
        int n = s.length() ;
        StringBuilder res = new StringBuilder() ;
        int i = n-1 ; 
        while(i >= 0){
            char ch = s.charAt(i); 
            if(ch == '#'){
                int num = Integer.parseInt(s.substring(i-2 , i)); 
                res.append((char) (num + 'a' - 1)); 
                i -= 3 ; 
            }
            else{
                int num = s.charAt(i) - '0' ; 
                res.append((char) ('a' + num - 1)) ; 
                i -- ;
            }
        }
        return res.reverse().toString(); 
    }
}
