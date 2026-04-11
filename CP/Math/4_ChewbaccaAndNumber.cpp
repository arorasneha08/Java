#include <bits/stdc++.h>
#include <iostream>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string s ; 
    cin >> s; 
    string ans = "" ; 
    
    for(int i = 0 ; i< s.size() ; i++){
        char ch = s[i]; 
        int y = ch - '0'; 
        int inverted = 9 - y ; 
        ans += min(y , inverted) + '0';
    }
    if(ans[0] == '0') ans[0] = '9';
    cout << ans << endl;
    return 0 ; 

}