#include <bits/stdc++.h>
using namespace std;
const int n_ = 1e6 + 1;

int dp[n_], mx;

int main()
{
    ios::sync_with_stdio(false); cin.tie(NULL);
    
    // 연속으로 증가하는 LIS에 포함되지 않는 어린이들이 이동
    int n; cin >> n;
    for (int i = 0; i < n; i++) {
        int x; cin >> x;
        dp[x] = dp[x - 1] + 1;
        mx = max(mx, dp[x]);
    }
    cout << n - mx;
    return 0;
}
