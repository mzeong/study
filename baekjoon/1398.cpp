#include <bits/stdc++.h>
using namespace std;

int dp[100];

int main()
{
    ios::sync_with_stdio(false); cin.tie(NULL);
    
    for (int i = 1; i < 100; i++) {
        dp[i] = dp[i - 1] + 1;
        if (i >= 10) dp[i] = min(dp[i], dp[i - 10] + 1);
        if (i >= 25) dp[i] = min(dp[i], dp[i - 25] + 1);
    }
    
    int t; cin >> t;
    while (t--) {
        long long p; cin >> p;
        int cnt = 0;
        while (p) {
            cnt += dp[p % 100];
            p /= 100;
        }
        cout << cnt << "\n";
    }
    return 0;
}
