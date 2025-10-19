package DP;

public class O50_PalindromePartitioningII {
    private boolean isPalindrome(String s){
        int n = s.length(); 
        int left = 0 ; 
        int right = n-1; 
        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false; 
            left ++; 
            right -- ; 
        }
        return true; 
    }
    private boolean isPalindrome2(int left , int right , String s){
        int n = s.length(); 
        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false; 
            left ++; 
            right -- ; 
        }
        return true; 
    }
    private int func(int i , String s , int dp[]){
        if(i == s.length()) return 0 ; 
        if(dp[i] != -1) return dp[i]; 
        String temp = "" ; 

        int min = Integer.MAX_VALUE; 
        for(int j = i ; j < s.length() ; j++){
            temp += s.charAt(j);    
            if(isPalindrome(temp)){
                int cost = 1 + func(j + 1,  s, dp); 
                min = Math.min(min , cost); 
            }
        }
        return dp[i] = min ; 
    }
    public int minCut(String s) {
        int n = s.length() ; 
        // int dp[] = new int[n]; 
        // Arrays.fill(dp , -1); 
        // return func(0 , s, dp) - 1 ; 

        int dp[] = new int[n+1]; 
        for(int i = n-1 ; i >= 0 ; i--){
            int min = Integer.MAX_VALUE; 
            for(int j = i ; j < n ; j ++){
                if(isPalindrome2(i , j , s)){
                    int cost = 1 + dp[j+1];
                    min = Math.min(min , cost); 
                }
            }
            dp[i] = min ; 
        }
        return dp[0] - 1 ;
    }
}
