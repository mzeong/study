#include <bits/stdc++.h>
const int MOD = 1000000;
using namespace std;

int main()
{
    string str; cin >> str;
    int len = str.length();
    vector<int> code(len + 1);
    for (int i = 1; i <= len; i++) {
        code[i] = str[i - 1] - '0';
    }

    vector<int> dp(len + 1);
    dp[0] = 1;
    for (int i = 1; i <= len; i++) {
        if (code[i] != 0) dp[i] = (dp[i] + dp[i - 1]) % MOD;
        int x = code[i - 1] * 10 + code[i];
        if (10 <= x && x <= 26) dp[i] = (dp[i] + dp[i - 2]) % MOD;
    }
    cout << dp[len];
    return 0;
}
