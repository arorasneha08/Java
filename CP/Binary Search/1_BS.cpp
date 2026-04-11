#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    long n , k ; 
    cin >> n >> k ; 
    vector<long> arr(n) ;
    for(int i = 0 ; i < n ; i++){
        cin >> arr[i]; 
    }
    long target ;
    
    for(int i = 0 ; i < k ; i++){
        cin >> target; 
        bool found = false ;
        long left = 0 , right = n-1 ; 
        while(left <= right){
            long mid = left + (right - left) / 2 ; 
            if(arr[mid] == target){
                found = true ; 
                break; 
            }
            else if(arr[mid] < target){
                left = mid + 1; 
            }
            else{
                right = mid - 1; 
            }
        }
        if(found){
            cout << "YES" << endl;
        }
        else{
            cout << "NO" << endl;
        }
    }

    return 0;
}

// basic binary search
