package Strings;

public class O10_LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        int n = name.length() ;
        int m = typed.length(); 
        int i = 0, j = 0 ; 
        while(i < n && j < m){
            if(name.charAt(i) != typed.charAt(j)){
                return false ;
            }
            int cnt1 = 0 ; 
            int cnt2 = 0  ;
            char ch = name.charAt(i); 
            while(i < n && name.charAt(i) == ch){
                cnt1 ++; 
                i++; 
            }
            while(j < m && typed.charAt(j) == ch) {
                cnt2 ++; 
                j++; 
            }
            if(cnt2 < cnt1) return false; 
        }
        if(i == n && j == m) return true ;
        return false; 
    }
}
