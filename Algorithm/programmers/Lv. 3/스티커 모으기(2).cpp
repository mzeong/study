#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> sticker)
{
    int n = sticker.size();
    if (n == 1) return sticker[0];
    vector<int> dp(n);

    dp[0] = 0;
    for (int i = 1; i < n; i++) {
        dp[i] = max(dp[i-1], dp[i-2] + sticker[i]);
    }
    int answer = dp[n-1];
    
    dp[0] = sticker[0];
    dp[1] = dp[0];
    for (int i = 2; i < n - 1; i++) {
        dp[i] = max(dp[i-1], dp[i-2] + sticker[i]);
    }
    answer = max(answer, dp[n-2]);
    return answer;
}
