package Strings;

public class O17_LongestPalindromicSubsequences {
    private String func(int left , int right , String s){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left -- ; 
            right ++; 
        }
        return s.substring(left + 1 , right); 
    }
    public String longestPalindrome(String s) {
        int n = s.length() ;
        String res = "" ; 
        if(n == 0 || s == null) return "" ; 

        for(int i = 0 ; i < n ; i++){
            String odd = func(i , i , s); 
            String even = func(i , i + 1 , s); 
            if(odd.length() > res.length()){
                res = odd ; 
            }
            if(even.length() > res.length()){
                res = even ; 
            }
        }
        return res;  
    }
}
