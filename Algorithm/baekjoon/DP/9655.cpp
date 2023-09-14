#include <bits/stdc++.h>

using namespace std;

int main()
{
    int n; cin >> n;
    vector<int> dp(n + 1); // 1이면 상근 승, 0이면 상근 패 
    
    dp[1] = 1;
    dp[2] = 0;
    dp[3] = 1;
    for (int i = 4; i <= n; i++) {
        if (!dp[i - 1] || !dp[i - 3]) dp[i] = 1;
    }
    cout << (dp[n] ? "SK" : "CY");
    return 0;
}
