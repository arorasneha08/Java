package Strings;

import java.util.HashMap;

public class O7_IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length(); 
        int m = t.length(); 
        if(n != m) return false;
        HashMap<Character , Character> mpp = new HashMap<>(); 

        for(int i = 0 ; i < n ; i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i); 
            if(mpp.containsKey(ch1)){
                if(mpp.get(ch1) != ch2){
                    return false; 
                }
            }
            else if(mpp.containsValue(ch2)){
                return false ; 
            }
            mpp.put(ch1 , ch2) ;
        } 
        return true; 
    }
}

// leetcode 205 