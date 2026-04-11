#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
    vector<int> maxOfSubarrays(vector<int>& arr, int k) {
        int n = arr.size(); 
        vector<int> res ;
        deque<int> q ; 
        
        for(int i = 0 ; i < n ; i++){
            if(!q.empty() && q.front() == i- k ){
                q.pop_front(); 
            }
            while(!q.empty() && arr[i] > arr[q.back()]){
                q.pop_back(); 
            }
            q.push_back(i); 
            if(i >= k - 1){
                res.push_back(arr[q.front()]); 
            }
        }
        return res; 
    }
};