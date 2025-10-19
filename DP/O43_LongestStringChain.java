package DP;

import java.util.Arrays;
import java.util.Comparator;

public class O43_LongestStringChain {
    private boolean isPossible(String s1, String s2){
        if(s1.length() != s2.length()-1) return false; 
        int i = 0 , j = 0 ; 
        while(i < s1.length() && j < s2.length()){
            if(s1.charAt(i) == s2.charAt(j)){
                i ++; 
            }
            j ++; 
            if(j - i > 1) return false; 
        }
        return i == s1.length() ;
    }
    public int longestStrChain(String[] words) {
        int n = words.length ; 
        Arrays.sort(words , Comparator.comparingInt(String::length)); 
        int dp[] = new int[n];
        Arrays.fill(dp , 1); 
        int max = Integer.MIN_VALUE; 
        for(int i = 0 ; i < n ; i ++){
            for(int prev = 0 ; prev < i ; prev ++){
                if(isPossible(words[prev] , words[i])){
                    dp[i] = Math.max(dp[i] , 1 + dp[prev]); 
                }
            }
            max = Math.max(max , dp[i]); 
        }
        return max ; 
    }
}
