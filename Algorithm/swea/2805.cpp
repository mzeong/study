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
		int n; cin >> n;
		vector<vector<int>> values(n, vector<int>(n));
		int answer = 0;
		for (int i = 0; i < n; i++) {
			int k = abs(i - n/2);
			for (int j = 0; j < n; j++) {
				char c; cin >> c;
				if (k <= j && j < n - k) {
					answer += c - '0';
				}
			}
		}
		cout << "#" << test_case << " " << answer << "\n";
	}
	return 0;
}
