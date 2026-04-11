#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
    vector<int> firstNegInt(vector<int>& arr, int k) {
        int n = arr.size(); 
        vector<int> res;
        queue<int> q;

        for(int i = 0; i < k; i++){
            if(arr[i] < 0){
                q.push(i); 
            }
        }

        if(q.empty()) res.push_back(0); 
        else res.push_back(arr[q.front()]); 

        for(int i = k; i < n; i++){
            while(!q.empty() && q.front() <= i - k){
                q.pop(); 
            }

            // Add current element
            if(arr[i] < 0) q.push(i); 

            // Store result
            if(q.empty()) res.push_back(0);
            else res.push_back(arr[q.front()]); 
        }

        return res; 
    }
};