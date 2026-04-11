#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    long n , k ; 
    cin >> n ;
    vector<long> arr(n) ;
    for(int i = 0 ; i < n ; i++){
        cin >> arr[i]; 
    }
    cin >> k ; 
    sort(arr.begin() , arr.end()) ;
    
    for(int i = 0 ; i < k ; i++){
        long left , right; 
        cin >> left >> right; 
        long res = upper_bound(arr.begin() , arr.end() , right) - lower_bound(arr.begin() , arr.end() , left); 
        cout << res << " " ;
    }
    return 0 ;
}

// count the numbers between the range l and r 