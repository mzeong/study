#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
#include<math.h>
using namespace std;

int answer = 0;

void dfs(int k, int now, vector<int> numbers) {
	if (k == 0) {
		int number = 0;
		for (int i = 0; i < numbers.size(); i++) {
			number += numbers[i] * pow(10, numbers.size() - i - 1);
		}
		answer = max(answer, number);
		return;
	} 

	for (int i = now; i < numbers.size() - 1; i++) {
		for (int j = i + 1; j < numbers.size(); j++) {
			int src = numbers[i];
			int trg = numbers[j];
			numbers[i] = trg;
			numbers[j] = src;
			dfs(k - 1, i, numbers);
			numbers[i] = src;
			numbers[j] = trg;
		}
	}

}

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	
	for (test_case = 1; test_case <= T; ++test_case)
	{
		string str; cin >> str;
		int k; cin >> k;
		vector<int> numbers(str.length());
		for (int i = 0; i < str.length(); i++) {
			numbers[i] = str[i] - '0';
		}

		k = min(k, (int)numbers.size());
		dfs(k, 0, numbers);

		cout << "#" << test_case << " " << answer << "\n";
		answer = 0;
	}
	return 0;
}
