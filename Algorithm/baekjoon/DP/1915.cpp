#include <bits/stdc++.h>

using namespace std;

int main()
{
    int n, m; cin >> n >> m;
    vector<vector<int>> arr(n + 1, vector<int>(m + 1));
    for (int i = 1; i <= n; i++) {
        string input; cin >> input;
        
        for (int j = 1; j <= m; j++) {
            arr[i][j] = input[j - 1] - '0';
        }
    }
    
    int answer = 0;
    vector<vector<int>> dp(n + 1, vector<int>(m + 1));
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            dp[i][j] = arr[i][j];
            if (dp[i][j]) dp[i][j] += min({dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]});
            answer = max(answer, dp[i][j]);
        }
    }
    cout << pow(answer, 2);
    
    return 0;
}
