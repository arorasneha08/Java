#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> getSubarrayBeauty(vector<int>& arr, int k, int x) {
        int n = arr.size(); 
        vector<int> res(n - k + 1) ;
        vector<int> freq(101 , 0); 
        for(int i = 0 ; i < k ; i++){
            freq[arr[i] + 50] ++ ;
        } 

        for(int i = k ; i <= n ; i++){
            int cnt = 0 ; 
            int beauty = 0; 

            for(int j = 0 ; j < 50 ; j++){
                cnt += freq[j]; 
                if(cnt >= x){
                    beauty = j - 50 ; 
                    break ; 
                }
            }
            res[i - k] = beauty; 
            if(i == n) break ; 
            freq[arr[i- k] + 50] -- ; 
            freq[arr[i] + 50] ++; 
        }
        return res; 
    }
};