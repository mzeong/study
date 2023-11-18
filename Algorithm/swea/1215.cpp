#include<iostream>
#include<vector>
using namespace std;

const int n_ = 8;

int n;

int row(int k, vector<vector<char>>& arr) {
	vector<vector<bool>> dp(n_, vector<bool>(n_));
	int answer = 0;
	for (int i = 0; i < n_; i++) { //회문 길이=1
		dp[i][i] = true;
	}
	for (int i = 0; i < n_ - 1; i++) { //회문 길이=2
		dp[i][i + 1] = arr[k][i] == arr[k][i + 1];
	}
	for (int i = 3; i <= n; i++) { //회문 길이
		for (int j = 0; j < n_ - i + 1; j++) { //회문 시작
			dp[j][j + i - 1] = (arr[k][j] == arr[k][j + i - 1] && dp[j + 1][j + i - 2]);
		}
	}
	for (int i = 0; i < n_ - n + 1; i++) {
		answer += dp[i][i + n - 1];
	}
	return answer;
}

int col(int k, vector<vector<char>>& arr) {
	vector<vector<bool>> dp(n_, vector<bool>(n_));
	int answer = 0;
	for (int i = 0; i < n_; i++) { //회문 길이=1
		dp[i][i] = true;
	}
	for (int i = 0; i < n_ - 1; i++) { //회문 길이=2
		dp[i][i + 1] = arr[i][k] == arr[i + 1][k];
	}
	for (int i = 3; i <= n; i++) { //회문 길이
		for (int j = 0; j < n_ - i + 1; j++) { //회문 시작
			dp[j][j + i - 1] = (arr[j][k] == arr[j + i - 1][k] && dp[j + 1][j + i - 2]);
		}
	}
	for (int i = 0; i < n_ - n + 1; i++) {
		answer += dp[i][i + n - 1];
	}
	return answer;
}

int main(int argc, char** argv)
{
	int test_case;
	for (test_case = 1; test_case <= 10; ++test_case)
	{
		cin >> n;
		vector<vector<char>> arr(n_, vector<char>(n_));
		for (int i = 0; i < n_; i++) {
			for (int j = 0; j < n_; j++) {
				cin >> arr[i][j];
			}
		}

		int answer = 0;
		for (int i = 0; i < n_; i++) {
			answer += row(i, arr);
			answer += col(i, arr);
		}

		cout << "#" << test_case << " " << answer << "\n";
	}
	return 0;
}