#include <bits/stdc++.h>

using namespace std;

int main()
{
    int n, t; cin >> n >> t;
    vector<int> d(n), m(n);
    int m_sum = 0;
    for (int i = 0; i < n; i++) {
        cin >> d[i] >> m[i];
        m_sum += m[i];
    }
    
    vector<vector<int>> dp(n + 1, vector<int>(t + 1, 0));
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= t; j++) {
            if (j - d[i - 1] < 0) {
                dp[i][j] = dp[i - 1][j];
            } else {
                dp[i][j] = max(
                    dp[i - 1][j - d[i - 1]] + m[i - 1],     //문제 i를 풀기
                    dp[i - 1][j]);                          //문제 i를 풀지 않기
            }
        }
    }
    cout << m_sum - dp[n][t];
    return 0;
}
