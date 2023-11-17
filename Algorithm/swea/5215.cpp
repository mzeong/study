#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		int n, l; cin >> n >> l;
		vector<int> score(n + 1), cal(n + 1);
		for (int i = 1; i <= n; i++) {
			cin >> score[i] >> cal[i];
		}

		vector<vector<int>> dp(n + 1, vector<int>(l + 1));
		for (int i = 1; i <= n; i++) { //20
			for (int j = 1; j <= l; j++) { //10000
				if (j - cal[i] < 0) {
					dp[i][j] = dp[i - 1][j];
				}
				else {
					dp[i][j] = max(
						dp[i - 1][j],
						dp[i - 1][j - cal[i]] + score[i]
					);
				}
			}
		}
		cout << "#" << test_case << " " << dp[n][l] << "\n";
	}
	return 0;
}
