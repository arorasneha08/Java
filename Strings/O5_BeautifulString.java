package Strings;

public class O5_BeautifulString {
    private static String generateString(int n , boolean flag){
        String res = "" ; 
        if(flag){
            res += '0'; 
            for(int i = 1 ; i< n ; i++){
                if(res.charAt(i-1) == '0'){
                    res += '1'; 
                }
                else{
                    res += '0'; 
                }
            }
        }
        else{
            res += '1'; 
            for(int i = 1 ; i< n ; i++){
                if(res.charAt(i-1) == '0'){
                    res += '1'; 
                }
                else{
                    res += '0'; 
                }
            }
        }
        return res.toString(); 
    }
    public static int makeBeautiful(String str) {
        int n = str.length();
        String s1 = generateString(n, true);
        String s2 = generateString(n, false); 
        int diff1 = 0 ; 
        int diff2 = 0 ; 
        for(int i = 0 ; i < n ; i++){
            if(s1.charAt(i) != str.charAt(i)){
                diff1 ++; 
            }
            if(s2.charAt(i) != str.charAt(i)){
                diff2 ++; 
            }
        }
        return Math.min(diff1 , diff2); 
    }
}
