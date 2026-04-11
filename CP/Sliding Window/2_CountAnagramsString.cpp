// User function template for C++
#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
    int search(string &pat, string &txt) {
        int n = pat.size(); 
        int m = txt.size(); 
        
        vector<int> freq1(26 , 0) ; 
        vector<int> freq2(26 , 0) ; 
        
        int count = 0 ; 
        
        for(int i = 0 ; i < n ; i++){
            freq1[pat[i] - 'a'] ++;  
        }
        int k = n ; 
        for(int i = 0 ; i < m ; i++){
            freq2[txt[i] - 'a'] ++ ; 
            
            if(i >= k){
                freq2[txt[i-k] - 'a'] -- ;
            }
            
            if(freq1 == freq2) count ++; 
        }
        return count; 
    }
};