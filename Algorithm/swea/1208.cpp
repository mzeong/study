#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main(int argc, char** argv)
{
	for (int test_case = 1; test_case <= 10; ++test_case)
	{
		int k; cin >> k;
		vector<int> len(101);
		int s = 101, e = 0;
		for (int i = 0; i < 100; i++) {
			int input; cin >> input;
			len[input]++;
			s = min(s, input);
			e = max(e, input);
		}

		while (k > 0 && e - s > 1) {
			len[s]--;
			len[s + 1]++;
			len[e]--;
			len[e - 1]++;
			k--;
			while (len[s] == 0) s++;
			while (len[e] == 0) e--;
		}
		cout << "#" << test_case << " " << e - s << "\n";
	}
	return 0;
}
