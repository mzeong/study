#include <iostream>
#include <vector>
using namespace std;

#define ll long long

int main()
{
    ios::sync_with_stdio(false); cin.tie(0);
    
    int n, m; cin >> n >> m;
    vector<int> v(n);
    int mn = 1e9;
    for (int i = 0; i < n; i++) {
        cin >> v[i];
        mn = min(mn, v[i]);
    }
    
    ll left = 1, right = 1LL * mn * m;
    ll answer = right;
    while (left <= right) {
        ll mid = (left + right) / 2;
        
        ll cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += mid / v[i];
        }
        
        if (cnt < m) {
            left = mid + 1;
        } else {
            right = mid - 1;
            answer = min(answer, mid);
        } 
    }
    cout << answer;

    return 0;
}
