#include <iostream>
#include <vector>
using namespace std;

int main(int argc, char** argv) 
{
	int test_case;
	int T;
	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		int n; cin >> n;
		vector<int> arr(n);
		for (int i = 0; i < n; i++) {
			cin >> arr[i];
		}
		long long answer = 0;
		int max = -1;
		for (int j = n - 1; j >= 0; j--) {
			if (arr[j] > max) max = arr[j];
			else if (arr[j] < max) answer += max - arr[j];
		}
		cout << "#" << test_case << " " << answer << "\n";
	}
	return 0;
}
