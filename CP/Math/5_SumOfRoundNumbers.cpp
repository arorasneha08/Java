#include <bits/stdc++.h>
using namespace std;


int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;

    while (t--) {
        int n ; 
        cin >> n ; 
        vector<int> ans ;
        vector<int> v = {10 , 100 , 1000 , 10000 , 100000};
        for(int i = 0 ; i< v.size() ; i++){
            if(n % v[i] != 0){
                ans.push_back(n % v[i]);
                n -= n % v[i];
            }
        }
        cout << ans.size() << endl;
        for(int i = 0 ; i< ans.size() ; i++){
            cout << ans[i] << " " ;
        }
    }

    return 0;
}