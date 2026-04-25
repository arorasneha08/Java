#include <bits/stdc++.h>
using namespace std;

bool canMake(vector<int>& arr, long long time, long long t) {
    long long products = 0;

    for (int num : arr) {
        products += time / num;
        if (products >= t) return true; 
    }

    return false;
}

int main() {
    int n;
    long long t;
    cin >> n >> t;

    vector<int> arr(n);
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    long long start = 1;
    long long end = *min_element(arr.begin(), arr.end()) * t;

    long long ans = end;

    while (start <= end) {
        long long mid = start + (end - start) / 2;

        if (canMake(arr, mid, t)) {
            ans = mid;
            end = mid - 1; 
        } else {
            start = mid + 1;
        }
    }

    cout << ans << endl;
}