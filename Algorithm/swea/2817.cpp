#include<iostream>
#include<vector>
using namespace std;

int n, k, answer;

void func(int idx, int sum, vector<int>& arr) {
	if (idx == n) {
		answer += sum == k;
		return;
	}
	if (sum > k) return;

	func(idx + 1, sum, arr);
	func(idx + 1, sum + arr[idx], arr);
}

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	
	for (test_case = 1; test_case <= T; ++test_case)
	{
		cin >> n >> k;
		vector<int> arr(n);
		for (int i = 0; i < n; i++) {
			cin >> arr[i];
		}

		answer = 0;
		func(0, 0, arr);
		cout << "#" << test_case << " " << answer << "\n";
	}
	return 0;
}