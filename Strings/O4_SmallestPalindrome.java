package Strings;

public class O4_SmallestPalindrome {
    public String smallestPalindrome(String s) {
        int n = s.length(); 
        int freq[] = new int[26]; 
        for(int i = 0 ; i < s.length() ; i++){
            freq[s.charAt(i) - 'a'] ++; 
        }
        int odd = 0  ;
        char oddChar = 0; 
        for(int i = 0 ; i < 26 ; i++){
            if(freq[i] % 2 != 0){
                odd ++; 
                oddChar = (char) (i + 'a'); 
            }
        }
        if(odd > 1) return ""; 
        char res[] = new char[n]; 
        int left = 0 ; 
        int right = n-1;

        for(int i = 0 ; i< 26 ; i++){
            if(freq[i] == 0) continue; 
            char ch = (char) (i + 'a'); 
            while(freq[i] >= 2){
                res[left++] = ch ; 
                res[right--] = ch ; 
                freq[i] -= 2; 
            }
        }
        if(odd == 1){
            res[left] = oddChar; 
        }
        return new String(res); 
    }
}

// leetcode 23517 