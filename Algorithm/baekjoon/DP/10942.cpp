#include <bits/stdc++.h>

using namespace std;

int main()
{
    ios::sync_with_stdio(false); cin.tie(0);
    
    int n; cin >> n;
    vector<int> num(n + 1);
    for (int i = 1; i <= n; i++) cin >> num[i];
    
    vector<vector<int>> dp(n + 1, vector<int>(n + 1));
    for (int i = 1; i <= n; i++) {
        dp[i][i] = 1;
        dp[i][i + 1] = (num[i] == num[i + 1] ? 1 : 0);
    }
    for (int k = 2; k <= n; k++) {
        for (int i = 1; i + k <= n; i++) {
            if (dp[i + 1][i + k - 1] && num[i] == num[i + k]) dp[i][i + k] = 1;
        }
    }
    
    int m; cin >> m;
    for (int i = 0; i < m; i++) {
        int s, e; cin >> s >> e;
        cout << dp[s][e] << '\n';
    }
    
    return 0;
}
