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
        long res = n ; 
        long left = 0 , right = n-1 ; 
        while(left <= right){
            long mid = left + (right - left) / 2 ; 
            if(arr[mid] > target){
                res = mid; 
                right = mid - 1;
            }
            else{
                left = mid + 1; 
            }
        }
        cout << res << endl ;
    }

    return 0;
}

// print the maximum index of an array element not greater than the given one.