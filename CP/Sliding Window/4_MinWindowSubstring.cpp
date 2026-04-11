#include <bits/stdc++.h>
using namespace std;
class Solution {
  public:
    string minWindow(string &s, string &p) {
        int n = s.size();
        int m = p.size(); 
        vector<int> freq(26 , 0); 
        
        for(int i = 0 ; i< m ; i++){
            freq[p[i] - 'a'] ++; 
        }
        
        int required = m ; 
        int minLen = INT_MAX ;
        int right = 0 , left = 0 ; 
        int start = 0 ; 
        
        while(right < n){
            freq[s[right] - 'a'] -- ; 
            if(freq[s[right] - 'a'] >= 0){
                required -- ; 
            }
            right ++; 
            
            while(required == 0){
                if(right - left < minLen){
                    minLen = right - left; 
                    start = left; 
                }
                char leftChar = s[left]; 
                freq[leftChar - 'a'] ++ ;
                if(freq[leftChar - 'a'] > 0) required ++; 
                left ++; 
            }
        }
        if(minLen == INT_MAX) return ""; 
        return s.substr(start , minLen); 
    }
};