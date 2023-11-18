#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

const int n_ = 100;

int main(int argc, char** argv)
{
	int test_case;
	int T = 10;
	
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int tc; cin >> tc;
		vector<vector<int>> arr(n_, vector<int>(n_));
		for (int i = 0; i < n_; i++) {
			for (int j = 0; j < n_; j++) {
				cin >> arr[i][j];
			}
		}

		vector<int> row(n_), col(n_), dia(2);
		for (int i = 0; i < n_; i++) {
			for (int j = 0; j < n_; j++) {
				row[i] += arr[i][j];
				col[j] += arr[i][j];
				if (i == j) dia[0] += arr[i][j]; //왼 대각선
				if (i + j == n_ - 1) dia[1] += arr[i][j]; //오른 대각선
			}
		}

		sort(row.begin(), row.end());
		sort(col.begin(), col.end());
		int answer = max({ row[n_ - 1], col[n_ - 1], dia[0], dia[1] });

		cout << "#" << test_case << " " << answer << "\n";
	}
	return 0;
}