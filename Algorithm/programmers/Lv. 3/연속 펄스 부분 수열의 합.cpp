#include <string>
#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

long long solution(vector<int> sequence) {
    int n = sequence.size();

    for (int i = 1; i < n; i += 2) {
        sequence[i] *= -1;
    }

    vector<vector<long long>> dp(n, vector<long long>(2, 0));
    dp[0][0] = sequence[0];
    dp[0][1] = sequence[0];

    for (int i = 1; i < n; i++) {
        dp[i][0] = min((long long)sequence[i], sequence[i] + dp[i - 1][0]);
        dp[i][1] = max((long long)sequence[i], sequence[i] + dp[i - 1][1]);
    }

    long long min_val = LLONG_MAX, max_val = LLONG_MIN;
    for (int i = 0; i < n; i++) {
        min_val = min(min_val, dp[i][0]);
        max_val = max(max_val, dp[i][1]);
    }

    return max(abs(min_val), max_val);
}
