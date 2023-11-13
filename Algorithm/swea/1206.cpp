#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main(int argc, char** argv)
{
	for (int test_case = 1; test_case <= 10; ++test_case)
	{
		int n; cin >> n;
		vector<int> arr(n);
		for (int i = 0; i < n; i++) {
			cin >> arr[i];
		}

		int answer = 0;
		for (int i = 2; i < n - 2; i++) {
			int left = max(arr[i - 1], arr[i - 2]);
			int right = max(arr[i + 1], arr[i + 2]);
			int maxLen = max(left, right);
			answer += max(arr[i] - maxLen, 0);
		}
		cout << "#" << test_case << " " << answer << "\n";
	}
	return 0;
}
