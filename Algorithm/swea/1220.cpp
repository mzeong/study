#include<iostream>
#include<vector>
#include<stack>
using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T = 10;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		int n; cin >> n;
		vector<vector<int>> arr(n, vector<int>(n));
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cin >> arr[i][j];
			}
		}

		int answer = 0;
		for (int j = 0; j < n; j++) { //열
			stack<int> st;
			for (int i = 0; i < n; i++) { //행
				if (st.empty() && arr[i][j] == 2) continue;
				if (arr[i][j] == 0) continue;
				if (st.empty() || st.top() != arr[i][j]) {
					st.push(arr[i][j]);
				}
			}
			answer += st.size() / 2;
		}
		cout << "#" << test_case << " " << answer << "\n";
	}
	return 0;
}