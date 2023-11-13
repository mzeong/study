#include<iostream>
#include<vector>
using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
        int tc; cin >> tc;
		vector<int> arr(101);
		for (int i = 0; i < 1000; i++) {
			int score; cin >> score;
			arr[score]++;
		}
		int answer = 0;
		for (int i = 100; i >= 0; i--) {
			if (arr[answer] < arr[i]) answer = i;
		}
		cout << "#" << test_case << " " << answer << "\n";
	}
	return 0;
}
