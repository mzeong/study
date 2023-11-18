#include<iostream>
#include<string>
using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		string input; cin >> input;
		bool val = false;
		int answer = 0;
		for (int idx = 0; idx < input.length(); idx++) {
			int target = input[idx] - '0';
			if (target != val) {
				val = !val;
				answer++;
			}
		}
		cout << "#" << test_case << " " << answer << "\n";
	}
	return 0;
}