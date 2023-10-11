#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int n, vector<int> money) {
    sort(money.begin(), money.end());

    vector<int> dp(n + 1); //dp[i] := i원을 거슬러줄 수 있는 방법의 수 
    dp[0] = 1;
    for (int amount : money) {
        for (int i = amount; i <= n; i++) {
            dp[i] += dp[i - amount];
            dp[i] %= 1000000007;
        }
    }

    return dp[n];
}
