/*
첫 번째 풀이
*/
#include <string>
#include <vector>
#include <algorithm>
using namespace std;
const int mod = 1e9+7;

bool cmp(vector<int> a, vector<int> b) {
    if (a[1] != b[1]) return a[1] < b[1];
    else return a[0] < b[0];
}

int solution(int m, int n, vector<vector<int>> puddles) {
    vector<vector<int>> dp(n+1, vector<int>(m+1));
    int k = 0;
    int puddles_size = puddles.size();
    sort(puddles.begin(), puddles.end(), cmp);
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            if (i == 1 && j == 1) dp[i][j] = 1;
            else if (puddles[k][0] == j && puddles[k][1] == i) {
                dp[i][j] = 0;
                if (k < puddles_size-1) k++;
            } else dp[i][j] = (dp[i-1][j]%mod + dp[i][j-1]%mod)%mod;
        }
    }
    return dp[n][m];
}

/*
두 번째 풀이
*/
#include <string>
#include <vector>
#include <algorithm>
using namespace std;
const int mod = 1e9+7;

int solution(int m, int n, vector<vector<int>> puddles) {
    vector<vector<int>> dp(n+1, vector<int>(m+1));
    for (auto p : puddles) dp[p[1]][p[0]] = -1;
    dp[1][1] = 1;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            if (dp[i][j] == -1) dp[i][j] = 0;
            else dp[i][j] += (dp[i-1][j] + dp[i][j-1]) % mod;
        }
    }
    return dp[n][m];
}
